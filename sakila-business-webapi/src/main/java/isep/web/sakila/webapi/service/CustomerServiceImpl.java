package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.webapi.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	private static final Log	log	= LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<CustomerWO> findAllCustomers() {
		List<CustomerWO> customers = new LinkedList<CustomerWO>();
		for (Customer customer : customerRepository.findAll()) {
			customers.add(new CustomerWO(customer));
			log.debug("Customer : " + customer);
		}
		return customers;
	}
	
	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null)
		{
			return new CustomerWO(customer);
		}
		return null;
	}

	@Override
	public void saveCustomer(CustomerWO userWO) {
		Customer customer = new Customer();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		customer.setLastName(userWO.getLastName());
		customer.setFirstName(userWO.getFirstName());
		customer.setEmail(userWO.getEmail());
		customer.setAddress(userWO.getAddress());
		customer.setCreateDate(time);
		customer.setLastUpdate(time);
		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(CustomerWO userWO) {
		Customer customer = customerRepository.findOne(userWO.getCustomerId());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		customer.setLastName(userWO.getLastName());
		customer.setFirstName(userWO.getFirstName());
		customer.setEmail(userWO.getEmail());
		customer.setAddress(userWO.getAddress());
		customer.setCreateDate(time);
		customer.setLastUpdate(time);
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		log.debug(String.format("Delete user with Id %s", id));
		customerRepository.delete(id);
	}

}
