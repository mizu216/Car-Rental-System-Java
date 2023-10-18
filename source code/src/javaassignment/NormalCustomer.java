package javaassignment;
public class NormalCustomer extends Customer {

    public NormalCustomer(String username, String password, String gender, String email, String homeAddress, String phone, int age, String accStatus, String accType) {
        super(username, password, gender, email, homeAddress, phone, age, accStatus, accType);
    }

    
    public Double PayAmount(Double amount){
        return super.PayAmount(amount);
    }
    
    public String Welcome(){
        return "Hi,Normal Customer:"+ super.getUsername();
    }
}

