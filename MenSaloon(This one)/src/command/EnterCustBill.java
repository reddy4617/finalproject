package command;
//We have concrete command classes EnterManager implementing Order interface which will do actual command processing

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnterCustBill implements Order {
    private CustBill custbill;

   public EnterCustBill(CustBill custbill){
      this.custbill = custbill;
   }

   public void execute() {
        try {
            custbill.enter();
        } catch (IOException ex) {
            Logger.getLogger(EnterCustBill.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    
