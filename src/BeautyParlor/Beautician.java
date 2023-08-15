package BeautyParlor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Beautician {
	Integer beauticianId;
	String beauticianName,beauticianAddress,beauticianContact;
	
	
	public Beautician() {
		super();
	}
	

	public Beautician(Integer beauticianId,String beauticianName, String beauticianAddress, String beauticianContact) {
		super();
		this.beauticianId=beauticianId;
		this.beauticianName = beauticianName;
		this.beauticianAddress = beauticianAddress;
		this.beauticianContact = beauticianContact;
	}
	
	

	public Integer getBeauticianId() {
		return beauticianId;
	}


	public void setBeauticianId(Integer beauticianId) {
		this.beauticianId = beauticianId;
	}


	public String getBeauticianName() {
		return beauticianName;
	}


	public void setBeauticianName(String beauticianName) {
		this.beauticianName = beauticianName;
	}


	public String getBeauticianAddress() {
		return beauticianAddress;
	}


	public void setBeauticianAddress(String beauticianAddress) {
		this.beauticianAddress = beauticianAddress;
	}


	public String getBeauticianContact() {
		return beauticianContact;
	}


	public void setBeauticianContact(String beauticianContact) {
		this.beauticianContact = beauticianContact;
	}


	static Map<Integer,Beautician>beauticianMap=new HashMap<Integer, Beautician>();
	
	void initialBeauticianMap() {
		Beautician object=new Beautician(201, "xyz", "Indore", "1234567890");
		beauticianMap.put(201, object);
	}
	
	public void beauticianViewAllRecords() {
		if(beauticianMap.isEmpty()) {
			System.out.println("No Beautician Register");
			return;
		}
		System.out.println("All the Beauticians are :- ");
		for (Map.Entry<Integer, Beautician> entry : beauticianMap.entrySet()) {
//            Integer key = entry.getKey();
            Beautician values = entry.getValue();
            
            
            System.out.println("Beautician User ID: "+values.getBeauticianId());
            System.out.println("Beautician Name: " + values.getBeauticianName());
            System.out.println("Address: "+values.getBeauticianAddress());
            System.out.println("Contact Number: "+values.getBeauticianContact());
		}
	}

	public void beauticianMenu() {
		int userChoice=-1;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to Beautician Menu Please Choose your next options: ");
		System.out.println(" Press 1 for Register Beautician \n Press 2 for Modify Beautician Details"
				+ "\n Press 3 for Delete Beautician Record \n Press 4 for View single record "
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
				if(!beauticianMap.containsKey(randomId))
					break;
			}
	
			Beautician object=new Beautician(randomId, strName, strAddress, strContact);

	        beauticianMap.put(randomId, object);
	        
	        System.out.println("Beautician Register Successful Your User Id is "+randomId);
			
			break;
		}
		case 2: {
			
			System.out.println("Enter Your Beautician Id to modify details");
			userId=Integer.parseInt(sc.nextLine());
			if(!beauticianMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			
			Beautician object=beauticianMap.get(userId);
			
			System.out.println("Enter Your Name");
			strName=sc.nextLine();
			object.setBeauticianName(strName);
			
			System.out.println("Enter Your Address");
			strAddress=sc.nextLine();
			object.setBeauticianAddress(strAddress);
			
			System.out.println("Enter Your contact Number");
			strContact=sc.nextLine();
			object.setBeauticianContact(strContact);
			
			beauticianMap.put(userId, object);
			System.out.println("Details Updated");
			break;
			
		}
		case 3: {
		
			System.out.println("Enter Your Beautician Id to delete");
			userId=Integer.parseInt(sc.nextLine());
			if(!beauticianMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			beauticianMap.remove(userId);
			System.out.println("User Removed");
			break;
		}
		case 4: {
		
			System.out.println("Enter Your user Id for Details");
			userId=Integer.parseInt(sc.nextLine());
			if(!beauticianMap.containsKey(userId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			Beautician object=beauticianMap.get(userId);
			System.out.println("Beautician ID = "+object.getBeauticianId()+"\nName of Beautician = "+
			object.getBeauticianName()+"\nBeautician Address = "+object.getBeauticianAddress()+
			"\nBeautician Contact Number = "+object.getBeauticianContact());
			break;
		}
		case 5: {
			beauticianViewAllRecords();
			break;
		}
		case 0:{
			return;
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		System.out.println("Enter 1 for continue else 0 for Exit from Beautician Menu");
		userChoice=Integer.parseInt(sc.nextLine());
		if(userChoice==0)
			break;
		else
			userChoice=-1;
		}while(true);
	}
}
