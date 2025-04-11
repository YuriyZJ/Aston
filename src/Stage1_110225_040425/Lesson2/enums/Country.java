package Stage1_110225_040425.Lesson2.enums;

public enum Country {
    USA("Washigton"),
    RUSSIAN_FEDERTION("Moscow");

    Country(String capital) {
        this.capital = capital;
    }

    private String capital;

    public String getCapital() {
        return capital;
    }
}
