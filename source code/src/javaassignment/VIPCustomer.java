package javaassignment;
public class VIPCustomer extends Customer {

    public VIPCustomer(String username, String password, String gender, String email, String homeAddress, String phone, int age, String accStatus, String accType) {
        super(username, password, gender, email, homeAddress, phone, age, accStatus, accType);
    }

    
    public Double PayAmount(Double amount){
        return amount*0.8;
    }
    
        public String Welcome(){
        return "Hi,VIP Customer:"+ super.getUsername();
    }
}

