public class Utilities {
    public static String genBirthDay(int age, String season) {
        int birthYear = 2026 - age;
        String monthDay = "-01-01";
        String s = season.toLowerCase();
        if (s.contains("spring")) monthDay = "-03-21";
        else if (s.contains("summer")) monthDay = "-06-21";
        else if (s.contains("fall")) monthDay = "-09-21";
        else if (s.contains("winter")) monthDay = "-12-21";
        return birthYear + monthDay;
    }
}