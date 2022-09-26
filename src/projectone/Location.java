package projectone;

public enum Location {
    BRIDGEWATER("08807","SomersetCounty"),
    Edison("08837", "Middlesex County"),
    Franklin("08873", "Somerset County"),
    Piscataway("08854", "Middlesex County"),
    Somerville("08876", "Somerset County");

    private final String zipCode;
    private final String countyName;

    Location(String zipCode, String countyName){
        this.zipCode = zipCode;
        this.countyName = countyName;
    }
}
