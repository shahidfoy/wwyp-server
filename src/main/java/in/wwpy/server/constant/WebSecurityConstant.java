package in.wwpy.server.constant;

public class WebSecurityConstant {
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page.";
    public static final String AUTHORITIES = "authorities";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 days in milliseconds
    public static final String FORBIDDEN_MESSAGE = "You need to login in order to access this page.";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = { "/user/login", "/user/register", "/user/resetpassword/**", "/user/image/**" };
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String WWYP_ADMINISTRATION = "What Would You Pay Portal";
    public static final String WWYP_LLC = "What Would You Pay, LLC";
}
