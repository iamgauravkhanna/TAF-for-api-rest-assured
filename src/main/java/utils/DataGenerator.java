package utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    public static String generateName(){
        return new Faker().name().firstName();
    }

}
