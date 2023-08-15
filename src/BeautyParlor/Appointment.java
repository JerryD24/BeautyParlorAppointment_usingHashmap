package BeautyParlor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Appointment 
{
	
	Integer appointmentId;
	Customer customer=new Customer();
	Beautician beautician=new Beautician();
	Service service=new Service();
	
	Scanner sc=new Scanner(System.in);
	
	public Appointment() {
		super();
	}
	
	public Appointment(Integer appointmentId, Customer customer, Beautician beautician, Service service) {
		super();
		this.appointmentId = appointmentId;
		this.customer = customer;
		this.beautician = beautician;
		this.service = service;
	}


	public Integer getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}


	public Customer getCus() {
		return customer;
	}


	public void setCus(Customer customer) {
		this.customer = customer;
	}


	public Beautician getBea() {
		return beautician;
	}


	public void setBea(Beautician beautician) {
		this.beautician = beautician;
	}


	public Service getSer() {
		return service;
	}


	public void setSer(Service service) {
		this.service=service;
	}
	


	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", customer=" + customer + ", beautician=" +
	beautician + ", service=" + service + "]";
	}
	
	static Map<Integer, Appointment> appointmentMap=new HashMap<Integer, Appointment>();
	
	public void bookAppointment() {
		System.out.println("Enter Your User Id");
		Integer userId=Integer.parseInt(sc.nextLine());
		if(!Customer.customerMap.containsKey(userId)) {//
			System.out.println("Please enter Valid Id");
			return;
		}
		customer=Customer.customerMap.get(userId);
		
		System.out.println("Please enter the service Id for service you want");
		service.serviceViewAllRecords();
		Integer serviceId=Integer.parseInt(sc.nextLine());
		if(!Service.serviceMap.containsKey(serviceId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		service=Service.serviceMap.get(serviceId);
		
		System.out.println("Please enter the Beautician Id for beautician you want ");
		beautician.beauticianViewAllRecords();
		Integer beauticianId=Integer.parseInt(sc.nextLine());
		if(!Beautician.beauticianMap.containsKey(beauticianId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		beautician=Beautician.beauticianMap.get(beauticianId);
		
		Random random=new Random();
		Integer randomId=null;
		while(true) {
			randomId=random.nextInt(101);
			if(!appointmentMap.containsKey(randomId))
				break;
		}
		
		Appointment object=new Appointment(randomId, customer, beautician, service);
		
		appointmentMap.put(randomId, object);
		
		System.out.println("Your Appointment Booked Successfully and your appointment Id is "+randomId);
		
	}
	
	public void appointmentModify() {
		System.out.println("Enter Your appointment Id to modify details");
		Integer appointmentId=Integer.parseInt(sc.nextLine());
		
		if(!appointmentMap.containsKey(appointmentId)) {
			System.out.println("Please Enter Valid Id");
			return;
		}
		
		Appointment object=appointmentMap.get(appointmentId);
		
		System.out.println("Enter Your User Id");
		Integer userId=Integer.parseInt(sc.nextLine());
		if(!Customer.customerMap.containsKey(userId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		customer=Customer.customerMap.get(userId);
		object.setCus(customer);
		
		System.out.println("Please enter the service Id for service you want");
		service.serviceViewAllRecords();
		Integer serviceId=Integer.parseInt(sc.nextLine());
		if(!Service.serviceMap.containsKey(serviceId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		service=Service.serviceMap.get(serviceId);
		object.setSer(service);
		
		System.out.println("Please enter the Beautician Id for beautician you want ");
		beautician.beauticianViewAllRecords();
		Integer beauticianId=Integer.parseInt(sc.nextLine());
		if(!Beautician.beauticianMap.containsKey(beauticianId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		beautician=Beautician.beauticianMap.get(beauticianId);
		object.setBea(beautician);
		
		appointmentMap.put(appointmentId, object);
		System.out.println("Appointment Updated");
		
	}
	
	public void appointmentDelete() {
		System.out.println("Enter Your Appointment Id to delete");
		Integer appointmentId=Integer.parseInt(sc.nextLine());
		if(!appointmentMap.containsKey(appointmentId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		appointmentMap.remove(appointmentId);
		System.out.println("Appointment Removed");
	}
	
	public void appointmentViewSingleRecord() {
		System.out.println("Enter Your Appointment Id for records");
		Integer appointmentId=Integer.parseInt(sc.nextLine());
		if(!appointmentMap.containsKey(appointmentId)) {
			System.out.println("Please enter Valid Id");
			return;
		}
		Appointment appointment=appointmentMap.get(appointmentId);
		System.out.println("Appointment Id = "+appointment.getAppointmentId());
		System.out.println("User Name = "+appointment.getCus().getCustomerName());
		System.out.println("Beautician Name = "+appointment.getBea().getBeauticianName());
		System.out.println("Service Name = "+appointment.getSer().getBeautyService());
		System.out.println("Service Charges = "+appointment.getSer().getCharges());
		System.out.println();
	}
	
	public void appointmentViewAllRecords() {
		if(appointmentMap.isEmpty()) {
			System.out.println("No Appointment Register");
			return;
		}
		System.out.println("All Appointments are:- ");
		for (Map.Entry<Integer, Appointment> entry : appointmentMap.entrySet()) {
            Integer key = entry.getKey();
            Appointment values = entry.getValue();
            
            System.out.println("Appointment Id = "+key);
    		System.out.println("User Name = "+values.getCus().getCustomerName());
    		System.out.println("Beautician Name = "+values.getBea().getBeauticianName());
    		System.out.println("Service Name = "+values.getSer().getBeautyService());
    		System.out.println("Service Charges = "+values.getSer().getCharges());
    		System.out.println();
            
		}
	}


	public void appointmentMenu() {
		int userChoice=-1;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to Appointment Menu Please Choose your next options: ");
		System.out.println(" Press 1 for Book an appointment \n Press 2 for Modify appointment Details"
				+ "\n Press 3 for Delete an appointment \n Press 4 for View single record "
				+ "\n Press 5 for View all records \n Press 0 for exit");
		int choice=Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1: {
			bookAppointment();
			break;
		}
		case 2: {
			appointmentModify();
			break;
		}
		case 3: {
			appointmentDelete();
			break;
		}
		case 4: {
			appointmentViewSingleRecord();
			break;
		}
		case 5: {
			appointmentViewAllRecords();
			break;
		}
		case 0:{
			break;
		}
		default:{
			throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		System.out.println("Enter 1 for continue else 0 for Exit from Appointment Menu");
		userChoice=Integer.parseInt(sc.nextLine());
		if(userChoice==0)
			break;
		else
			userChoice=-1;
		}while(true);
	}
}
