/**
 * A class to represent a hot-air balloon.  Balloon objects have a name and an
 * altitude.
 */
public class Balloon
{
	// instance variables
  	private String name ; 			// name of the balloon
  	private int altitude;     		// altitude (height) of balloon in meters
  	
	/**
   	 * Create a balloon object with a given name at a given altitude.
     * @param theName the name of the balloon object
     * @param theAltitude the altitude
     */ 
  	public Balloon(String theName, int theAltitude)
  	{
  		name = theName ;
  		// make sure altitude is not negative!
  		altitude = Math.max(theAltitude,0) ;
  	}
  		
	/**
	 * Ascend to a particular altitude.
	 * @param newAlt the altitude to which to ascend, in meters.
	 */
	public void ascendTo(int newAlt)
	{
  		// ascend to new altitude only if it is greater than current altitude, 
    	
    	if (newAlt > altitude)
    	{
        	altitude = newAlt ; 
    	}
	}
	
	/**
	 * Descend to a particular altitude.
	 * @param newAlt the altitude to which to descend, in meters.
	 */
	public void descendTo(int newAlt)
	{
    	// prevent possible crash into ground
    	if (newAlt < 0)			// if desired altitude is below ground level!
    	{
    		altitude = 0 ;		// ...descend only to ground level
    	}
    	// otherwise, descend only if new altitude is less than current altitude
    	else if (newAlt < altitude)
    	{
        	altitude = newAlt ; 
    	}
	}
  	
  	/**
  	 * Modify altitude by a given number of meters, up or down.
  	 * @param change number of meters to add to current altitude
  	 */	
	public void adjustAltitude(int change)
	{
    	// if change is negative (i.e. descending), can't go below 0 altitude
    	if (change + altitude < 0)  // change < 0 && abs(change) > altitude
    	{
    		altitude = 0 ;	// ...descend only to ground level
    	}
    	else				// safe to modify current alt by "change" meters
    	{
        	altitude = altitude + change ; 
    	}
	}
        
	/**
	 * Get ballon name.
	 * @return the name of the balloon
	 */
	public String getName()
	{
		return name ;
	}
	
	/**
	 * Get current altitude.
	 * @return the altitude of the balloon
	 */
	public int getAltitude()
	{
		return altitude ;
	}
}
// end of Balloon class definition