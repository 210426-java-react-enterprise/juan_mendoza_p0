package com.revature.juan_mendoza_p0.util;

/**
 * Personal version interface of Queue to implement
 * desired methods
 * @param <T>   generic - for any data type
 */
public interface Queue <T> extends Collection<T>{
    T poll();
    T peek();
}
