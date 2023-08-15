package BeautyParlor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class Customer {
	Integer userId;
	String customerName,customerAddress,customerContact;
	
	public Customer() {
		super();
	}
	
	public Customer(Integer userId,String customerName, String customerAddress, String customerContact) {
		super();
		this.userId=userId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerContact = customerContact;
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	static Map<Integer, Customer> customerMap=new HashMap<Integer, Customer>();
	
	public void initialCustomerMap() {
		Customer object=new Customer(101, "abc", "Dewas", "8746381111");
		customerMap.put(101, object);
	}
	
	public void customerViewAllRecords() {
		if(customerMap.isEmpty()) {
			System.out.println("No Customer Register");
			return;
		}
		System.out.println("All the Customers are :- ");
		for (Map.Entry<Integer, Customer> entry : customerMap.entrySet()) {
//            Integer key = entry.getKey();
            Customer values = entry.getValue();
            
            
            System.out.println("Customer User ID: "+values.getUserId());
            System.out.println("Customer Name: " + values.getCustomerName());
            System.out.println("Address: "+values.getCustomerAddress());
            System.out.println("Contact Number: "+values.getCustomerContact());
		}
	}

	public void customerMenu() {
		int userChoice=-1;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to Customer Menu Please Choose your next options: ");
		System.out.println(" Press 1 for Register Customer \n Press 2 for Modify Customer Details"
				+ "\n Press 3 for Delete Customer Record \n Press 4 for View single record "
				+ "\n Press 5 for View all records \n Press 0 for exit");
		
		String strName=null;
		String strAddress=null;
		String strContact=null;
		Integer userId=null;
		int choice=Integer.parseInt(sc.nextLine());;
		switch (choice) {
		case 1: {
			System.out.println("Enter Your Name");
			strName=sc.nextLine();
			
			System.out.println("Enter Your Address");
			strAddress=sc.nextLine();
			
			System.out.println("Enter Your Contact Number");
			strContact=sc.nextLine();
			
			Random random=new Random();
			Integer randomId=null;
			while(true) {
				randomId=random.nextInt(101);
				if(!customerMap.containsKey(randomId))
					break;
			}
	
			Customer object=new Customer(randomId,strName, strAddress, strContact);

	        customerMap.put(randomId, object);
	        
	        System.out.println("Customer Register Successful Your User Id is "+randomId);
			
			break;
		}
		case 2: {
			
			System.out.println("Enter Your user Id to modify details");
			userId=Integer.parseInt(sc.nextLine());
			
			if(!customerMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			
			Customer object=customerMap.get(userId);
			
			System.out.println("Enter Your Name");
			strName=sc.nextLine();
			object.setCustomerName(strName);
			
			System.out.println("Enter Your Address");
			strAddress=sc.nextLine();
			object.setCustomerAddress(strAddress);
			
			System.out.println("Enter Your contact Number");
			strContact=sc.nextLine();
			object.setCustomerContact(strContact);
			
			customerMap.put(userId, object);
			System.out.println("Details Updated");
			break;
			
		}
		case 3: {
		
			System.out.println("Enter Your user Id to delete");
			userId=Integer.parseInt(sc.nextLine());
			if(!customerMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			customerMap.remove(userId);
			System.out.println("User Removed");
			break;
		}
		case 4: {
		
			System.out.println("Enter Your user Id for Details");
			userId=Integer.parseInt(sc.nextLine());
			if(!customerMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			Customer object=customerMap.get(userId);
			System.out.println("User ID = "+object.getUserId()+"\nName of Customer = "+
			object.getCustomerName()+"\nCustomer Address = "+object.getCustomerAddress()+
			"\nCustomer Contact Number = "+object.getCustomerContact());
			break;
		}
		case 5: {
			customerViewAllRecords();
			break;
		}
		case 0:{
			break;
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		System.out.println("Enter 1 for continue else 0 for Exit from Customer Menu");
		userChoice=Integer.parseInt(sc.nextLine());
		if(userChoice==0) {
			break;
		}
		else
			userChoice=-1;
		}while(true);
	}
}
