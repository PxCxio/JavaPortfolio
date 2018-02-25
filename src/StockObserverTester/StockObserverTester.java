/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockObserverTester;

/**
 *
 * @author punk_rockguy
 */
// StockObserverTest.java

import java.util.Map;
import java.util.HashMap;

public class StockObserverTester {

	private static Map<String,Double> priceMap  = new HashMap<String,Double>();
	private static PriceData priceData          = new PriceData();
	
public static void main(String[] args) {
	
		// establish two portfolios as listeners for priceData.
		// for now, we assume that both portfolios contain the same
		// collection of investments.
		
		PricesDisplay firstPortfolio = new PricesDisplay("00001", priceData);
		firstPortfolio.setStocks(new String[] {"ASD","ADM","AAC","AFAS"});
		
		PricesDisplay secondPortfolio = new PricesDisplay("00002", priceData);
		secondPortfolio.setStocks(new String[] {"BSD","BDM","BAC","BFAS"});

		generateInitialPrices();
		updatePrices(.02);
		updatePrices(-.05);
		updatePrices(.06);
		updatePrices(.03);
	}
	
	static void generateInitialPrices()
	{
		priceMap.put("ASD", 42.50);
		priceMap.put("ADM", 52.50);
		priceMap.put("AAC", 22.20);
		priceMap.put("AFAS", 45.00);		
		priceMap.put("BSD", 47.50);
		priceMap.put("BDM", 21.50);
		priceMap.put("BAC", 32.20);
		priceMap.put("BFAS", 44.00);		
		
		priceData.setPrices(priceMap);
	}
	
	static void updatePrices(double changePercent)
	{
		for( String key : priceMap.keySet())
		{
			double v = priceMap.get(key) * (1.0 + changePercent);
			priceMap.put(key, v);
		}
		priceData.setPrices(priceMap);
	}
        
        
}
