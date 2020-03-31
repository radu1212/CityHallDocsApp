package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {

    public static Boolean validateUsername(String username){
        String regex = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
