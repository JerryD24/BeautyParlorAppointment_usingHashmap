package BeautyParlor;

import java.util.Scanner;
public class MainMenu {
    public static void main(String[] args) {
        int userChoice = -1;
        Customer customer=new Customer();
    	Beautician beautician=new Beautician();
    	Service service=new Service();
    	Appointment appointment=new Appointment();
    	customer.initialCustomerMap();
    	beautician.initialBeauticianMap();
    	service.initialServiceMap();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome to XYZ Beauty Parlour \n");
            System.out.println("Please Enter who you are ");
            System.out.println(" Press 1 for Customer Menu \n Press 2 for Beautician Menu \n Press"
                    + " 3 for Appointment Menu \n Press 4 for Service Menu \n Press 0 for exit");
            int choice = Integer.parseInt(sc.nextLine());
            
            switch (choice) {
                case 1: {
                    customer.customerMenu();
                    break;
                }
                case 2: {
                    beautician.beauticianMenu();
                    break;
                }
                case 3: {
                    appointment.appointmentMenu();
                    break;
                }
                case 4: {
                    service.serviceMenu();
                    break;
                }
                case 0: {
                    userChoice = 0;
                    break;
                }
                default: {
                    System.out.println("Unexpected value: " + choice);
                }
            }
            
            if (userChoice != 0) {
                System.out.println("Enter 1 to continue to Main Menu or 0 to Exit from App");
                userChoice = Integer.parseInt(sc.nextLine());	
            }
            
        } while (userChoice != 0);

        System.out.println("Thank You! Please Visit us Again");
        sc.close();
    }
}
