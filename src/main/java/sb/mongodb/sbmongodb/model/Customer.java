package sb.mongodb.sbmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customer")
public class Customer {
   @Id
   private String id;
   
   private String firstName;
   private String lastName;

public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}
public Customer() {
}
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}

    

}
