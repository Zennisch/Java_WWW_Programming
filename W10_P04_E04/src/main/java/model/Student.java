package model;

import java.util.*;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystems;

    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> favoriteLanguageOptions;
    private List<String> operatingSystemsOptions;

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("US", "United States");

        favoriteLanguageOptions = new LinkedHashMap<>();
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("PHP", "PHP");
        favoriteLanguageOptions.put("Ruby", "Ruby");

        operatingSystemsOptions = new ArrayList<>();
        operatingSystemsOptions.add("Linux");
        operatingSystemsOptions.add("Mac OS");
        operatingSystemsOptions.add("Microsoft Windows");
    }

    public Student(String[] operatingSystems, String favoriteLanguage, String country, String lastName, String firstName) {
        this.operatingSystems = operatingSystems;
        this.favoriteLanguage = favoriteLanguage;
        this.country = country;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public HashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public HashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public List<String> getOperatingSystemsOptions() {
        return operatingSystemsOptions;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", operatingSystems=" + Arrays.toString(operatingSystems) +
                '}';
    }
}
