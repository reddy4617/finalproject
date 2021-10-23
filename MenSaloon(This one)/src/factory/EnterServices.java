package factory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EnterServices implements Services {
    public void draw() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

    @Override
    public void viewEnterServices() {
        
         try{
            Scanner sc=new Scanner(System.in);                          //object of Scanner class  
            String name= "ServicesData.txt";                            //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);    // true for append mode  

            System.out.print("Enter Service ID: ");         
            String ServiceId=sc.nextLine()+"\n";                        //str stores the string which we have entered             byte[] serviceid = ServiceId.getBytes();                          //converts string into bytes  
            byte[] serviceid = ServiceId.getBytes();                //converts string into bytes  
            fos.write(serviceid);
            
            System.out.print("Enter Service Name: ");         
            String ServiceName=sc.nextLine()+"\n";                      //str stores the string which we have entered  
            byte[] servicename = ServiceName.getBytes();                //converts string into bytes  
            fos.write(servicename); 

            System.out.print("Enter Service Price: ");
            String ServicePrice=sc.nextLine()+"\n";                     //str stores the string which we have entered  
            byte[] serviceprice = ServicePrice.getBytes();              //converts string into bytes  
            fos.write(serviceprice);                                  
            
            fos.close();                                                //close the file  
            System.out.println("file saved.");
        }
        catch(IOException e)
        {
        }
    }
    
}

