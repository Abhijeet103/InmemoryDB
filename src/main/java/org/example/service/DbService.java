package org.example.service;

import org.example.entity.Entry;
import org.example.exception.InvalidKeyException;

import java.util.HashMap;

public class DbService<T>  implements IDbservice{
    private HashMap<Integer , Entry<T>> data ;
    public DbService() {

        data = new HashMap<>();
    }


    @Override
    public void put(Integer key, Object data , long ttl) {
        Entry<T> ob = new Entry<>((T)data , ttl)  ;
        this.data.put(key , ob) ;
    }

    @Override
    public T get(Integer key) {
        if(data.containsKey(key)){
           return (T) data.get(key).data ;
        }
        else {
            throw new InvalidKeyException("Key not found");
        }
    }

    @Override
    public void delete(Integer key) {
        if(data.containsKey(key)){
            data.remove(key) ;
        }
        else {
            throw new InvalidKeyException("Key not found");
        }
    }
}
