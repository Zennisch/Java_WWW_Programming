package model;

public class SinhVien {

    private Integer id;
    private String firstName;
    private String lastName;
    private float averageMark;

    public SinhVien() {
    }

    public SinhVien(Integer id, String firstName, String lastName, float averageMark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageMark = averageMark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }
}
