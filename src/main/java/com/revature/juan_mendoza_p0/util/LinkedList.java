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
     * This method returns and removes the data held in head or null.
     * @return
     */
    @Override
    public T get(){//might become pop method later for normalizing naming convention.
        //check if it is null first of all, if so done!
        if(head == null){
            return null;
        }


        T wantedData = head.data;
        head = head.nextNode;
        //now since we removed head, its null now so we must first check
        //if it is null to be able to be able to reassign previous node
        //else null pointer exception is throw trying to access (null).prevNode.
        if(head!=null){
            head.prevNode = null;
        }else{
            tail = null;
        }

        size--;
        return wantedData;

    }

    @Override
    public void add(T data) {
        if (data == null){
            throw new IllegalArgumentException("Null values can not be accepted!");
        }
        Node<T> newNode = new Node<T>(data);
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
