/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem_phase3;

import java.io.Serializable;

/**
 *
 * @author Yasuan Quintero, Ciro, Khassy
 */
public class DepartmentLinkedList implements Serializable 
{
    private Node head;
    
    /**
     * The Node class stores a list element and a reference to the next node.
     */
    private class Node implements Serializable
    {

        Department department;
        Node next;

        /**
         * Constructor.
         *
         * @param dept The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(Department dept, Node n)
        {
            department = dept;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param dept The element to store in the node.
         */
        Node(Department dept)
        {
            // Call the other (sister) constructor.
            this(dept, null);
        }
         
        /**
         * Get department
         *
         * @return department
         */
        public Department getDepartment() 
        {
            return department;
        }
        
        /**
         * Get next node
         *
         * @return node
         */
        public Node getNext() 
        {
            return next;
        }
       
    }

    private Node first;  // list head
    private Node last;   // last element in list

    /**
     * Constructor.
     */
    public DepartmentLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size()
    {
        int count = 0;
        Node p = first;
        while (p != null)
        {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds an element to the end of the list.
     *
     * @param e The value to add to the end of the list.
     */
    public void add(Department e)
    {
        if (isEmpty())
        {
            first = new Node(e);
            last = first;
        } 
        else
        {
            // Add to end of existing list
            last.next = new Node(e);
            last = last.next;
        }
    }

    /**
     * The add method adds an element at a position.
     *
     * @param e The element to add to the list.
     * @param index The position at which to add the element.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public void add(int index, Department e)
    {
        if (index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if (index == 0)
        {
            // New element goes at beginning
            first = new Node(e, first);
            if (last == null)
            {
                last = first;
            }
            return;
        }

        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        Node pred = first;
        for (int k = 1; k <= index - 1; k++)
        {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(e, pred.next);

        // Is there a new last element ?
        if (pred.next.next == null)
        {
            last = pred.next;
        }
    }

    /**
     * The toString method computes the string representation of the list.
     *
     * @return The string form of the list.
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = first;
        while (p != null)
        {
            strBuilder.append(p.department + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }

    /**
     * The remove method removes the element at an index.
     *
     * @param index The index of the element to remove.
     * @return The element removed.
     * @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public Department remove(int index)
    {
        if (index < 0 || index >= size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Department element;  // The element to return     
        if (index == 0)
        {
            // Removal of first item in the list
            element = first.department;
            first = first.next;
            if (first == null)
            {
                last = null;
            }
        } 
        else
        {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index - 1; k++)
            {
                pred = pred.next;
            }

            // Store the value to return
            element = pred.next.department;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now last
            if (pred.next == null)
            {
                last = pred;
            }
        }
        return element;
    }

    /**
     * The remove method removes an element.
     *
     * @param element The element to remove.
     * @return true if the remove succeeded, false otherwise.
     */
    public boolean remove(String element)
    {
        if (isEmpty())
        {
            return false;
        }

        if (element.equals(first.department))
        {
            // Removal of first item in the list
            first = first.next;
            if (first == null)
            {
                last = null;
            }
            return true;
        }

        // Find the predecessor of the element to remove
        Node pred = first;
        while (pred.next != null && !pred.next.department.equals(element))
        {
            pred = pred.next;
        }

        // pred.next == null OR pred.next.value is element
        if (pred.next == null)
        {
            return false;
        }

        // pred.next.value  is element
        pred.next = pred.next.next;

        // Check if pred is now last
        if (pred.next == null)
        {
            last = pred;
        }

        return true;
    }
    
     /**
     * Find department
     *
     * @param dept department to find
     * @return department if found, null otherwise
     */
    public Department find(Department dept) 
    {
        Department result = null;
        //start at head
        Node current = head;

        //loop until end
        while (current != null) {
            //check for department equal
            if (current.getDepartment().equals(dept)) {
                //found a match
                result = current.getDepartment();
                break;
            }

            //advance to next
            current = current.getNext();
        }
        return result;
    }

    /**
     * Get department by index
     *
     * @param index index of department
     * @return department
     */
    public Department getDepartment(int index) {
        int curIndex = 0;

        Department result = null;
        //start at head
        Node current = head;

        //loop until end
        while (current != null) {
            //check for index match
            if (curIndex == index) {
                //found a match
                result = current.getDepartment();
                break;
            }

            //advance to next node
            current = current.getNext();
            //increment index
            curIndex++;
        }
        return result;
    }

    public DepartmentLinkedList copy() 
    {
        // create a new DepartmentLinkedList object
        DepartmentLinkedList deptNewList = new DepartmentLinkedList();
        
        //start at head
        Node currentNode = head;
        
        //loop until end
        while (currentNode != null) 
        {
            deptNewList.add(new Department(currentNode.getDepartment()));
            currentNode = currentNode.next;            
        }    

        // return the new linked list.
        return deptNewList;
    }

 }
