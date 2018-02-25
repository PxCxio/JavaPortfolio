package payrollsystem_phase3;

import java.io.Serializable;

/**
 * The Company class represents a company having multiple departments.
 * 
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class Company implements Serializable
{
    // instance variables
    private String companyName;
    private DepartmentLinkedList listOfDepartments = new DepartmentLinkedList();
        
    
    /** 
     * This constructor sets the company's name and list of departments. 
     * @param name        Company's name.
     * @param departments List of departments in the company.
     */
    public Company(String name, DepartmentLinkedList departments)
    {
        companyName = name;
        
        if(departments != null)
        {
           for (int i = 0; i < listOfDepartments.size(); i++)
           {
               listOfDepartments = departments.copy();
           }
        }
    }

    /**
     * The getCompanyName method returns the company's name.
     * @return The company's name.
     */
    public String getCompanyName()
    {
        return companyName;
    }
    

    /**
     * The getDepartmentList method returns the company's list of departments.
     * @return The company's list of departments as an ArrayList of Department elements.
     */
    public DepartmentLinkedList getListOfDepartments() 
    {
        return listOfDepartments;
    }


    
    /**
     * The setCompanyName method sets the name for this company.
     * @param name The value to store in the name field for this company.
     */
    public void setCompanyName(String name)
    {
        companyName = name;
    }

    
    /**
     * The setDepartmentList method sets the list of departments for this company.
     * @param departments The value, as an ArrayList of Department elements, to store 
     * in the list of departments field for this company.
     */
    public void setDepartmentList(DepartmentLinkedList departments)
    {
        listOfDepartments = departments;
    }
    
    /** 
     * The toString method returns a string containing the company's data.
     * @return A reference to a String containing the state of the calling object.
     */
    @Override
    public String toString() 
    {
        //company and departments
        String output = String.format("%-27s%s\n", "Company Name:", companyName);
        output += String.format("%-27s\n", "Departments:");

        //loop through departments
        for (int i = 0; i < listOfDepartments.size(); i++) 
        {
            //get department
            Department department = listOfDepartments.getDepartment(i);
            //add department to string
            output += String.format("%-27s\n", department);
        }

        return output;
    }
    
    /** 
     * The addDepartment method adds a department to the list of departments in the company.
     * @param dept The Department object to be added to the list.
     */
    public void addDepartment(Department dept)
    {       
        listOfDepartments.add(new Department(dept));
    }
    
    /**
     * The addEmployeeToDepartment method iterates through the listOfDepartments ArrayList looking
     * for a Department whose departmentID is equal to the int value passed as the first argument.
     * If it finds it, it adds the Employee object passed as the second argument.
     * @param deptID the departmentID to search for in the list.
     * @param empObject the Employee object to be added to the department.
    */
    public void addEmployeeToDepartment (int deptID, Employee empObject)
    {
        
        for (int i = 0; i < listOfDepartments.size(); i++) 
        {
            Department dept = null;
            if (dept.getDepartmentID() == deptID) 
            {
                dept.addEmployee(empObject);
                return;
            }
            

        }
    }
    
    /**
     * The setDepartmentManager method iterates through the listOfDepartments ArrayList looking
     * for a Department whose departmentID is equal to the int value passed as the first argument.
     * If it finds it, it sets its manager to be the value passed as the second argument.
     * @param deptID the departmentID to search for in the list.
     * @param manObject the Manager object used to set the department's manager.
    */
    public void setDepartmentManager(int deptID, Manager manObject)
    {
       Department dept = null;
        for (int i = 0; i < listOfDepartments.size(); i++)
        {
            if (dept.getDepartmentID() == deptID)
            {
                dept.addEmployee(manObject);
                return;
            }
        }
    }
}
