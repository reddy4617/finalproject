package observer;
//Create concrete observer classes

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViewCustDetailsObserver extends CustDetailsObserver {
    public ViewCustDetailsObserver(CustDetails custdetails){
        this.custdetails = custdetails;
        this.custdetails.attach(this);
    }
  @Override
    public void update() {
        //THE CODE TO VIEW CUSTOMERS WILL BE WRITTEN HERE
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("CustomerData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewCustDetailsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("***************CUSTOMERS DATA*****************");
        for(int i = 0; i<lines.size();i++){
            System.out.println("___________________________________________");
            System.out.println("Customer's ID           : "+lines.get(i));
            System.out.println("Customer's Name         : "+lines.get(i+1));
            System.out.println("Customer's Phone Number : "+lines.get(i+2));
            i=i+2;
            System.out.println("___________________________________________");
            System.out.println("\n");
        }
        System.out.println("*******************************************");
    }
    
}
