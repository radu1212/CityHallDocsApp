package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static Boolean validatePassword(String password){
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
