/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
.nextInt
/**
 *
 * @author punk_rockguy
 */

        
public class BalloonTester {
    public static void main (String args[])
	{
		Balloon redBalloon = new Balloon ("redBalloon", 100) ;
                Balloon blackBalloon = new Balloon ("blackBalloon", -100) ;

              
                
    System.out.println( redBalloon.getName() + " is at " + redBalloon.getAltitude() + "\nAnd " + 
            blackBalloon.getName() + " is at " + blackBalloon.getAltitude()) ;
   
    redBalloon.ascendTo(250);
    blackBalloon.adjustAltitude(150);
    
    System.out.println( redBalloon.getName() + " is at " + redBalloon.getAltitude() + "\nAnd " + 
            blackBalloon.getName() + " is at " + blackBalloon.getAltitude()) ;
    
    redBalloon.adjustAltitude(-150);
    blackBalloon.descendTo(redBalloon.getAltitude());
    
    System.out.println( redBalloon.getName() + " is at " + redBalloon.getAltitude() + "\nAnd " + 
            blackBalloon.getName() + " is at " + blackBalloon.getAltitude()) ;
    
    redBalloon.ascendTo(redBalloon.getAltitude()*4);
    blackBalloon.descendTo(blackBalloon.getAltitude()-150);
    
    System.out.println( redBalloon.getName() + " is at " + redBalloon.getAltitude() + "\nAnd " + 
            blackBalloon.getName() + " is at " + blackBalloon.getAltitude()) ;
}
    
}