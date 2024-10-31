package model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Customer {

    @NotBlank(message = "This field is required")
    private String firstName;

    @NotBlank(message = "This field is required")
    private String lastName;

    @NotBlank(message = "This field is required")
    private String freePasses;

    @NotBlank(message = "This field is required")
    private String postalCode;

    @NotBlank(message = "This field is required")
    private String courseCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String freePasses, String postalCode, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
        this.postalCode = postalCode;
        this.courseCode = courseCode;
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

    public String getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(String freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", freePasses='" + freePasses + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
