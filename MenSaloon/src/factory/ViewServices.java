package factory;

import observer.ViewCustDetailsObserver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewServices implements Services {
    public void draw() {
      throw new UnsupportedOperationException("Not supported yet.");
   }

    @Override
    public void viewEnterServices() {        
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("ServicesData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewCustDetailsObserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("***************SERVICES DATA*****************");
        for(int i = 0; i<lines.size();i++){
            System.out.println("___________________________________________");
            System.out.println("Service ID      : "+lines.get(i));
            System.out.println("Service Name    : "+lines.get(i+1));
            System.out.println("Service Price   : "+lines.get(i+2));
            i=i+2;
            System.out.println("___________________________________________");
            System.out.println("\n");
        }
        System.out.println("*******************************************");
    }
}    

