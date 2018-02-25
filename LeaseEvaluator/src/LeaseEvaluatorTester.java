/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

        
/**
 *
 * @author Ciro
 */
public class LeaseEvaluatorTester {
    
     public static void main (String args[])
	{
		LeaseEvaluator ciroLeaseEvaluator = new LeaseEvaluator ("Ciro Pascasio", 129, 12, 129, 50, 3.99, 125);
                
                String name;
                double mPayment;
                int term;
                double downPayment;
                double maxFreeMilesY;
                double chargePerMile;
                double milesDriven;
                
                
                System.out.println("The name of the client is: " + ciroLeaseEvaluator.getName());
                System.out.println("The monthly payment for new 2015 BlingMobile XS is: $" + ciroLeaseEvaluator.getmPayment());
                System.out.println("The term is " + ciroLeaseEvaluator.getTerm() + " months.");
                System.out.println("The down payment for the phone is an initial: $" + ciroLeaseEvaluator.getDownPayment());
                System.out.println("The maximum free miles allowed are " + ciroLeaseEvaluator.getMaxFreeMilesY()+ " miles.");
                System.out.println("The charge per extra mile passed from the free miles is $" + ciroLeaseEvaluator.getChargePerMile());
                System.out.println("The actual miles driven were " + ciroLeaseEvaluator.getMilesDriven() + " miles");
                System.out.println("The actual cost per month is: $" + (ciroLeaseEvaluator.getCostPerMonth()));
                
                ciroLeaseEvaluator.adjustMonthlyPayment(139);
                System.out.println("When the monthly payment is changed from $129 to $139 \nThe monthly payment will be: ");
                System.out.println("$" + ciroLeaseEvaluator.getCostPerMonth());
}               
     
}              
