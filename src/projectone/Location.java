package projectone;

public enum Location {
    Bridgewater("08807", "SomersetCounty"),
    Edison("08837", "Middlesex County"),
    Franklin("08873", "Somerset County"),
    Piscataway("08854", "Middlesex County"),
    Somerville("08876", "Somerset County");

    private final String zipCode;
    private final String countyName;

    Location(String zipCode, String countyName) {
        this.zipCode = zipCode;
        this.countyName = countyName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountyName() {
        return countyName;
    }
    public String reformat(){
        return countyName + zipCode;
    }
}
