package factory;

public class ServicesFactory extends AbstractFactory {
 @Override
   public Services getService(String services){    
      if(services.equalsIgnoreCase("viewServices")){
         return (Services) new ViewServices();         
      }else if(services.equalsIgnoreCase("enterServices")){
         return (Services) new EnterServices();
      }	 
      return null;
   }
}
