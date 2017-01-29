package ua.kravchenko.youq.entity;

/**
 * Created by Egor on 29.01.2017.
 */
public enum Codes {
    QR("QR"),
    EN13("EN-13");

    private final String displayedName;

    public String getDisplayedName() {

        return displayedName;
    }

    Codes(String displayedName) {

        this.displayedName = displayedName;
    }

    public static Codes[] getValues()
    {
        return values();
    }
}
