package BeautyParlor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Service 
{
	Integer serviceId;
	String beautyService;
	Float charges;
	
	public Service() {
		super();
	}


	public Service(Integer serviceId,String beautyService, Float charges) {
		super();
		this.serviceId=serviceId;
		this.beautyService=beautyService;
		this.charges = charges;
	}
	
	
	
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}


	public String getBeautyService() {
		return beautyService;
	}


	public void setBeautyService(String beautyService) {
		this.beautyService = beautyService;
	}


	public Float getCharges() {
		return charges;
	}


	public void setCharges(Float charges) {
		this.charges = charges;
	}
	
	static Map<Integer, Service> serviceMap=new HashMap<Integer, Service>();
	
	public void initialServiceMap() {
		Service object=new Service(301, "Medicure", (float) 500.00);
		serviceMap.put(301, object);
	}
	
	public void serviceViewAllRecords() {
		if(serviceMap.isEmpty()) {
			System.out.println("No Services Register");
			return;
		}
		System.out.println("All the Services are :- ");
		for (Map.Entry<Integer, Service> entry : serviceMap.entrySet()) {
//            Integer key = entry.getKey();
            Service values = entry.getValue();
            
            
            System.out.println("Service ID: "+values.getServiceId());
            System.out.println("Service Name: " + values.getBeautyService());
            System.out.println("Charges: "+values.getCharges());
		}
	}


	public void serviceMenu() {
		int userChoice=-1;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to Service Menu Please Choose your next options: ");
		System.out.println(" Press 1 for Enter a Beauty Service \n Press 2 for Modify Beauty Service Details"
				+ "\n Press 3 for Delete Beauty service Record \n Press 4 for View single record "
				+ "\n Press 5 for View all records \n Press 0 for exit");
		String serviceName=null;
		Float serviceCharge=null;
		Integer serviceId=null;
		int choice=Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1: {
			System.out.println("Enter Beauty Service Name");
			serviceName=sc.nextLine();
			
			System.out.println("Enter the Charge for the service");
			serviceCharge=Float.parseFloat(sc.nextLine());
			
			Random random=new Random();
			Integer randomId=null;
			while(true) {
				randomId=random.nextInt(101);
				if(!serviceMap.containsKey(randomId))
					break;
			}
			
			Service object=new Service(randomId, serviceName, serviceCharge);
			
			serviceMap.put(randomId, object);
			
			System.out.println("The Service Id for newly register service is "+randomId);
			
			break;
		}
		case 2: {
			System.out.println("Enter Service Id for modification");
			serviceId=Integer.parseInt(sc.nextLine());
			if(!serviceMap.containsKey(serviceId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			Service object=serviceMap.get(serviceId);
			
			System.out.println("Enter the New Service Name");
			serviceName=sc.nextLine();
			object.setBeautyService(serviceName);
			
			System.out.println("Enter the charges for the service");
			serviceCharge=sc.nextFloat();
			object.setCharges(serviceCharge);
			
			serviceMap.put(serviceId, object);
			System.out.println("Details Updated");
			
			break;
		}
		case 3: {
			System.out.println("Enter Service Id to delete");
			serviceId=Integer.parseInt(sc.nextLine());
			if(!serviceMap.containsKey(serviceId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			serviceMap.remove(serviceId);
			System.out.println("Service Removed");
			break;
		}
		case 4: {
			System.out.println("Enter Your Service Id for Details");
			serviceId=Integer.parseInt(sc.nextLine());
			if(!serviceMap.containsKey(serviceId)) {
				System.out.println("Please enter Valid Id");
				break;
			}
			Service object=serviceMap.get(serviceId);
			System.out.println("Service ID = "+object.getServiceId()+"\nName of Service = "+
			object.getBeautyService()+"\nService Charge = "+object.getCharges());
			break;
		}
		case 5: {
			serviceViewAllRecords();
			break;
		}
		case 0:{
			return;
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		System.out.println("Enter 1 for continue else 0 for Exit from Service Menu");
		userChoice=Integer.parseInt(sc.nextLine());
		if(userChoice==0)
			break;
		else
			userChoice=-1;
		}while(true);
	}
}
