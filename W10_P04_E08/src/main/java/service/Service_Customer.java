package service;

import dao_interface.I_DAO_Customer;
import jakarta.transaction.Transactional;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service_interface.I_Service_Customer;

import java.util.List;

@Service
public class Service_Customer implements I_Service_Customer {

    @Autowired
    private I_DAO_Customer dao_customer;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return dao_customer.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {
        return dao_customer.getCustomerById(id);
    }

    @Override
    @Transactional
    public boolean createCustomer(Customer customer) {
        return dao_customer.createCustomer(customer);
    }

    @Override
    @Transactional
    public boolean updateCustomer(Customer customer) {
        return dao_customer.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return dao_customer.deleteCustomer(id);
    }
}
