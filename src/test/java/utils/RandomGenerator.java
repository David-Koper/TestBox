package utils;

import java.util.Random;

public class RandomGenerator {public static String randomGender() {
    String[] gender = new String[] {"Male","Female","Other"};
    Random random = new Random();
    return gender[random.nextInt(gender.length)];
}

    public static String randomHobby() {
        String[] hobby = new String[] {"Sports", "Reading", "Music"};
        Random random = new Random();
        return hobby [random.nextInt(hobby.length)];
    }

    public static String randomMonths() {

        String[] month = new String[]{"December", "October", "January",
                "June", "July", "August", "September", "November",
                "February", "May", "April"};
        Random random = new Random();
        return month [random.nextInt(month.length)];
    }

    public static String randomSubject() {

        String[] subject = new String[]{"English", "German", "Biology",
                "Hindi", "Chemistry", "Civics", "Maths"};
        Random random = new Random();
        return subject [random.nextInt(subject.length)];
    }
}
