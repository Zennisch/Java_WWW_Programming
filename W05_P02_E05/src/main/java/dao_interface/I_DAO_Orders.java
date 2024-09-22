package dao_interface;

import model.Orders;

public interface I_DAO_Orders {

    boolean addOrder();
    Orders getLatestOrder();

}
