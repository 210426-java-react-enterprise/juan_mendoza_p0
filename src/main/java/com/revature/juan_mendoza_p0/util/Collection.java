package com.revature.juan_mendoza_p0.util;


/**
 * Personal version interface of Collection to implement
 * desired methods
 * @param <T>   generic - for any data type
 */
public interface Collection <T>{
    int size();
    boolean contains(T data);
    void add(T data);
    T remove(T data);

}
