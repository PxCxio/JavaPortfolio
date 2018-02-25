package payrollsystem_phase3;

import java.util.*;

/**
 * The HourlyEmployee class is a subclass of the Employee class. It represents
 * employees that get paid by the hour.
 * 
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class HourlyEmployee extends Employee
{
    // instance variables
    private double hourlyRate;
    private double periodHours;
        
    
    /** 
     * This constructor sets the hourly employee's id, name, date of birth, list of
     * paychecks received, hourly rate, and period hours.   
     * @param id          The employee's identification number.
     * @param first       The employee's first name.
     * @param last        The employee's last name.
     * @param birth       The employee's date of birth.
     * @param paychecks   The list of paychecks the employee has received so far.
     * @param rate        The employee's hourly rate.
     * @param periodHrs   The number of hours the employee works during a pay period.
     * @exception IllegalArgumentException When either hourly rate or period hours is negative.
     */
    public HourlyEmployee(int id, String first, String last, String birth, ArrayList<Paycheck> paychecks, double rate, double periodHrs) throws IllegalArgumentException
    {
        super(id, first, last, birth, paychecks);

        // only final methods should be called from the constructor
        setHourlyRate(rate);
        setPeriodHours(periodHrs);
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param hourlyEmpObj The object being copied.
     */
    public HourlyEmployee(HourlyEmployee hourlyEmpObj)
    {
        super(hourlyEmpObj);
        
        if( hourlyEmpObj != null )
        {
            hourlyRate = hourlyEmpObj.hourlyRate;
            periodHours = hourlyEmpObj.periodHours;
        }
    }
    
    
    /**
     * The getHourlyRate method returns the rate that the employee gets paid per hour.
     * @return The employee's hourly rate.
     */
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    
    /**
     * The getPeriodHours method returns the number of hours the employee works during a pay period.
     * @return The employee's period hours.
     */
    public double getPeriodHours()
    {
        return periodHours;
    }
    
    
    /**
     * The setHourlyRate method sets the rate that the employee gets paid per hour.
     * @param rate The value to store in the hourly rate field.
     * @exception IllegalArgumentException When rate is negative.
     */
    public final void setHourlyRate(double rate) throws IllegalArgumentException
    {
        // if the rate parameter is negative, throw an exception.
        if( rate >= 0 )
            hourlyRate = rate;
        else
            throw new IllegalArgumentException("The hourly rate cannot be negative.");
    }
    
    /**
     * The setPeriodHours method sets the number of hours the employee works during a pay period.
     * @param periodHrs The value to store in the period hours field.
     * 
     * @exception IllegalArgumentException When periodHrs is negative.
     */
    public final void setPeriodHours(double periodHrs) throws IllegalArgumentException
    {
        // if the periodHrs parameter is negative, throw an exception.
        if( periodHrs >= 0 )
            periodHours = periodHrs;
        else
            throw new IllegalArgumentException("The period hours cannot be negative.");
    }
    
    
    /** 
     * The toString method returns a string containing the hourly employee's data.
     * @return A reference to a String.
     */
    @Override
    public String toString()
    {
        return  super.toString() + 
                String.format(  "%-30s %s \n%-30s %s", 
                                "Hourly Rate:", hourlyRate, 
                                "Period Hours:", periodHours );
    }
    
    
    /**
     * The copy method creates a new HourlyEmployee object and initializes it with the same data in the 
     * calling object.
     * @return a reference to the new object.
     */
    public HourlyEmployee copy()
    {
        return new HourlyEmployee(this);
    }
}
