package com.th.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.dto.CustomerLoginDTO;
import com.th.exception.ThbsBankException;
import com.th.repository.CustomerLoginRepository;

@Service(value="customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginRepository customerLoginRepository;

	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws ThbsBankException {
		String toRet = null;
		CustomerLoginDTO customerLoginFromRepository = 
				customerLoginRepository.getCustomerLoginByLoginName(customerLoginDTO.getLoginName());
		if (customerLoginDTO.getPassword().equals(customerLoginFromRepository.getPassword())) {
			toRet = "SUCCESS";
		} else {
			throw new ThbsBankException("Service.WRONG_CREDENTIALS");
		}
		return toRet;
	}
}