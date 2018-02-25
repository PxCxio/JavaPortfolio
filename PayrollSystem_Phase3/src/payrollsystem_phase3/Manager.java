package payrollsystem_phase3;

import java.util.ArrayList;

/**
 * The Manager class is a subclass of the SalariedEmployee class. It represents
 * salaried employees who also manage a department.
 * 
 * @author Mayelin
 */
public class Manager extends SalariedEmployee
{
    // instance variable
    private double bonus;
    
    
    /** 
     * This constructor sets the manager's id, name, date of birth, list of
     * paychecks received, annual salary, and weekly bonus.   
     * @param id          The manager's identification number.
     * @param first       The manager's first name.
     * @param last        The manager's last name.
     * @param birth       The manager's date of birth.
     * @param paychecks   The list of paychecks the manager has received so far.
     * @param salary      The manager's annual salary.
     * @param bonus       The manager's weekly bonus.
     * @exception IllegalArgumentException When either salary or bonus is negative.
     */
    public Manager(int id, String first, String last, String birth, ArrayList<Paycheck> paychecks, double salary, double bonus)
    {
        super(id, first, last, birth, paychecks, salary);
        
        // only final methods should be called from the constructor
        setBonus(bonus);
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param managerObj The object being copied.
     */
    public Manager(Manager managerObj)
    {
        super(managerObj);
        
        if( managerObj != null )
        {
            bonus = managerObj.bonus;
        }
    }
    
    
    /**
     * The getBonus method returns the bonus that the manager gets every week.
     * @return The manager's weekly bonus.
     */
    public double getBonus()
    {
        return bonus;
    }
    
   
    /**
     * The setBonus method sets the bonus amount that the manager gets.
     * @param bonus The value to store in the bonus field.
     * 
     * @exception IllegalArgumentException When bonus is negative.
     */
    public final void setBonus(double bonus) throws IllegalArgumentException
    {
        // if the bonus parameter is negative, throw an exception.
        if( bonus >= 0 )
            this.bonus = bonus; 
        else
            throw new IllegalArgumentException("The bonus cannot be negative.");
    }
    
    
    /** 
     * The toString method returns a string containing the manager's data.
     * @return A reference to a String.
     */
    @Override
    public String toString()
    {
        return  super.toString() +
                String.format("%-30s %s\n","Bonus:", bonus );
    }
    
    
    /**
     * The copy method creates a new Manager object and initializes it with the same data in the 
     * calling object.
     * @return a reference to the new object.
     */
    @Override
    public Manager copy()
    {
        return new Manager(this);
    }
    
}
