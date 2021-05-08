package com.revature.juan_mendoza_p0.util;

//must implement methods we must implement interface methods, which come from Collection
// List interface implements Collection interface
public class LinkedList<T> implements List<T>,Queue<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean contains(T data) {
        return false;
    }

    /**
     * This method returns the data at specified index.
     * @return      Data
     */
    @Override
    public T get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("You have provided index index out of bounds");
        }
        Node<T> cursor = head;

        for(int i = 0; i<size; i++){
            if(i == index){
                return cursor.data;
            }
            //if cursor isn't on right index, just move onto next node
            cursor = cursor.nextNode;
        }
        //java wants something
        return null;
    }

    @Override
    public void add(T data) {
        //lets first check if data is null
        if (data == null){
            throw new IllegalArgumentException("Null values can not be accepted!");
        }

        //make our data Node type
        Node<T> newNode = new Node<T>(data);

        //if this is the first thing or empty list, then we need to make sure head is not null
        //if not null, proceed with logic and rerouting connections.
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T remove(T data) {
        return null;
    }

    /**Method for removing the front most data in the list.
     *
     * @return   the head of the LinkedList
     */
    @Override
    public T poll() {
        //check head is null, if so done!
        if(head == null){
            return null;
        }

        //head is removed
        T wantedData = head.data;
        head = head.nextNode;
        //Head of LinkedList is null, if we try to access "head.prevNode" get
        //null pointer exception.
        if(head!=null){
            head.prevNode = null;
        }else{
            tail = null;
        }

        size--;
        return wantedData;
    }

    @Override
    public T peek() {
        return null;
    }

    //since we only use Node class in this LinkedList class,then we should just declared the class here.
    //  -- additionally, we declare it private so only LinkedList may access it.
    // --Nested Type
    private static class Node<T>{
        T data;
        Node<T> nextNode;
        Node<T> prevNode;

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> nextNode, Node<T> prevNode){
            this.data = data;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
    }

}
