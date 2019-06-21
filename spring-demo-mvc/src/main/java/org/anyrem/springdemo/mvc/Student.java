package org.anyrem.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String[] operatingSystem;
    private LinkedHashMap<String, String> countryOptions;

    private String favProgrammingLang;

    public Student() {

        countryOptions = new LinkedHashMap<>();

        countryOptions.put("BR", "Brazil");
        countryOptions.put("PL", "Poland");
        countryOptions.put("JP", "Japan");
        countryOptions.put("VNM", "Vietnam");
        countryOptions.put("US", "USA");

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavProgrammingLang() {
        return favProgrammingLang;
    }

    public void setFavProgrammingLang(String favProgrammingLang) {
        this.favProgrammingLang = favProgrammingLang;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
