package payrollsystem_phase3;

import java.io.Serializable;


/**
 * The Paycheck class represents a paycheck paid to an employee for a pay period.
 * 
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class Paycheck implements Serializable
{
    // instance variables
    private int employeeID;
    private String periodBeginDate;
    private String periodEndDate;
    private String payDate;
    private double grossAmount;
    private double taxAmount;
    private double bonusAmount;
    private double netAmount;
    
    
    /** 
     * The constructor sets the paycheck's employee id, begin and end dates for the pay period, 
     * pay date, as well as the gross, tax, bonus and net amounts.   
     * @param empID       Identification number of the employee receiving this paycheck.
     * @param beginDate   Begin date for this paycheck's pay period.
     * @param endDate     End date for this paycheck's pay period.
     * @param payDt       Pay date for this paycheck.
     * @param grossAmt    Gross amount paid in this paycheck.
     * @param taxAmt      Tax amount deducted in this paycheck.
     * @param bonusAmt    Bonus amount paid in this paycheck.
     * @param netAmt      Net amount paid in this paycheck.
     */
    public Paycheck(int empID, String beginDate, String endDate, String payDt, double grossAmt, double taxAmt, double bonusAmt, double netAmt)
    {
        employeeID = empID;
        periodBeginDate = beginDate;
        periodEndDate = endDate;
        payDate = payDt;
        grossAmount = grossAmt;
        taxAmount = taxAmt;
        bonusAmount = bonusAmt;
        netAmount = netAmt;
    }

    
     /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param paycheckObj The object being copied.
     */
    public Paycheck(Paycheck paycheckObj)
    {   
        if( paycheckObj != null )
        {
            employeeID = paycheckObj.employeeID;
            periodBeginDate = paycheckObj.periodBeginDate;
            periodEndDate = paycheckObj.periodEndDate;
            payDate = paycheckObj.payDate;
            grossAmount = paycheckObj.grossAmount;
            taxAmount = paycheckObj.taxAmount;
            bonusAmount = paycheckObj.bonusAmount;
            netAmount = paycheckObj.netAmount;
        }
    }
    
    
    /**
     * The getEmployeeID method returns the identification number of the employee receiving this paycheck.
     * @return The employee's id.
     */
    public int getEmployeeID()
    {
        return employeeID;
    }

    
    /**
     * The getPeriodBeginDate method returns the begin date for this paycheck's pay period.
     * @return The pay period's begin date.
     */
    public String getPeriodBeginDate()
    {
        return periodBeginDate;
    }

    
    /**
     * The getPeriodEndDate method returns the end date for this paycheck's pay period.
     * @return The pay period's end date.
     */
    public String getPeriodEndDate()
    {
        return periodEndDate;
    }

    
    /**
     * The getPayDate method returns the pay date for this paycheck.
     * @return The paycheck's pay date.
     */
    public String getPayDate()
    {
        return payDate;
    }

    
    /**
     * The getGrossAmount method returns the gross amount paid in this paycheck.
     * @return The paycheck's gross amount.
     */
    public double getGrossAmount()
    {
        return grossAmount;
    }

    
    /**
     * The getTaxAmount method returns the tax amount deducted in this paycheck.
     * @return The paycheck's tax amount.
     */
    public double getTaxAmount()
    {
        return taxAmount;
    }

    
    /**
     * The getBonusAmount method returns the bonus amount paid in this paycheck.
     * @return The paycheck's bonus amount.
     */
    public double getBonusAmount()
    {
        return bonusAmount;
    }

    
    /**
     * The getNetAmount method returns the net amount that the employee is getting paid in this paycheck.
     * @return The paycheck's net amount.
     */
    public double getNetAmount()
    {
        return netAmount;
    }

    
    /**
     * The setEmployeeID method sets the identification number of the employee receiving this paycheck.
     * @param empID The value to store in the employee ID field.
     */
    public void setEmployeeID(int empID)
    {
        employeeID = empID;
    }

    
    /**
     * The setPeriodBeginDate method sets the begin date for this paycheck's pay period.
     * @param beginDate The value to store in the pay period begin date field for this paycheck.
     */
    public void setPeriodBeginDate(String beginDate)
    {
        periodBeginDate = beginDate;
    }

    
    /**
     * The setPeriodEndDate method sets the end date for this paycheck's pay period.
     * @param endDate The value to store in the pay period end date field for this paycheck.
     */
    public void setPeriodEndDate(String endDate)
    {
        periodEndDate = endDate;
    }

    
    /**
     * The setPeriodEndDate method sets the pay date for this paycheck.
     * @param payDt The value to store in the pay date field for this paycheck.
     */
    public void setPayDate(String payDt)
    {
        payDate = payDt;
        
    }

    
    /**
     * The setGrossAmount method sets the gross amount for this paycheck.
     * @param payAmt The value to store in the gross amount field for this paycheck.
     */
    public void setGrossAmount(double payAmt)
    {
        grossAmount = payAmt;
    }

    
    /**
     * The setTaxAmount method sets the tax amount for this paycheck.
     * @param taxAmount The value to store in the tax amount field for this paycheck.
     */
    public void setTaxAmount(double taxAmount)
    {
        this.taxAmount = taxAmount;
    }

    
    /**
     * The setBonusAmount method sets the bonus amount for this paycheck.
     * @param bonusAmount The value to store in the bonus amount field for this paycheck.
     */
    public void setBonusAmount(double bonusAmount)
    {
        this.bonusAmount = bonusAmount;
    }

    
    /**
     * The setNetAmount method sets the net amount for this paycheck.
     * @param netAmount The value to store in the net amount field for this paycheck.
     */
    public void setNetAmount(double netAmount)
    {
        this.netAmount = netAmount;
    }
    
    
    /** 
     * The toString method returns a string containing the paycheck's data.
     * @return A reference to a String.
     */
    @Override
    public String toString()
    {
        String separator = String.format("\n%30s %031d", "", 0).replace('0', '-');
        
        return  String.format(  "\n%30s %-20s %10s \n%30s %-20s %10s \n%30s %-20s %10s " +
                                "\n%30s %-20s %10s \n%30s %-20s %10s \n%30s %-20s %10s " +
                                "\n%30s %-20s %10s \n%30s %-20s %10s", 
                                "", "Employee ID:", employeeID,
                                "", "Period Begin Date:", periodBeginDate,
                                "", "Period End Date:", periodEndDate, 
                                "", "Pay Date:", payDate, 
                                "", "Gross Amount:", grossAmount, 
                                "", "Tax Amount:", taxAmount, 
                                "", "Bonus Amount:", bonusAmount, 
                                "", "Net Amount:", netAmount) + separator;
    }
    
    
    /**
     * The equals method compares the Paycheck object calling this method with the
     * Paycheck object passed as an argument.
     * @param obj The Paycheck object to compare with.
     * @return True if both objects have the same value for the employeeID, periodBeginDate, 
     * and periodEndDate instance variables. False otherwise.
     */
    @Override
    public boolean equals(Object obj) 
    {
        // check that the type of the parameter is Paycheck
        if( !(obj instanceof Paycheck) )
            return false;
        
        // we already know that obj is of type Paycheck, so it's safe to cast
        Paycheck paycheck = (Paycheck) obj;
        
        // return true or false depending on whether employeeID, periodBeginDate, and periodEndDate have the same value
        return paycheck.employeeID == this.employeeID && paycheck.periodBeginDate.equals(this.periodBeginDate) && paycheck.periodEndDate.equals(this.periodEndDate);
    }

    
    /**
     * The copy method creates a new Paycheck object and initializes it with the same data in the 
     * calling object.
     * @return a reference to the new object.
     */
    public Paycheck copy()
    {
        return new Paycheck(this);
    }

    
    /**
     * The compareTo method compares the Paycheck object calling this method with the
     * Paycheck object passed as an argument to see which one has a greater value.
     * @param paycheck The Paycheck object to compare with.
     * @return 0 if both objects have the same value for the payDate instance variable. 
     * A positive number if the calling object has a greater value for the payDate instance variable.
     * A negative number if the calling object has a lesser value for the payDate instance variable.
     */
    //@Override
    public int compareTo(Paycheck paycheck)
    {
        return this.payDate.compareTo(paycheck.payDate);
    }
}
