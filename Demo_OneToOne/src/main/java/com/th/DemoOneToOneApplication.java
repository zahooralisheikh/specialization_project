package com.th;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.th.dto.AddressDTO;
import com.th.dto.CustomerDTO;
import com.th.service.CustomerService;

@SpringBootApplication
public class DemoOneToOneApplication implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(DemoOneToOneApplication.class);

	@Autowired
	CustomerService customerService;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(DemoOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 getCustomer();
//		 addCustomer();
//		 updateAddress();
//		 deleteCustomer();
		 deleteCustomerOnly();

	}
	
	public void getCustomer() {

		try {

			CustomerDTO customerDTO = customerService.getCustomer(1234);
			LOGGER.info(customerDTO);

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exsception occured. Please check log file for more details!!");

			LOGGER.info(message);
		}
	}

	public void addCustomer() {
		try {

			CustomerDTO customerDTO = new CustomerDTO();

			customerDTO.setName("Ron");
			customerDTO.setEmailId("ron@infy.com");
			customerDTO.setDateOfBirth(LocalDate.of(1993, 03, 24));

			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAddressId(103L);
			addressDTO.setCity("Albany");
			addressDTO.setStreet("93 Taylor Road");

			customerDTO.setAddress(addressDTO);

			Integer customerId = customerService.addCustomer(customerDTO);
			LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDED") + customerId);

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");

			LOGGER.info(message);
		}
	}

	public void updateAddress() {

		try {

			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setCity("Rochester");
			addressDTO.setStreet("12 Tim Street");

			customerService.updateAddress(1234, addressDTO);
			LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_UPDATED"));

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");

			LOGGER.info(message);
		}

	}

	public void deleteCustomer() {

		try {

			customerService.deleteCustomer(1234);
			LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDRESS_DELETED"));

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");

			LOGGER.info(message);
		}
	}
	
	public void deleteCustomerOnly() {

		try {

			customerService.deleteCustomerOnly(1235);
			LOGGER.info("\n" + environment.getProperty("UserInterface.CUSTOMER_DELETED"));

		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),
					"Some exception occured. Please check log file for more details!!");

			LOGGER.info(message);
		}
	}

}
