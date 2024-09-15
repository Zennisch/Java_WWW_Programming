package model;

public class Qualification {

    private String board;
    private String percentage;
    private String yearOfPassing;

    public Qualification(String board, String percentage, String yearOfPassing) {
        this.board = board;
        this.percentage = percentage;
        this.yearOfPassing = yearOfPassing;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }
}
