
import java.util.Random;

/**
 * A class to implement a standard 6-sided die
 */

public class Die	// die is the singular of "dice"
{
    // random number generator object
    private static Random r = new Random();

    /**
     * Rolls one die and returns the number rolled
     * @return a random int from 1 to 6
     */
    public int roll()
    {
        return r.nextInt(6) + 1;
    }
}
