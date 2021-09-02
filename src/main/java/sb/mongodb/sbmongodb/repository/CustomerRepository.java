package sb.mongodb.sbmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import sb.mongodb.sbmongodb.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{
    
}
