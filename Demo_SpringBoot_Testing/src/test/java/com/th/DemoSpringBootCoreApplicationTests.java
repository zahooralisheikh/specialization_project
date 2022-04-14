package com.th;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.th.dto.CustomerLoginDTO;
import com.th.exception.ThbsBankException;
import com.th.service.CustomerLoginService;

@SpringBootTest
public class DemoSpringBootCoreApplicationTests {

	@Autowired
	CustomerLoginService customerLoginService;     

	@Test
	public void authenticateCustomerTestValidCredentials() throws ThbsBankException {
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("monica");
		customer.setPassword("monica123");
		String actual = customerLoginService.authenticateCustomer(customer);
		Assertions.assertEquals("SUCCESS", actual);
	} 

	@Test
	public void authenticateCustomerTestInValidCredentials() throws ThbsBankException {
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("monica");
		customer.setPassword("monica13");
		ThbsBankException exception=Assertions.assertThrows(ThbsBankException.class,()->customerLoginService.authenticateCustomer(customer));
		Assertions.assertEquals("Service.WRONG_CREDENTIALS", exception.getMessage());
	}
}