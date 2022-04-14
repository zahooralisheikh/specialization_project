package com.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.th.dto.CustomerLoginDTO;
import com.th.exception.ThbsBankException;
import com.th.service.CustomerLoginService;

@Controller(value="customerLoginController")
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws ThbsBankException {
		return customerLoginService.authenticateCustomer(customerLoginDTO);
	}
}
