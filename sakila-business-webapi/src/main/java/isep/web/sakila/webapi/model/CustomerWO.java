package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Store;

public class CustomerWO extends WebObject {

	private static final long serialVersionUID = -3940626561941477764L;
	
	protected int customerId;
	protected String	 lastName;
	protected String	 firstName;
	protected String email;
	protected Address address;
	protected Store store;
	
	public CustomerWO() {
		super();
	}
	
	public CustomerWO(int customerId, String lastName, String firstName, String email, Address address, Store store)
	{
		this();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.store = store;
	}
	
	public CustomerWO(final Customer customer) {
		this();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
		this.address = customer.getAddress();
		this.store = customer.getStore();
	}
	

	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	@Override
	public String toString()
	{
		return "Customer [id=" + this.customerId + ", LastNanem=" 
				+ this.lastName + ", First=" + this.firstName 
				+ ", Address=" + this.address + ", Store="+ this.store + "]";
	}
}
