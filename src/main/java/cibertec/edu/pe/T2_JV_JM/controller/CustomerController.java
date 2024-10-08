package cibertec.edu.pe.T2_JV_JM.controller;

import cibertec.edu.pe.T2_JV_JM.dto.CustomerDto;
import cibertec.edu.pe.T2_JV_JM.dto.GenericResponseDto;
import cibertec.edu.pe.T2_JV_JM.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<GenericResponseDto<String>> saveCustomer(@RequestBody CustomerDto customerDto) {
        try {
            customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(true)
                    .mensaje("Cliente registrado correctamente")
                    .build(), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(GenericResponseDto.<String>builder()
                    .correcto(false)
                    .mensaje("Error al registrar el cliente")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<GenericResponseDto<CustomerDto>> getCustomerById(@PathVariable Long customerId) {
        CustomerDto customerDto = customerService.findCustomerById(customerId);
        if (customerDto != null) {
            return new ResponseEntity<>(GenericResponseDto.<CustomerDto>builder()
                    .correcto(true)
                    .mensaje("Cliente encontrado")
                    .respuesta(customerDto)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<CustomerDto>builder()
                    .correcto(false)
                    .mensaje("Cliente no encontrado")
                    .build(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/last-name/{lastName}")
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> getCustomersByLastName(@PathVariable String lastName) {
        List<CustomerDto> customers = customerService.findByLastName(lastName);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(false)
                    .mensaje("No se encontraron clientes con ese apellido")
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(true)
                    .mensaje("Listado de clientes encontrados")
                    .respuesta(customers)
                    .build(), HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> getAllCustomers() {
        List<CustomerDto> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                .correcto(true)
                .mensaje("Listado de todos los clientes")
                .respuesta(customers)
                .build(), HttpStatus.OK);
    }
}
