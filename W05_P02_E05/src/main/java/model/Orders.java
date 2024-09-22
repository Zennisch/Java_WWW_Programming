package model;

public class Orders {

    private int id;

    public Orders() {
    }

    public Orders(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "I_DAO_Orders{" +
                "id=" + id +
                '}';
    }
}
