package payrollsystem_phase3;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class PayrollUtility
{
    /**
     * The sortArrayList method sorts in ascending order the elements in the ArrayList passed as an 
     * argument using the Bubble Sort algorithm.
     * @param <E> The elements in the ArrayList need to be of a class that implements the Comparable 
     * interface.
     * @param list The ArrayList to be sorted.
     */
    public static <E extends Comparable> void sortArrayList (ArrayList<E> list)
    {
        int lastPos;
        int index;
        E temp;

        for (lastPos = list.size() - 1; lastPos > 0; lastPos--) {
            for (index = 0; index <= lastPos - 1; index++) {
                if (list.get(index).compareTo(list.get(index + 1)) > 0) {
                    // swap elements
                    temp = list.get(index);
                    list.set(index,list.get(index + 1));
                    list.set(index + 1,temp);
                }
            }
        }
    }
    
    
    /**
     * Recursive binary search for employee
     *
     * @param list list to search
     * @param firstElem first element
     * @param lastElem last element
     * @param searchLastName search for name
     * @return index if found, -1 if not found
     */
    private static <E extends Employee> int binarySearch(ArrayList<E> list,
            int firstElem, int lastElem, String searchLastName) 
    {
        int index;
        //check if we have past the search bounds, not found
        if (firstElem > lastElem) 
        {
            //set not found
            index = -1;
        } else 
        {
            //get mid point
            int mid = (firstElem + lastElem) / 2;
            //get comparison
            int cmp = list.get(mid).getLastName().compareTo(searchLastName);

            //have a match
            if (cmp == 0) 
            {
                index = mid;
            } else if (cmp < 0) {
                //search from first half of list
                index = binarySearch(list, firstElem, mid - 1, searchLastName);
            } else 
            {
                //search from last half of list
                index = binarySearch(list, mid + 1, lastElem, searchLastName);
            }
        }
        return index;
    }
    
    
    /**
     * Searches employees for last name match
     *
     * @param list list to search
     * @param searchLastName last name to search for
     * @return index of employee, -1 if not found
     */
    public static <E extends Employee> int search(ArrayList<E> list, String searchLastName) 
    {
        return binarySearch(list, 0, list.size() - 1, searchLastName);
    }

    
    /**
     * Serializes object to file
     *
     * @param objectToSerialize object to serialize
     * @param serializationFileName save to filename
     */
    public static void serializeObject(Object objectToSerialize, String serializationFileName) 
    {
        try 
        {
            //open file as stream
            OutputStream file = new FileOutputStream(serializationFileName);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            //write object to file
            output.writeObject(objectToSerialize);
            //close file
            output.close();
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
 
    /**
     * Loads serialized object from file
     *
     * @param serializationFileName file to load from
     * @return deserialized object
     */
    public static Object deSerializeObject(String serializationFileName) 
    {
        Object object = null;

        try 
        {
            //open file
            InputStream file = new FileInputStream(serializationFileName);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            //read object from file
            object = input.readObject();
            //close file
            input.close();
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        return object;
    }    

}  
  