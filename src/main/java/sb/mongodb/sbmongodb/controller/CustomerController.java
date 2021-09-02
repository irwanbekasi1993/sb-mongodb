package sb.mongodb.sbmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sb.mongodb.sbmongodb.model.Customer;
import sb.mongodb.sbmongodb.repository.CustomerRepository;

@RestController
@RequestMapping("/sbmongodb")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer insertCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(insertCustomer);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> list = customerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id")String id){
        Customer getCustomer = customerRepository.findById(id).get();
        return ResponseEntity.ok(getCustomer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id")String id){
        Customer getCustomer = customerRepository.findById(id).get();
        if(getCustomer!=null){
            getCustomer.setFirstName(getCustomer.getFirstName()+"_Updated");
            getCustomer.setLastName(getCustomer.getLastName()+"_Updated");
            customerRepository.save(getCustomer);
        }
        return ResponseEntity.ok(getCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id")String id){
        
        customerRepository.deleteById(id);
        return ResponseEntity.ok("Successfully delete");
    }
}
