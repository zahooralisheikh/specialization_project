package com.th.service;

import java.time.LocalDate;
import java.util.List;

import com.th.dto.TransactionDTO;
import com.th.exception.ThBankException;

public interface TransactionService {
	public List<TransactionDTO> getAllTransaction(Integer pageNo, Integer pageSize) throws ThBankException;

	public List<TransactionDTO> getAllTransactionByTransactionDateAfter(LocalDate transactionDate, Integer pageNo,
			Integer pageSize) throws ThBankException;
}