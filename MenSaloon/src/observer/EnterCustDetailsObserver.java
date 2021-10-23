package observer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
//Create concrete observer classes
public class EnterCustDetailsObserver extends CustDetailsObserver{

    public EnterCustDetailsObserver (CustDetails custdetails) {
        this.custdetails = custdetails;
         this.custdetails.attach(this);
    }

    @Override
    public void update() {
//THE CODE TO ENTER CUSTOMER's DETAILS WILL BE WRITTEN HERE
        try{
            Scanner sc=new Scanner(System.in);                          //object of Scanner class  
            String name= "CustomerData.txt";                            //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);    // true for append mode  

            System.out.print("Enter Customer's ID: ");         
            String CustId=sc.nextLine()+"\n";                           //str stores the string which we have entered  
            byte[] custid = CustId.getBytes();                          //converts string into bytes  
            fos.write(custid);
            
            System.out.print("Enter Customer's Full Name: ");         
            String fullName=sc.nextLine()+"\n";               //str stores the string which we have entered  
            byte[] fn = fullName.getBytes();                  //converts string into bytes  
            fos.write(fn); 

            System.out.print("Enter Customer's Phone Number: ");
            String PhoneNumber=sc.nextLine()+"\n";             //str stores the string which we have entered  
            byte[] phone = PhoneNumber.getBytes();                //converts string into bytes  
            fos.write(phone);                                  
            
            fos.close();                                      //close the file  
            System.out.println("file saved.");
        }
        catch(IOException e)
        {
        }
    }
    
}

