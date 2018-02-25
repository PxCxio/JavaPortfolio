package payrollsystem_phase3;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class PayrollSystem_Phase3 
{
    // this is the Company object to be populated as the data file is processed
    private static Company company;
    
    public static void main(String[] args) 
    {
        // initialize the company object
        company = new Company("Our Company", null);
        
        String message;
        JFileChooser fileChooser = new JFileChooser(".");

        // Get the serialization file name from the program argument list; else use a default value.
        String serializationFileName;
        if( args.length > 0 ) 
            serializationFileName = args[0];
        else
            serializationFileName = "payrollData.ser";
        
        // Ask the user what they want to do.
        String options = "\t [1] to load serialized data\n"
                + "\t [2] to load a new data file\n"
                + "\t [3] to add a new department\n"
                + "\t [4] to add a new hourly employee\n"
                + "\t [5] to add a new salaried employee\n"
                + "\t [6] to add a new manager\n"
                + "\t [7] to search for an employee\n"
                + "\t [8] to display company information\n"
                + "\t [q] to quit the application";
        
        String menuMessage = "Please enter one of the following options:\n" + options;
        String userInput = JOptionPane.showInputDialog(null, menuMessage, "Payroll System", JOptionPane.QUESTION_MESSAGE);
        
        while (userInput != null && !userInput.equalsIgnoreCase("q")) 
        {
            switch (userInput) 
            {
                case "1":
                    System.out.println("Deserializing Company object");
                            
                    // try to set the company object with values read from the serialization file.
                    Object companyObject = PayrollUtility.deSerializeObject(serializationFileName);
        
                    if( companyObject != null && companyObject instanceof Company )
                        company = (Company)companyObject; 

                    break;
                    
                case "2":
                    System.out.println("Loading new data file");
                    
                    // Prompt the user to select an input data file
                    File selectedFile;
                   
                    if( fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) 
                    {
                        selectedFile = fileChooser.getSelectedFile();
                        
                        // try with resources. The inputFile Scanner object will be closed automatically.
                        try (Scanner inputFile = new Scanner(selectedFile)) 
                        {
                            // read all lines of data from the file and process them
                            String line;
                            int lineNumber = 1;
                            while (inputFile.hasNext()) 
                            {
                                line = inputFile.nextLine();
                                try
                                {   
                                    processLineOfData(line);
                                }
                                catch(Exception ex)
                                {
                                    message = "The following error occurred while processing line number " 
                                                     + lineNumber + ": " + ex.getMessage()
                                                     + "\nLine of data skipped: " + line;

                                    System.out.println( message );
                                    ex.printStackTrace();
                                }
                                lineNumber++;
                            }
                        } 
                        catch (FileNotFoundException e) 
                        {
                           System.out.println(e.toString());
                        }
                        System.out.println("Done loading data.");
                    }     
                    break;
                    
                case "3":
                    promptUserForData("D");
                    break;
                    
                case "4":
                    promptUserForData("H");
                    break;
                    
                case "5":
                    promptUserForData("S");                   
                    break;
                    
                case "6":
                    promptUserForData("M");
                    break;
                    
                case "7":
                    message = "Enter last name of employee to search for";
                    String empLastName = JOptionPane.showInputDialog(null, message, "Employee Last Name", JOptionPane.INFORMATION_MESSAGE);
                    DepartmentLinkedList deptList = company.getListOfDepartments();
                    
                    int i = 0;
                    boolean found = false;
                    Department dept;
                    ArrayList<Employee> deptEmployees;
                    
                    while( i < deptList.size() && !found )
                    {
                        dept = deptList.getDepartment(i);
                        deptEmployees = dept.getListOfEmployees();
                        //PayrollUtility.sortArrayList(deptEmployees);
                        
                        int empIndex = PayrollUtility.search(deptEmployees, empLastName);
                        if( empIndex == -1 )
                            System.out.println("No employee found with that last name.");
                        else
                        {
                            System.out.println( "Employee found in department " + dept.getDepartmentName() + 
                                                " " + deptEmployees.get(empIndex));
                            break;
                        }
                        i++;
                    }  
                    break;
                    
                case "8":
                    System.out.println(company);                                   
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid entry. Please try again.", 
                            "Invalid entry", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            userInput = JOptionPane.showInputDialog(menuMessage);
        }    
        
        JOptionPane.showMessageDialog(null, "Quitting application.");
        PayrollUtility.serializeObject(company, serializationFileName);
        System.exit(0);
    }
    
    
    /**
     * The parseEmployeePaychecks method parses the String passed as an argument and returns 
     * an ArrayList of Paycheck objects.
     * @param paycheckList A String value that represents the list of paychecks an employee has 
     * received separated by the # sign; paycheck fields are separated by the : character.
     * The following is the format for each paycheck:
     * employeeID:periodBeginDate:periodEndDate:payDate:grossAmount:taxAmount:bonusAmount:netAmount
     * @return An equivalent ArrayList of Paycheck objects.
     */
    public static ArrayList<Paycheck> parseEmployeePaychecks(String paycheckList)
    {
        // 1- declare an ArrayList of Paycheck elements and initialize to an empty list.
        ArrayList<Paycheck> employeePaychecks = new ArrayList<>();
        
        // 2- split the paycheckList parameter on the # to get each paycheck information.
        String[] arrayOfPaycheckStrings = paycheckList.split("#");
        
        // Variable declarations
        String[] paycheckFields;
        Paycheck paycheck;
        int empID;
        String beginDate,endDate, payDt;
        double grossAmt, taxAmt, bonusAmt, netAmt;
        
        // 3- iterate through the list of paychecks, where each paycheck should have the following format: 
        //    employeeID:periodBeginDate:periodEndDate:payDate:grossAmount:taxAmount:bonusAmount:netAmount
        for (String paycheckString : arrayOfPaycheckStrings) 
        {
            paycheckFields = paycheckString.split(":");
            
            // 4- Use all this information to create a Paycheck object.
            empID     = Integer.parseInt(paycheckFields[0]);
            beginDate = paycheckFields[1];
            endDate   = paycheckFields[2];
            payDt     = paycheckFields[3];
            grossAmt  = Double.parseDouble(paycheckFields[4]);
            taxAmt    = Double.parseDouble(paycheckFields[5]);
            bonusAmt  = Double.parseDouble(paycheckFields[6]);
            netAmt    = Double.parseDouble(paycheckFields[7]);
    
            paycheck = new Paycheck(    empID, beginDate, endDate, payDt, grossAmt, taxAmt, 
                                        bonusAmt, netAmt);
            
            // Could also do it without using variables as shown below
            /* paycheck = new Paycheck(  Integer.parseInt(paycheckFields[0]), 
                                        paycheckFields[1], 
                                        paycheckFields[2], 
                                        paycheckFields[3], 
                                        Double.parseDouble(paycheckFields[4]), 
                                        Double.parseDouble(paycheckFields[5]), 
                                        Double.parseDouble(paycheckFields[6]), 
                                        Double.parseDouble(paycheckFields[7])); */
        
            // 5- Add it to the array list of Paycheck objects that this method returns.
            employeePaychecks.add(paycheck);
        }
        
        // 6- Return the list of Paycheck objects.
        return employeePaychecks;
    }
    
    
    
    /** 
     * The processLineOfData method parses the String passed as an argument, which represents 
     * one line of data with information for a Department, HourlyEmployee, SalariedEmployee, or 
     * Manager, and creates the corresponding object.
     * When processing a line of data for a department, the created Department object gets added
     * to the companyDepartments list. When processing data for an hourly or salaried employee,
     * the corresponding HourlyEmployee or SalariedEmployee object gets added to the appropriate
     * department object in the companyDepartments list. When processing a line of data for a
     * manager, the created Manager object gets used to set the manager of the appropriate department 
     * object in the companyDepartments list. 
     * @param line The line of data to be parsed separated by commas.
     * @throws Exception when the type of the data (given by the first data field) is not [D]epartment, 
     * [S]alariedEmployee, [H]ourlyEmployee, or [M]anager.
     */
    public static void processLineOfData(String line) throws Exception
    {
        // Split the line parameter on the comma. 
        String[] lineElements = line.split(",");
        
        // Get the first field to determine the record type:
        // D -> Department
        // S -> SalariedEmployee
        // H -> HourlyEmployee
        // M -> Manager
        String recordType = lineElements[0];
               
        // Variable declarations
        ArrayList<Paycheck> paychecks;
        
        switch (recordType) 
        {
            case "D":
                
                // If the line has Department data, get the department id, department name 
                // and create a Department object.
                Department dept = new Department(   Integer.parseInt(lineElements[1]), 
                                                    lineElements[2], null, null);
                
                // Add the new Department object to the company's listOfDepartments.
                company.addDepartment(dept);                
                break;
                
            case "H":
                
                // If the line has HourlyEmployee data, call the parseEmployeePaychecks method  
                // passing the portion of the line that has the list of paychecks.
                paychecks = parseEmployeePaychecks( lineElements[8] );
                
                // Create a new HourlyEmployee object with the returned ArrayList of Paychecks along  
                // with the employee data from the line.    
                HourlyEmployee hrEmp = new HourlyEmployee(  Integer.parseInt(lineElements[1]), 
                                                            lineElements[2],
                                                            lineElements[3], 
                                                            lineElements[4], 
                                                            paychecks, 
                                                            Double.parseDouble(lineElements[5]), 
                                                            Double.parseDouble(lineElements[6]));
               
                // Get the department id to which the Employee needs to be added from the data line.
                company.addEmployeeToDepartment(Integer.parseInt(lineElements[7]), hrEmp);
                
                break;
                
            case "S":
                // If the line has SalariedEmployee data, call the parseEmployeePaychecks method  
                // passing the portion of the line that has the list of paychecks.
                paychecks = parseEmployeePaychecks( lineElements[7] );
                
                // Create a new SalariedEmployee object with the returned ArrayList of Paychecks  
                // along with the employee data from the line.
                SalariedEmployee salEmp = new SalariedEmployee( Integer.parseInt(lineElements[1]), 
                                                                lineElements[2],
                                                                lineElements[3], 
                                                                lineElements[4], 
                                                                paychecks, 
                                                                Double.parseDouble(lineElements[5]));
                
                // Get the department id to which the Employee needs to be added from the data line.
                company.addEmployeeToDepartment(Integer.parseInt(lineElements[6]), salEmp);
                
                break;
                
            case "M":
                // If the line has Manager data, call the parseEmployeePaychecks method passing 
                // the portion of the line that has the list of paychecks.
                paychecks = parseEmployeePaychecks( lineElements[8] );
                
                // Create a new Manager object with the returned ArrayList of Paychecks along with 
                // the manager data from the line.
                Manager manager = new Manager(  Integer.parseInt(lineElements[1]), 
                                                lineElements[2],
                                                lineElements[3], 
                                                lineElements[4], 
                                                paychecks, 
                                                Double.parseDouble(lineElements[5]),
                                                Double.parseDouble(lineElements[6]));
                
                // Get the department id from the data line for which the Manager needs to be set.
                company.setDepartmentManager(Integer.parseInt(lineElements[7]), manager);
                break;
                
            default:
                throw new Exception("Bad record");
        }   
        
    }
    
    private static void promptUserForData(String dataType)
    {
        String dialogMessage, dialogTitle;

        switch (dataType)
        {
            case "D":
                
                dialogMessage   = "Enter department information in this format: dept id,dept name";
                dialogTitle     = "Department Information";
                break;
                
            case "H":
                
                dialogMessage   = "Enter hourly employee information in this format: employee id,first name,\n"
                                + "last name,date of birth,hire date,ytd,hourly rate,pay period hours,department id,\n"
                                + "department name,list of paychecks";
                dialogTitle     = "Hourly Employee Information";
                break;
                
            case "S":
                
                dialogMessage   = "Enter salaried employee information in this format: employee id,first name,\n"
                                + "last name,date of birth,hire date,vacation hrs,ytd,salary,department id,\n"
                                + "department name,list of paychecks";
                dialogTitle     = "Salaried Employee Information";
                break;
                
            case "M":
                
                dialogMessage   = "Enter manager information in this format: employee id,first name,last name,\n"
                                + "date of birth,hire date,vacation hrs,ytd,salary,bonus,department id,\n"
                                + "department name,list of paychecks";
                dialogTitle     = "Manager Information";
                break;
                
            default:
                return;
        }

        String userInput = JOptionPane.showInputDialog(null, dialogMessage, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        try
        {
            processLineOfData(dataType + "," + userInput);
        } 
        catch (Exception ex)
        {
            String errorMessage = "The following error occurred while processing the ";
            errorMessage += dialogTitle.toLowerCase() + "you entered: ";

            System.out.println(errorMessage + ex.getMessage());
        }
    }
    
}