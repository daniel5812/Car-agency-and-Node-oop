package node;
//Assignment:5
//Author:Daniel Dahan , ID:318840196
public class DoublyLinkedList<T> implements List {
    /**
     Represents a doubly linked list data structure.
     @param <T> the type of elements stored in the linked list
     */
    private Node<T> head;
    private Node<T> tail;
    private int size;
    /**
     Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     Checks if the linked list is empty.
     @return true if the linked list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size==0)
            return true;

        return false;
    }
    /**
     Returns the number of elements in the linked list.
     @return the size of the linked list
     */
    @Override
    public int size() {
        return size;
    }
    /**
     Adds an element to the beginning of the linked list.
     @param data the data to be added
     */
    @Override
    public void addFirst(Object data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()){
            head=newNode;
            tail=newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head=newNode;
        }
        size++;

    }
    /**
     Adds an element to the end of the linked list.
     @param data the data to be added
     */
    @Override
    public void addLast(Object data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        }else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        }
    /**
     Removes the first occurrence of the specified data from the linked list.
     @param data the data to be removed
     @return the removed data, or null if the data was not found
     */
    @Override
    public Object remove(Object data) {
        if (head == null)
            return null;

        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.previous = null;
                } else {
                    current.previous.next = current.next;
                    if (current.next != null)
                        current.next.previous = current.previous;
                }
                return current.data;
            }
            current = current.next;
        }

        size--;
        System.out.println("Item was not found");
        return null;
    }

    /**
     Clears the linked list by removing all elements.
     */
    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null){
            current.data=null;
            current=current.next;
            size--;
        }
    }
    /**
     Checks if the linked list contains the specified data.
     @param data the data to be checked
     @return true if the linked list contains the data, false otherwise
     */
    @Override
    public boolean contains(Object data) {
        Node<T> current = head;

        if (isEmpty())
            return false;

        while (current != null) {
            if (current.data.equals(data))
                return true;
            else current=current.next;
        }
        return false;
    }
    /**
     Prints the elements of the linked list in forward order.
     */
    @Override
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    /**
     Prints the elements of the linked list in backward order.
     */
    @Override
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.previous;
        }
    }



    }

