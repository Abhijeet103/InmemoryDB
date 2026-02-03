package org.example.service;

import org.example.entity.Entry;

import java.util.HashMap;

public class DbService<T>  implements IDbservice{
    private HashMap<Integer , Entry<T>> data ;
    public DbService() {

    }


    @Override
    public void put(Integer key, Object data) {

    }

    @Override
    public Object get(Integer key) {
        return null;
    }

    @Override
    public void delete(Integer key) {

    }
}
