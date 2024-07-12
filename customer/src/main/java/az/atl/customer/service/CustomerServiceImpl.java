package az.atl.customer.service;

import az.atl.customer.mode.CustomerDto;
import az.atl.customer.mode.CustomerRequest;

import java.util.List;

public interface CustomerServiceImpl {
   CustomerDto createStudent(CustomerRequest studentRequest);
    CustomerDto  findById(Long id);
    List<CustomerDto> findAllStudent();
    void updateStudent(Long id,CustomerDto  studentDto);
    void deleteStudent(Long id);
}
