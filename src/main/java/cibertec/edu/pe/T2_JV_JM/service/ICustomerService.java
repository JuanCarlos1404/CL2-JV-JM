package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.dto.CustomerDto;
import cibertec.edu.pe.T2_JV_JM.model.Customer;
import cibertec.edu.pe.T2_JV_JM.repository.CustomerRepository;

import java.util.List;

public interface ICustomerService {
    Customer saveCustomer(Customer customer);
    CustomerDto findCustomerById(Long customerId);
    List<CustomerDto> findByLastName(String lastName);
    CustomerDto findByEmail(String email);
    CustomerDto findByFullName(String firstName, String lastName);
    List<CustomerDto> findAllCustomers();
}
