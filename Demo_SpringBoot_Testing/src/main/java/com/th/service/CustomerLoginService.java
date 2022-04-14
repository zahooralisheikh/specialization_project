package com.th.service;

import com.th.dto.CustomerLoginDTO;
import com.th.exception.ThbsBankException;

public interface CustomerLoginService {
	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws ThbsBankException;
}
