package test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncordTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
