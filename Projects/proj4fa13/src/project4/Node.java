package project4;

/**
 * Title: Node.java
 * Description: Defines a node class capable of storing a reference to an object and a reference to the next node in a
 * linked list. Accessors and mutators are defined for both.
 *
 * @author Marvin
 */
public class Node<Person>
{
    private Person data;
    private Node<Person> next;

    /** default constructor - Initializes data and next to null */
    public Node()
    {
        data = null;
        next = null;
    }

    /**
     * parameterized constructor - Initializes data to the specified Person reference; next is set to null.
     *
     * @param newPerson the Person reference to be stored in the node
     */
    public Node(Person newPerson)
    {
        data = newPerson;
        next = null;
    }

    /**
     * parameterized constructor - Initializes data and next to specified values.
     *
     * @param newPerson the Person reference to be stored in the node
     * @param nextNode  the reference to the next node in the list
     */
    public Node(Person newPerson, Node<Person> nextNode)
    {
        data = newPerson;
        next = nextNode;
    }

    /**
     * setPerson - Stores a new Person reference in data.
     *
     * @param newPerson the Person reference to be stored in the node
     */
    public void setPerson(Person newPerson)
    {
        data = newPerson;
    }

    /**
     * setNext - Stores a new Node reference in next.
     *
     * @param nextNode the Node reference to be stored in next
     */
    public void setNext(Node<Person> nextNode)
    {
        next = nextNode;
    }

    /**
     * getPerson - Returns the Person reference stored in data.
     *
     * @return a reference to the data stored in the node
     */
    public Person getPerson()
    {
        return data;
    }

    /**
     * getNext - Returns the Node reference stored in next.
     *
     * @return the Node reference stored in next
     */
    public Node<Person> getNext()
    {
        return next;
    }
}
