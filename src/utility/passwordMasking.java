package utility;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class passwordMasking {

    public String passwordHiding(String password) {
        if (password == null) {
            return null;
        }
        char[] passwordArr = new char[password.length()];
        for (int i = 1; i < passwordArr.length; i++) {
            passwordArr[i] = '*';
        }
        return new String(passwordArr);
    }


}
