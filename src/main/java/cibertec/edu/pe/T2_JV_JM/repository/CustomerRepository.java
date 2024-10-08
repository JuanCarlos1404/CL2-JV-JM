package cibertec.edu.pe.T2_JV_JM.repository;

import cibertec.edu.pe.T2_JV_JM.dto.CustomerDto;
import cibertec.edu.pe.T2_JV_JM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<CustomerDto> findByLastName(String lastName);
    CustomerDto findByEmail(String email);
    @Query("SELECT c FROM Customer c WHERE c.firstName = ?1 AND c.lastName = ?2")
    CustomerDto findByFullName(String firstName, String lastName);
    @Query("SELECT c FROM Customer c")
    List<CustomerDto> findAllCustomers();
}
