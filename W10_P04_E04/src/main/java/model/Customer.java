package model;

import jakarta.validation.constraints.*;

public class Customer {

    @NotBlank(message = "This field is required")
    private String firstName;

    @NotBlank(message = "This field is required")
    @Size(min = 4, message = "This field must be at least 4 characters long")
    private String lastName;

    @NotNull(message = "This field is required")
    @Min(value = 0, message = "Must be greater than or equal to zero")
    @Max(value = 10, message = "Must be less than or equal to ten")
    private Integer freePasses;

    @NotBlank(message = "This field is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters/digits")
    private String postalCode;

    @NotBlank(message = "This field is required")
    private String courseCode;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer freePasses, String postalCode, String courseCode) {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
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
