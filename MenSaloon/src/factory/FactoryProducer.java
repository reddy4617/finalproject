package factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded){   
      if(rounded){
         return new ServicesAbstractFactory();         
      }else{
         return new ServicesFactory();
      }
   }
}
