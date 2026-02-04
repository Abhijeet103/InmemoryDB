package org.example.service;

import org.example.entity.Entry;
import org.example.exception.DbUnavaiableException;
import org.example.exception.InvalidKeyException;

import java.util.HashMap;

public class DbService  implements IDbservice{
    private final HashMap<Integer , Entry<Object>> data ;
    volatile private boolean state  ;


    public DbService() {

        data = new HashMap<>();
        state = true;
    }


    @Override
    synchronized public void put(Integer key, Object data , long ttl) {

        if(!state){
            throw new DbUnavaiableException("Unable to connect to Db") ;
        }

        Entry<Object> ob = new Entry<>(data , ttl)  ;
        this.data.put(key , ob) ;
    }

    @Override
    synchronized public  void put(Integer key, Object data) {

        Entry<Object> ob = new Entry<>(data)  ;
        this.data.put(key , ob) ;
    }


    // Lazy delete
    @Override
    synchronized public  Object get(Integer key) {

        if(data.containsKey(key)){
            if(data.get(key).isExpired()){
                data.remove(key)  ;
                throw new InvalidKeyException("Key not found or expired");
            }
           return data.get(key).data ;
        }
        else {
            throw new InvalidKeyException("Key not found");
        }
    }

    @Override
    synchronized public  void delete(Integer key) {
        if(data.containsKey(key)){
            data.remove(key) ;
        }
        else {
            throw new InvalidKeyException("Key not found");
        }
    }

    public void setState(boolean state){
        this.state = state ;
    }


}
