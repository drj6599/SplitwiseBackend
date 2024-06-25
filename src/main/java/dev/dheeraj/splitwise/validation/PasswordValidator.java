package dev.dheeraj.splitwise.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_REGEX);

    public static boolean isValidPassword(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
