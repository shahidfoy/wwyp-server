package in.wwpy.server.service.impl;

import in.wwpy.server.enumeration.Role;
import in.wwpy.server.exception.type.EmailExistException;
import in.wwpy.server.exception.type.EmailNotFoundException;
import in.wwpy.server.exception.type.UserNotFoundException;
import in.wwpy.server.exception.type.UsernameExistException;
import in.wwpy.server.model.User;
import in.wwpy.server.model.UserPrincipal;
import in.wwpy.server.repository.UserRepository;
import in.wwpy.server.service.EmailService;
import in.wwpy.server.service.LoginAttemptService;
import in.wwpy.server.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static in.wwpy.server.constant.UserConstant.*;
import static in.wwpy.server.enumeration.Role.ROLE_USER;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final LoginAttemptService loginAttemptService;
    private final EmailService emailService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, LoginAttemptService loginAttemptService, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loginAttemptService = loginAttemptService;
        this.emailService = emailService;
    }

    /**
     * Used for spring security UserDetailsService
     * loads in the user details
     * @param email user email
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_EMAIL + email);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        } else {
            validateLoginAttempt(user);
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            LOGGER.info(FOUND_USER_BY_EMAIL + email);
            return userPrincipal;
        }
    }

    @Override
    public User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, MessagingException {
        validateNewUsernameAndEmail(EMPTY, username, email);
        User user = new User();
        String password = generatePassword();
        user.setUserId(generateUserId());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setJoinDate(new Date());
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encodePassword(password));
        user.setActive(isActive);
        user.setNotLocked(isNonLocked);
        user.setRole(getRoleEnumName(role).name());
        user.setAuthorities(getRoleEnumName(role).getAuthorities());
        user.setProfileImageUrl(getTemporaryProfileImageUrl(username));
        userRepository.save(user);
        emailService.sendNewPasswordEmail(firstName, password, email);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User editUser(String currentEmail,
                         String newFirstName,
                         String newLastName,
                         String newUsername,
                         String newEmail,
                         boolean isDarkModeEnabled,
                         MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException {
        User currentUser = validateNewUsernameAndEmail(currentEmail, newUsername, newEmail);
        currentUser.setFirstName(newFirstName);
        currentUser.setLastName(newLastName);
        currentUser.setUsername(newUsername);
        currentUser.setEmail(newEmail);
        currentUser.setDarkModeEnabled(isDarkModeEnabled);
        // TODO:: USE CLOUDINARY TO STORE PROFILE IMAGES
        // saveProfileImage(currentUser, profileImage);
        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public User findUserByEmail(String email) { return userRepository.findUserByEmail(email); }

    @Override
    public User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(optionalUser::get);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String getUserProfileImageByUserId(Long id) {
        User user = findUserById(id);
        return user.getProfileImageUrl();
    }

    @Override
    public String getUserProfileImageByUsername(String username) {
        User user = findUserByUsername(username);
        return user.getProfileImageUrl();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User register(String firstName, String lastName, String username, String email, String password) throws UserNotFoundException, UsernameExistException, EmailExistException, MessagingException {
        validateNewUsernameAndEmail(EMPTY, username, email);
        User user = new User();
        user.setUserId(generateUserId());
        String encodedPassword = encodePassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setJoinDate(new Date());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.setNotLocked(true);
        user.setRole(ROLE_USER.name());
        user.setAuthorities(ROLE_USER.getAuthorities());
        user.setProfileImageUrl(getTemporaryProfileImageUrl(username));
        userRepository.save(user);
        LOGGER.info("new user password: " + password);
        return user;
    }

    @Override
    public void resetPassword(String email) throws EmailNotFoundException, MessagingException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new EmailNotFoundException(NO_USER_FOUND_BY_EMAIL + email);
        }
        String password = generatePassword();
        user.setPassword(encodePassword(password));
        userRepository.save(user);
        LOGGER.info("new user password: " + password);
        emailService.sendNewPasswordEmail(user.getFirstName(), password, user.getEmail());
    }

    @Override
    public User updateUser(String currentUsername,
                           String newFirstName,
                           String newLastName,
                           String newUsername,
                           String newEmail,
                           String role,
                           boolean isNonLocked,
                           boolean isActive,
                           boolean isDarkModeEnabled,
                           MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
        User currentUser = validateNewUsernameAndEmail(currentUsername, newUsername, newEmail);
        currentUser.setFirstName(newFirstName);
        currentUser.setLastName(newLastName);
        currentUser.setUsername(newUsername);
        currentUser.setEmail(newEmail);
        currentUser.setActive(isActive);
        currentUser.setNotLocked(isNonLocked);
        currentUser.setRole(getRoleEnumName(role).name());
        currentUser.setAuthorities(getRoleEnumName(role).getAuthorities());
        currentUser.setDarkModeEnabled(isDarkModeEnabled);
        // TODO:: USE CLOUDINARY TO STORE PROFILE IMAGES
        // saveProfileImage(currentUser, profileImage);
        userRepository.save(currentUser);
        return currentUser;
    }

    @Override
    public User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException {
        User user = validateNewUsernameAndEmail(username, null, null);
        saveProfileImage(user, profileImage);
        return user;
    }

    private Role getRoleEnumName(String role) {
        return Role.valueOf(role.toUpperCase());
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    private String generateUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private String getTemporaryProfileImageUrl(String username) {
        return TEMP_PROFILE_IMAGE_BASE_URL + username + TEMP_PROFILE_IMAGE_PARAM_SET;
    }

    // TODO:: USE CLOUDINARY TO STORE PROFILE IMAGES
    private void saveProfileImage(User currentUser, MultipartFile profileImage) {
    }

    private void validateLoginAttempt(User user) {
        if (user.isNotLocked()) {
            if (loginAttemptService.hasExceededMaxAttempts(user.getUsername())) {
                user.setNotLocked(false);
            } else {
                user.setNotLocked(true);
            }
        } else {
            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
        }
    }

    private User validateNewUsernameAndEmail(String currentEmail, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User userByNewUsername = findUserByUsername(username);
        User userByNewEmail = findUserByEmail(email);
        if (StringUtils.isNotBlank(currentEmail)) {
            User currentUser = findUserByEmail(currentEmail);
            if (currentUser == null) {
                throw new UserNotFoundException(NO_USER_FOUND_BY_EMAIL + currentEmail);
            }
            if (userByNewUsername != null && !currentUser.getId().equals(userByNewUsername.getId())) {
                throw new UsernameExistException(USERNAME_ALREADY_EXISTS);
            }
            if (userByNewEmail != null && !currentUser.getId().equals(userByNewEmail.getId())) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return currentUser;
        } else {
            if(userByNewUsername != null) {
                throw new UsernameExistException(USERNAME_ALREADY_EXISTS);
            }
            if(userByNewEmail != null) {
                throw new EmailExistException(EMAIL_ALREADY_EXISTS);
            }
            return null;
        }
    }
}
