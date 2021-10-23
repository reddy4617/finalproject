package mensaloon;
//Use Of Factory Abstract Pattern, Command Pattern and Observer Pattern.

import command.CustBill;
import command.CustBillInvoker;
import command.EnterCustBill;
import command.ViewCustBill;
import factory.AbstractFactory;
import factory.Services;
import factory.FactoryProducer;
import observer.EnterCustDetailsObserver;
import observer.CustDetails;
import observer.ViewCustDetailsObserver;


public class MenSaloon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int check;
  
        char CustDetailsValue;
        char VoterRecordsValue;
        char CustBillValue;

        while(true){
//MAIN MENU DISPLAY
            System.out.println("PHOENIX MEN SALOON");
            System.out.println("  _/|       |\\_            WELCOME TO        ");
            System.out.println(" /  |       |  \\       PHOENIX MEN SALOON    ");
            System.out.println("|    \\     /    |                            ");
            System.out.println("|  \\ /     \\ /  |   Options:                ");
            System.out.println("|  \\ |     | /  |      a. Customer Details   ");
            System.out.println("| \\ _\\_/A\\_/_ / |      b. Services Offered   ");
            System.out.println("|    --\\ /--    |      c. Bill Customers     ");
            System.out.println(" \\_  \\     /  _/       d. Exit               ");
            System.out.println("   \\__  |  __/");
            System.out.println("      \\ _ /");
            System.out.println("      /   \\");
            System.out.println("    / _/|\\_ \\");
            System.out.println("     /  |  \\");
            System.out.println("      / V \\");
            check = Keyin.inChar("Select option: ");
            System.out.println("\n");
            
            
            
        
            switch (check) {     
//CASE 'a' IS CUSTOMER DETAILS MODULE USING OBSERVER DESIGN PATTERN 
//Observer pattern uses three actor classes. CustDetails, Observer and Client                    
                case ('a'):
                    System.out.println("Enter a to View   Customer Details: ");
                    System.out.println("Enter b to Insert Customer Details: ");
                    CustDetailsValue = Keyin.inChar(" Select option: ");
                    System.out.println("\n");
                    
                    CustDetails custdetails = new CustDetails();
                    
                
                     if(CustDetailsValue=='a'){
//Using CustDetailsObserver and concrete observer objects.                         
                         new ViewCustDetailsObserver(custdetails);
//CustDetails is an object having methods to attach and detach observers to a client object                        
                        custdetails.setState(1);
                        break;
                    }
                     
                     if(CustDetailsValue=='b'){
//Using CustDetailsObserver and concrete observer objects.                         
                        new EnterCustDetailsObserver(custdetails);
//CustDetails is an object having methods to attach and detach observers to a client object                             
                        custdetails.setState(1);
                        break;
                    }
                    
                    break;
                    
//CASE 'b' IS VOTER RECORD USING FACTORY DESIGN PATTERN
//We will use VoterRecordsFactory to get a object. It will pass information (viewSchedule,enterSchedule) 
//to VoterRecordsFactory to get the type of object it needs.                    
                case ('b'):
                    System.out.println("Enter 'a' to View   Services Offered:");
                    System.out.println("Enter 'b' to Insert Services Offered:");
                    VoterRecordsValue = Keyin.inChar(" Select option: ");
                    System.out.println("\n");
//Using the AbstractFactory to get object of concrete class by passing an information such as type.                    
                   AbstractFactory abstractFactory = FactoryProducer.getFactory(false);

                    if(VoterRecordsValue=='a'){
//get an object of Services and call its viewEnterServices method.
                            Services services1 = abstractFactory.getService("viewServices");
//call viewEnterServices method 
                            services1.viewEnterServices();
                    }
                    
                    if(VoterRecordsValue=='b'){
//get an object of Services and call its viewEnterServices method.
                            Services services1 = abstractFactory.getService("enterServices");
//call viewEnterServices method 
                            services1.viewEnterServices();
                    }
                 
                    break;
                    

                    
//CASE 'c' IS BILL CUSTOMER USING COMMAND DESIGN PATTERN   
//In this command design pattern we are encapsulating  a request as an object,
//which lets us parameterize other objects with different requests and support undoable operations.
//We have created an interface Order.java which is acting as a command                
//will use Manager class to demonstrate command pattern.                
                case 'c':
                    System.out.println("Enter a to View     Customer Bill");
                    System.out.println("Enter b to Generate Customer Bill");
                    CustBillValue = Keyin.inChar(" Select option: ");
                    System.out.println("\n");
                    
                    if(CustBillValue=='a'){
//Create a command interface.                        
                        CustBill custbill = new CustBill();                        
//Create a request class.                        
                        ViewCustBill viewCustBillOrder = new ViewCustBill(custbill);
//Creating a command invoker class.                         
                        CustBillInvoker custBillInvoker = new CustBillInvoker();
                      
                        custBillInvoker.takeOrder(viewCustBillOrder);
                        custBillInvoker.placeOrders();
                    }
                    else if(CustBillValue=='b'){
//Create a command interface.
                        CustBill custbill = new CustBill();
//Create a request class.                        
                        EnterCustBill enterCustBillOrder = new EnterCustBill(custbill);
//Creating a command invoker class.                      
                        CustBillInvoker enterCustBillInvoker = new CustBillInvoker();
                      
                        enterCustBillInvoker.takeOrder(enterCustBillOrder);
                        enterCustBillInvoker.placeOrders();
                        break;
                    }
                    break;                   
                    
//CASE 4 IS EXITING PROGRAM 
                    case ('d'):
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                    
//CASE DEFAULT IS PRINTING OUT THE INVALID SELECTION BY THE USER
                    default:
                        System.out.println("Invalid selection");
                        break; // This break is not really necessary but its a formality
    }
   
    }
  }




// keyin methos is for input of character type only in main menu

class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

 //Mehtod to get Char input only
  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

 
}
        
    }
    
       



    