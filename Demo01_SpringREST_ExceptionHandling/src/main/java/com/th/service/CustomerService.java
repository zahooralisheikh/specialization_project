package com.th.service;

import java.util.List;

import com.th.dto.CustomerDTO;
import com.th.exception.ThBankException;

public interface CustomerService {
	public Integer addCustomer(CustomerDTO customerDTO) throws ThBankException;
	public CustomerDTO getCustomer(Integer customerId) throws ThBankException;
	public void updateCustomer(Integer customerId, String emailId)throws ThBankException;
	public void deleteCustomer(Integer customerId)throws Exception;
	public List<CustomerDTO> getAllCustomers() throws ThBankException;
}
