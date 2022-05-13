package kr.readvice.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component @Data @Lazy
public class Vector<T> {
    private ArrayList<T> list;
    //save, update, delete, findAll, findById, count, existById, clear
    //add, set, remove, get(), X, get(i), size, X, clear
    public Vector(){this.list = new ArrayList<>();}

    public void add(T t){list.add(t);}
    public void set(int i,T t){list.set(i, t);}
    public void remove(T t){list.remove(t);}
    public List<T> get(){return list;}
    public T get(int i){return list.get(i);}
    public int size(){return list.size();}
    public boolean existById(T t){return list.equals(t);}
    public void clear(){list.clear();}
}
