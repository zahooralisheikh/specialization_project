package com.th.service;

import com.th.dto.AddressDTO;
import com.th.dto.CustomerDTO;
import com.th.exception.InfyBankException;

public interface CustomerService {

	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
	public Integer addCustomer(CustomerDTO customerDTO);
	public void updateAddress(Integer customerId, AddressDTO addressDTO) throws InfyBankException;
	public void deleteCustomer(Integer customerId) throws InfyBankException;
	public void deleteCustomerOnly(Integer customerId) throws InfyBankException;
}
