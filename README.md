# What would you pay - server
Another simple social network. Written in Spring boot and Angular \
front-end for project located @wwyp-app

## Requirements
- Java 8 or higher
- Maven
- MySQL 8

## create database for project
Inside your mysql shell, command line or workbench create a new database called `wwyp`
```mysql
CREATE DATABASE wwyp;
```

## file set up:
Add the below java file constants inside 
`src/main/java/in/wwpy/server/constant/EmailConstant.java`
 in order to set up emails.  replace `<your@gmail.com>` & `<your-password>`
with your Gmail username and password.

```java
package in.wwpy.server.constant;

public class EmailConstant {
    public static final String SIMPLE_MAIL_TRANSFER_PROTOCOL = "smtps";
    public static final String USERNAME = "<your@gmail.com>";
    public static final String PASSWORD = "<your-password>";
    public static final String FROM_EMAIL = "support@wwyp.com";
    public static final String CC_EMAIL = "";
    public static final String EMAIL_SENT = "An email with a new password was sent to: ";
    public static final String EMAIL_SUBJECT = "What Would You Pay, LLC - New Password";
    public static final String GMAIL_SMTP_SERVER = "smtp.gmail.com";
    public static final String SMTP_HOST = "mail.smtp.host";
    public static final String SMTP_AUTH = "mail.smtp.auth";
    public static final String SMTP_PORT = "mail.smtp.port";
    public static final int DEFAULT_PORT = 465;
    public static final String SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    public static final String SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
}
```