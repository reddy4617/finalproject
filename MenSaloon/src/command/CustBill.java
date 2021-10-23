package command;
//CustBill uses command pattern to identify which object will execute which command based on the type of command

import observer.ViewCustDetailsObserver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustBill {

    public void view() throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Customer's ID to view his bill: ");
        String cust_id = input.next();
        String filename = cust_id + "Bill.txt";
        ArrayList<String> lines = null;
        int i = 0;
        int total = 0;

        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get(filename))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewCustDetailsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("***************CUSTOMER's BILL*****************");

        System.out.println("___________________________________________");
        System.out.println("Customer's ID           : " + lines.get(i));
        System.out.println("Customer's Name         : " + lines.get(i + 1));
        System.out.println("Customer's Phone Number : " + lines.get(i + 2));
        for (int k = 3; k < lines.size(); k++) {
            total += Integer.parseInt(lines.get(k));
        }
        System.out.println("Customer's Total Bill   : " + total);

        System.out.println("___________________________________________");
        System.out.println("\n");

        System.out.println("*******************************************");

    }

    public void enter() throws IOException {
        try{
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("ServicesData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewCustDetailsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("***************SERVICES TO INCLUED IN BILL*****************");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("-------------------------------------------");
            System.out.println("Service ID      : " + lines.get(i));
            System.out.println("Service Name    : " + lines.get(i + 1));
            System.out.println("Service Price   : " + lines.get(i + 2));
            i = i + 2;
        }
        System.out.println("-------------------------------------------");
        System.out.println("*******************************************");

        ArrayList<String> lines1 = null;
        lines1 = new ArrayList<>(Files.readAllLines(Paths.get("CustomerData.txt")));
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer's ID: ");
        String cust_id = input.next();

       
        int i = 0;
       for (i=0;i<lines1.size();i++){
            String CustomerID = lines1.get(i);
          
                if (cust_id.equalsIgnoreCase(CustomerID)) {

                    Scanner sc = new Scanner(System.in);                          //object of Scanner class  

                    String txt = "Bill.txt";                            //variable name to store the file name  
                    String name = cust_id + txt;
                    FileOutputStream fos = new FileOutputStream(name, true);    // true for append mode  

                    String CustId = lines1.get(i) + "\n";                           //str stores the string which we have entered  
                    byte[] custid = CustId.getBytes();                          //converts string into bytes  
                    fos.write(custid);

                    String fullName = lines1.get(i + 1) + "\n";               //str stores the string which we have entered  
                    byte[] fn = fullName.getBytes();                  //converts string into bytes  
                    fos.write(fn);

                    String PhoneNumber = lines1.get(i + 2) + "\n";             //str stores the string which we have entered  
                    byte[] phone = PhoneNumber.getBytes();                //converts string into bytes  
                    fos.write(phone);

                    int servicesoffered = 1;
                    System.out.println("Enter Price of Service Offered or Enter 0('zero') to proceed further: ");
                    while (servicesoffered != 0) {

                        servicesoffered = input.nextInt();
                        String ss = String.valueOf(servicesoffered) + "\n";
                        byte[] servoff = ss.getBytes();
                        fos.write(servoff);
                    }

                    fos.close();                                      //close the file  
                    System.out.println("file saved.");

                    break;
                }
                
            }
            i = i + 3;
        
        }catch(Exception e){
            System.out.println("Customer Not fFound");
    }
    }

}
