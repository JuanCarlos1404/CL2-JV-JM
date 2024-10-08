package cibertec.edu.pe.T2_JV_JM.service.impl;

import cibertec.edu.pe.T2_JV_JM.dto.CustomerDto;
import cibertec.edu.pe.T2_JV_JM.model.Customer;
import cibertec.edu.pe.T2_JV_JM.repository.CustomerRepository;
import cibertec.edu.pe.T2_JV_JM.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerDto findCustomerById(Long customerId) {
        return null;
    }

    @Override
    public List<CustomerDto> findByLastName(String lastName) {
        return List.of();
    }

    @Override
    public CustomerDto findByEmail(String email) {
        return null;
    }

    @Override
    public CustomerDto findByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return List.of();
    }
}
