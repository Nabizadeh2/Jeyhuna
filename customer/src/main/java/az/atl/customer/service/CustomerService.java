package az.atl.customer.service;

import az.atl.customer.dao.EntityCustomer;
import az.atl.customer.dao.RepositoryCustomer;
import az.atl.customer.exception.CustomerNotFoundException;
import az.atl.customer.mapper.CustomerMapper;
import az.atl.customer.mode.CustomerDto;
import az.atl.customer.mode.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerServiceImpl{
    private final CustomerMapper customerMapper;
    private final RepositoryCustomer repositoryCustomer;
    @Override
    public CustomerDto createStudent(CustomerRequest studentRequest) {
         EntityCustomer entityCustomer= customerMapper.toEntity((studentRequest));
        return customerMapper.toDto((EntityCustomer) repositoryCustomer.save(entityCustomer));
    }

    @Override
    public CustomerDto findById(Long id) {
        return  repositoryCustomer.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(()->new CustomerNotFoundException("Errroorrr vaaar"+id));
    }

    @Override
    public List<CustomerDto> findAllStudent() {
        return  repositoryCustomer.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void updateStudent(Long id, CustomerDto studentDto) {

    }

    @Override
    public void deleteStudent(Long id) {

    }
}
