package nix.lessons.dto;

public enum Sex {
    MALE,
    FEMALE,
    OTHER;

    public static Sex fromString(String s) {
        if (s.equalsIgnoreCase("male")) {
            return MALE;
        } else if (s.equalsIgnoreCase("female")) {
            return FEMALE;
        }
        return OTHER;
    }
}
