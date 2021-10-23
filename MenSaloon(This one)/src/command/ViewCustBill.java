package command;
//We have concrete command classes ViewManager implementing Order interface which will do actual command processing
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewCustBill implements Order {
    private CustBill custbill;

   public ViewCustBill(CustBill custbill){
      this.custbill = custbill;
   }

    public void execute() {
        try {
            custbill.view();
        } catch (IOException ex) {
            Logger.getLogger(ViewCustBill.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    

