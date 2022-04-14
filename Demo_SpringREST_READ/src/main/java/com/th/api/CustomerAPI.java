package com.th.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.dto.CustomerDTO;
import com.th.exception.ThBankException;
import com.th.service.CustomerService;

@RestController
@RequestMapping(value = "/thbank")
public class CustomerAPI {

	@Autowired
	private CustomerService customerService;


	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws ThBankException {
		List<CustomerDTO> customerList = customerService.getAllCustomers();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws ThBankException {
		// CustomerDTO customer = customerService.getCustomer(customerId);
		ResponseEntity<CustomerDTO> response = null;
		try {
			CustomerDTO customer = customerService.getCustomer(customerId);
			response = new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}
}
