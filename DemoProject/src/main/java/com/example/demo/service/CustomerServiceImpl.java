package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	@Cacheable("getcustomer")
	public Customer getCustomer(int index) {

		ArrayList<Customer> arrayList = new ArrayList<>();
		arrayList.add(new Customer("rohith", 22));
		arrayList.add(new Customer("amith", 23));
		arrayList.add(new Customer("manju", 21));
		
		try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

		return arrayList.get(index);

	}

}
