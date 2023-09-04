package pl.gm.apidemo1.security.utils;

public enum UserGender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String displayName;

    UserGender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
