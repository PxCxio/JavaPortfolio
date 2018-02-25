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
public interface Observer {
    public void update(Map<String,Double> priceMap);   
}
