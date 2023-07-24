package utils;

import com.github.javafaker.Faker;

public class CommonUtils {

    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 15;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
    public static Faker faker;

    public static Faker generateRandomdata() {
        faker = new Faker();
        return faker;
    }
}
