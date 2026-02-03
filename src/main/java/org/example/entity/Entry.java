package org.example.entity;

public class Entry<T>{
    public T data ;
    public long ttl ;
    public Entry(T data, long ttl) {
        this.data = data ;
        this.ttl = ttl ;
    }

    public Entry(T data) {
        this.data = data ;
        this.ttl = -1 ;
    }
}
