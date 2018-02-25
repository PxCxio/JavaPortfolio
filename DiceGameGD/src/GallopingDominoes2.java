import javax.swing.JOptionPane;

/**
 * A class to play a matching game using two dice. The dice are rolled and the
 * total is recorded. Then, the dice are continually rolled again until the
 * initial roll is matched, counting the number of rolls required
 */
class MatchGame2
{
    // instance var's are two Die objects - a pair of dice 
    private Die d1 ;				
    private Die d2 ;
    private int minimum;
    private int maximum;
    private int mR;
    private int lR;
    /**
     * Create a MatchGame object
     */
    public MatchGame2()
    {
        // create the two Die objects
        d1 = new Die() ;
        d2 = new Die() ;
         minimum = 55;
        maximum = 1;
        
    }
        
    /**
     * Plays the game. I.e., rolls the dice to get the initial roll and counts
     * number of additional rolls required to match it. Repeats as long as the
     * user wants to play another game
     */
    public void play() throws Exception
    {
        int initialRoll ;    // total of first roll of two dice

        int rollCount = 0 ;      // counts rolls taken to match initial roll

        int gameNumber = 0;  // counts number of games played

         String answer = JOptionPane.showInputDialog("Want to play?"
                + "\nType Y for Yes or N for No");
         
         
        while (rollCount != 1  )       // condition to play another game
        {
            gameNumber++;    // increment game counter, print game number
            System.out.println("Game #" + gameNumber + "\n==========") ;
            
            // get the initial roll
            initialRoll = d1.roll() + d2.roll();
            System.out.print("Initial roll = " + initialRoll + 
                             "\nRolling to match:") ;
          
            
            // roll dice again to try to match initial roll
            int currentRoll = d1.roll() + d2.roll();
            System.out.printf("%3d",currentRoll) ;                                  
            
            // initialize count of number of rolls needed to match
            rollCount = 1 ;
               
            
            // repeat as long as current roll does not match initial roll...
            
            // DO NOT MODIFY THIS LOOP!!!!!
            while (currentRoll != initialRoll )            // while no match...
            {     
                currentRoll = d1.roll() + d2.roll();      // roll 'em again!
                
                rollCount++ ;                             // increment count
                
                
                
                Thread.currentThread().sleep(500) ;     // pause 1/2 second
                System.out.printf("%3d",currentRoll) ;    // print current roll
                
                // start a new line and indent every 10 rolls
                if (rollCount % 10 == 0)                  
                {                                         
                   System.out.print("\n                 ") ;
                }                
            }
            // Loop postcondition:  initialRoll has been matched
            
            // print number of rolls needed to match
            System.out.print( "\nMatched in " + rollCount );
            if (rollCount > maximum)
                {
                    maximum = rollCount;
                    mR = initialRoll;
                }
                if (rollCount <= minimum)
                {
                    minimum = rollCount;
                    lR = initialRoll;
                }
                
            System.out.println( (rollCount == 1 ? " roll!\n" : " rolls!\n") );
            
            //*****//
            answer = JOptionPane.showInputDialog("Play again?" + "\nEnter Y for Yes, or N for NO");
            //*****//
        }
        System.out.println ("\n Your maximum number of rolls is " + maximum);
         System.out.println ("\n Your minimum is " + minimum);
        System.out.println("Most Attempts:  \n" + maximum + " to match a " + mR );
         System.out.println("Least Attempts:  \n" + minimum + " to match a " +  lR);
            
    }
    
}

public class GallopingDominoes2
{
    public static void main(String[] args) throws Exception
    {
        MatchGame2 fun = new MatchGame2();
        fun.play();
        
    }
}