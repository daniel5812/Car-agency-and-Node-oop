package node;
public class Node<T> {
    //Assignment:5
//Author:Daniel Dahan , ID:318840196
    /**

     The Node class represents a node in a doubly linked list.

     It holds a reference to data, as well as references to the previous and next nodes in the list.

     @param <T> the type of data held by the node
     */
        protected T data;
        protected Node<T> previous;
        protected Node<T> next;

        /**

         Constructs a new node with the specified data.
         @param data the data to be stored in the node
         */
        public Node(T data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
        /**

         Constructs a new node with the specified data, previous node, and next node.
         @param data the data to be stored in the node
         @param previous the previous node in the list
         @param next the next node in the list
         */
        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
        /**

         Returns the data stored in the node.
         @return the data of the node
         */
        public T getData() {
            return data;
        }
        /**

         Sets the data of the node to the specified value.
         @param data the new data value
         */
        public void setData(T data) {
            this.data = data;
        }
        /**

         Returns the previous node in the list.
         @return the previous node
         */
        public Node<T> getPrevious() {
            return previous;
        }
        /**

         Sets the previous node of the current node to the specified node.
         @param previous the new previous node
         */
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
        /**

         Returns the next node in the list.
         @return the next node
         */
        public Node<T> getNext() {
            return next;
        }
        /**

         Sets the next node of the current node to the specified node.
         @param next the new next node
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }