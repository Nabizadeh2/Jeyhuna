package az.atl.customer.controller;

import az.atl.customer.mode.CustomerDto;
import az.atl.customer.mode.CustomerRequest;
import az.atl.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerDto> createStudent(@Valid @RequestBody CustomerRequest customerRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createStudent(customerRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>>findAllStudent(){
        return ResponseEntity.ok(customerService.findAllStudent());

    }

    @PostMapping("/{id}")

    public ResponseEntity<Void>updateStudent(@PathVariable Long id,
                                             @RequestBody CustomerDto customerDto){
        customerService.updateStudent(id,customerDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")

    public  ResponseEntity<Void>deleteStudent(@PathVariable Long id){
        customerService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
