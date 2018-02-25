/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockObserverTester;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author punk_rockguy
 */
public class PriceData implements Subject {
  
    private Map<String,Double> priceMap;
    private ArrayList<Observer> observers;
    
    public PriceData(){
       // priceMap = new HashMap<String, Double>();
        observers = new ArrayList<Observer>();
        
    }

    @Override
    public void registerObserver(Observer o) {
        
        observers.add(o);
       
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
                observers.remove(i);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(priceMap);
        }
       //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void pricesChanged(){
        notifyObservers();
    }

    public void setPrices(Map<String, Double> priceMap) {
        this.priceMap = priceMap;
        
        
    }        
    
    public Map<String, Double> getMap() {
    priceMap.values();
    return priceMap;
}
    
}

