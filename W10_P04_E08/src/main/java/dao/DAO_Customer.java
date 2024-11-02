package dao;

import dao_interface.I_DAO_Customer;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAO_Customer implements I_DAO_Customer {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Customer customer = session.get(Customer.class, id);
            session.remove(customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
    }
}
