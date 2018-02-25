/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockObserverTester;

import java.util.Map;

/**
 *
 * @author punk_rockguy
 */
public class PricesDisplay implements Observer, DisplayElement {
   /* 
    private Map<String,Double> priceMap;
    private String[] watchList;
    private Subject priceData;
    */
    
    private Map<String,Double> priceMap;
    private String id;
    private PriceData stockPrices;
    private String[] watchList;
    private Subject priceData;
    
    public PricesDisplay (String id, PriceData stockPrices){ 
       this.id = id;
       this.stockPrices = stockPrices;
       //id,stockPrices = priceMap;
      
        // this.watchList = watchList;
       priceData.registerObserver(this);
    }

   
  
    
    @Override
    public void display() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    System.out.printf("%s,%d",id,stockPrices);
    }
    
     void setStocks( String[] watchList) {
        this.watchList = watchList;
    }
  
      
    @Override
    public void update(Map<String, Double> priceMap){
        
        this.priceMap = priceMap;
        //this.id = id;
        //this.priceData = priceData;
        
        //this.watchList = watchList;
        display();
    }
    
    
}
