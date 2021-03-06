package isep.web.sakila.jpa.console;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.repositories.CustomerRepository;

public class ApplicationSpringboot2
{
	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
		    isep.web.sakila.jpa.config.Config.class);
		CustomerRepository repository = context.getBean(CustomerRepository.class);

		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		Iterable<Customer> customers = repository.findAll();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customers)
		{
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L);
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// fetch customers by last name
		List<Customer> bauers = repository.findByLastName("Bauer");
		System.out.println("Customer found with findByLastName('Bauer'):");
		System.out.println("--------------------------------------------");
		for (Customer bauer : bauers)
		{
			System.out.println(bauer);
		}

		context.close();
	}

}
