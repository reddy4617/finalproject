package observer;


import java.util.ArrayList;
import java.util.List;

public class CustDetails {
    private List<CustDetailsObserver> custdetailsobservers = new ArrayList<CustDetailsObserver>();
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(CustDetailsObserver custdetailsobserver){
        custdetailsobservers.add(custdetailsobserver);
    }

    public void notifyAllObservers(){
        for (CustDetailsObserver custdetailsobserver : custdetailsobservers) {
        custdetailsobserver.update();
        }
    } 	
    
}