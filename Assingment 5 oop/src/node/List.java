package node;
//Assignment:5
//Author:Daniel Dahan , ID:318840196
/**
 The List interface represents a collection of elements in a specific order.
 It provides operations to add, remove, and access elements in the list.
 @param <T> the type of elements in the list
 */
public interface List<T> {
     /**
      Checks if the list is empty.
      @return true if the list is empty, false otherwise
      */
     boolean isEmpty();
     /**
      Returns the number of elements in the list.
      @return the size of the list
      */
     int size();
     /**
      Adds an element to the beginning of the list.
      @param data the element to be added
      */
     void addFirst(T data);
     /**
      Adds an element to the end of the list.
      @param data the element to be added
      */
     void addLast(T data);
     /**
      Removes the first occurrence of the specified element from the list.
      @param data the element to be removed
      @return the removed element, or null if the element was not found
      */
     T remove(T data);
     /**
      Clears the list by removing all elements.
      */
     void clear();
     /**
      Checks if the list contains the specified element.
      @param data the element to be checked
      @return true if the list contains the element, false otherwise
      */
     boolean contains(T data);
     /**
      Prints the elements of the list in forward order.
      */
     void printForward();
     /**
      Prints the elements of the list in backward order.
      */
     void printBackward();
}