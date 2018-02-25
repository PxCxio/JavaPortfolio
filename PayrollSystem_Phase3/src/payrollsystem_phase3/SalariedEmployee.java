package payrollsystem_phase3;

import java.util.ArrayList;

/**
 * The SalariedEmployee class is a subclass of the Employee class. It represents
 * employees that get paid an annual salary.
 * 
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class SalariedEmployee extends Employee
{
    // instance variable
    private double annualSalary;
    
    
    /** 
     * This constructor sets the salaried employee's id, name, date of birth, list of
     * paychecks received, and annual salary.   
     * @param id          The employee's identification number.
     * @param first       The employee's first name.
     * @param last        The employee's last name.
     * @param birth       The employee's date of birth.
     * @param paychecks   The list of paychecks the employee has received so far.
     * @param salary      The employee's annual salary.
     * @exception IllegalArgumentException When salary is negative.
     */
    public SalariedEmployee(int id, String first, String last, String birth, ArrayList<Paycheck> paychecks, double salary)
    {
        super(id, first, last, birth, paychecks);

        // only final methods should be called from the constructor
        setAnnualSalary(salary);
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param salariedEmpObj The object being copied.
     */
    public SalariedEmployee(SalariedEmployee salariedEmpObj)
    {
        super(salariedEmpObj);
        
        if( salariedEmpObj != null )
        {
            annualSalary = salariedEmpObj.annualSalary;
        }
    }
    
    
    /**
     * The getAnnualSalary method returns the salary that the employee gets paid per year.
     * @return The employee's annual salary.
     */
    public double getAnnualSalary()
    {
        return annualSalary;
    }
    
    
    /**
     * The setAnnualSalary method sets the salary that the employee gets paid per year.
     * @param salary The value to store in the annual salary field.
     * 
     * @exception IllegalArgumentException When salary is negative.
     */
    public final void setAnnualSalary(double salary) throws IllegalArgumentException
    {
        // if the salary parameter is negative, throw an exception.
        if( salary >= 0 )
            annualSalary = salary;
        else
            throw new IllegalArgumentException("The salary cannot be negative.");
    }
    
    
    /** 
     * The toString method returns a string containing the salaried employee's data.
     * @return A reference to a String containing the object's state.
     */
    @Override
    public String toString()
    {
        return  super.toString() +
                String.format("%-30s %s\n", "Annual Salary:", annualSalary );
    }
   
    
    /**
     * The copy method creates a new SalariedEmployee object and initializes it with the same data in the 
     * calling object.
     * @return a reference to the new object.
     */
    public SalariedEmployee copy()
    {
        return new SalariedEmployee(this);
    }
    
}
