/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ciro
 *
 */
public class LeaseEvaluator {
    

		// instance variables
	private String name ;			// name of the costumer
	private double mPayment ;			// monthy Payment
	private int term;               // Term of the elase in months
        private double downPayment;         //The downpayment
        private double maxFreeMilesY;  // maximum number of free miles allowed per year
	private double chargePerMile;   // chargePerMile driven over
        private double milesDriven ;    // actual number of miles riven over the life of the lease
        
        
	/**
	 * Create a pyramid object with
	 
	 
	 */
	public LeaseEvaluator (String theName, double mPayment, int term,double downPayment ,double maxFreeMilesY,double chargePerMile,double milesDriven)
	{
		this.name = theName;
		this.mPayment = mPayment;
		this.term = term;
                this.downPayment = downPayment;
                this.maxFreeMilesY = maxFreeMilesY;
                this.chargePerMile = chargePerMile;
                this.milesDriven = milesDriven;
                
	}
	
        
	/**
	 * Get the x-coordinate of the center.
	 * @return the x-coordinate of the center
	 */
	public String getName()
	{
		return this.name ;
	}
	
	/**
	 * Get the y-coordinate of the center.
	 * @return the y-coordinate of the center
	 */
	public double getmPayment()
	{
		return this.mPayment ;
	}
        
	public int getTerm()
	{
		return this.term ;
	}
        
        public double getDownPayment()
	{
		return this.downPayment ;
	}
        
        public double getMaxFreeMilesY()
	{
		return this.maxFreeMilesY ;
	}
        
        public double getChargePerMile()
	{
		return this.chargePerMile ;
	}
        
        public double getMilesDriven()
	{
		return this.milesDriven ;
	}
       public void adjustMonthlyPayment(double change)
	{
    	mPayment = change;
	}
               
       public double milesOver()
       {
           return (milesDriven - maxFreeMilesY);
       }
        public double getCostPerMonth()
        {
      
                if (milesOver() < 0.0)
                {
               return ((((downPayment + (mPayment * term))/term) + (((downPayment + (mPayment * term))/term)*0.07)));
                        } 
                else
        {
               return  (((downPayment + (mPayment * term) + (chargePerMile * ( milesDriven - maxFreeMilesY)))/term) + ((downPayment + (mPayment * term)+ (chargePerMile * ( milesDriven - maxFreeMilesY))/term)*0.07));
           
        }
        
        }
}
	/**
	 * Get the radius.
	 * @return the radius
	 */
