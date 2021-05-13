package com.revature.juan_mendoza_p0.util;


/**
 * Personal version interface of List to implement
 * desired methods
 * @param <T>   generic - for any data type
 */
public interface List<T> extends Collection<T> {
    T get(int index);

}
