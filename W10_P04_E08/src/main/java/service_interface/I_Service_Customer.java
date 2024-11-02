package service_interface;

import model.Customer;

import java.util.List;

public interface I_Service_Customer {

    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    boolean createCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);

}
