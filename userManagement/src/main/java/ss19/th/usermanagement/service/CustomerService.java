package ss19.th.usermanagement.service;

import ss19.th.usermanagement.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Nhung", "nhung274@gmail.com", "Ha Noi"));
        customers.put(2, new Customer(2, "Customer 1", "cus1@gmail.com", "Da Nang"));
        customers.put(3, new Customer(3, "Customer 2", "cus2@gmail.com", "HCM"));
        customers.put(4, new Customer(4, "Customer 3", "cus3@gmail.com", "Hai Phong"));
        customers.put(5, new Customer(5, "Customer 4", "cus4@gmail.com", "Hue"));
        customers.put(6, new Customer(6, "Customer 5", "cus5@gmail.com", "Nghe An"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }
    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }
    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }
    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    public int getNewId(){
        int maxId = 0;
        for (int id : customers.keySet()) {
            if(id>maxId){
                maxId = id;
            }
        }
        return maxId+1;
    }
}
