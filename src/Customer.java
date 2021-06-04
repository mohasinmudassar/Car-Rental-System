
public class Customer {
    String customerName,customerEmail,customerAddress;
    Customer(String customerName,String customerEmail,String customerAddress){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }
    
}
