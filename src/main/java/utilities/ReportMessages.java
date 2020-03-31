package utilities;

public class ReportMessages {

    public ReportMessages() { }

    public static String loginSuccessful() { return "Login was successful"; }
    public static String registrationSuccessful() { return "Registration was successful"; }
    public static String newProductAdded(String productName) { return "You have successfully added: " + productName; }
    public static String usernameNotFound(String name) { return "No account was found under the username: " + name; }
    public static String invalidCredentials() { return "Invalid credentials"; }
    public static String usernameOrEmailAlreadyRegistered() { return "The username or email address already in the database"; }
    public static String usernameNotValid() { return "The username must be between 8 and 20 chars, and contain only letters, numbers, ._ characters"; }
    public static String invalidEmail() { return "The email provided does not exist or does not contain match the format"; }
    public static String invalidPassword() { return "The password must be at least 8 chars long, contain lower and upper case letters, special chars and digits!"; }
    public static String areYouSureExit() { return "Are you sure you want to exit?"; }
    public static String passwordsDontMatch() { return "The passwords introduced do not match"; }
    public static String passwordChangedSuccessfully() { return "Your password has been updated successfully"; }
    public static String emailChangedSuccessfully() { return "Your email has been updated successfully"; }


}
