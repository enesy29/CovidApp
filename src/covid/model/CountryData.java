package covid.model;

import javafx.collections.ObservableList;

/**
 *
 * @author Enes Y
 */
public class CountryData {
    
    private String cases;
    private String countryterritoryCode;
    private String popData2018;
    private String month;
    private String year;
    private String geoId;
    private String dateRep;
    private String continentExp;
    private String day;
    private String countriesAndTerritories;
    private String deaths;
    
    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public void setCountryterritoryCode(String countryterritoryCode) {
        this.countryterritoryCode = countryterritoryCode;
    }

    public String getPopData2018() {
        return popData2018;
    }

    public void setPopData2018(String popData2018) {
        this.popData2018 = popData2018;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public String getContinentExp() {
        return continentExp;
    }

    public void setContinentExp(String continentExp) {
        this.continentExp = continentExp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public void setCountriesAndTerritories(String countriesAndTerritories) {
        this.countriesAndTerritories = countriesAndTerritories;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "CountryData{" + "cases=" + cases + ", countryterritoryCode=" + countryterritoryCode + ", popData2018=" + popData2018 + ", month=" + month + ", year=" + year + ", geoId=" + geoId + ", dateRep=" + dateRep + ", continentExp=" + continentExp + ", day=" + day + ", countriesAndTerritories=" + countriesAndTerritories + ", deaths=" + deaths + '}';
    }
    
    
}
    
