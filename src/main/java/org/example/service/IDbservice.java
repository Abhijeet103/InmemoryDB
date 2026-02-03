package org.example.service;

public interface IDbservice<T> {

    void put(Integer key , T data ) ;
    T get(Integer key) ;
    void delete(Integer key) ;

}
