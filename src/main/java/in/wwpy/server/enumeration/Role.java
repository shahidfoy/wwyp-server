package in.wwpy.server.enumeration;

import static in.wwpy.server.constant.Authority.*;

public enum Role {
    ROLE_USER(USER_AUTHORITIES),
    ROLE_HR(HR_AUTHORITIES),
    ROLE_MANAGER(MANAGER_AUTHORITIES),
    ROLE_ADMIN(ADMIN_AUTHORITIES),
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES);

    private final String[] authorities;

    Role(String... authorities) { this.authorities = authorities; }

    public String[] getAuthorities() {
        return authorities;
    }
}
