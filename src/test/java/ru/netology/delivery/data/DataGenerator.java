package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.now().plusDays(shift).format(pattern);
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.address().city();
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName().replace("ё", "е");
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return String.valueOf(faker.phoneNumber().phoneNumber());
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
//            UserInfo user = ;
//            user.city = generateCity(locale);
//            user.name = generateName(locale);
//            user.phone = generatePhone(locale);
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

//        public static String getCity() {
//            return city;
//        }
//
//        public static String getName() {
//            return name;
//        }
//
//        public static String getPhone() {
//            return phone;
//        }
    }
}