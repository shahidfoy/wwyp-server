package in.wwpy.server.service;

import in.wwpy.server.exception.type.EmailExistException;
import in.wwpy.server.exception.type.EmailNotFoundException;
import in.wwpy.server.exception.type.UserNotFoundException;
import in.wwpy.server.exception.type.UsernameExistException;
import in.wwpy.server.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User addNewUser(String firstName, String lastName, String username, String email, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException, MessagingException;

    void deleteUser(long id);

    User editUser(String currentEmail, String newFirstName, String newLastName, String newUsername, String newEmail, MultipartFile profileImage) throws UserNotFoundException, EmailExistException, UsernameExistException;

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    List<User> getUsers();

    User register(String firstName, String lastName, String username, String email, String password) throws UsernameExistException, EmailExistException, UserNotFoundException, MessagingException;

    void resetPassword(String email) throws EmailNotFoundException, MessagingException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername, String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

    User updateProfileImage(String username, MultipartFile profileImage) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;
}
