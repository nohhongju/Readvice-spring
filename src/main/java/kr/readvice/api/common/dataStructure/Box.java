package kr.readvice.api.common.dataStructure;

import kr.readvice.api.auth.domains.User;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component @Data @Lazy
public class Box<K, V> {
    private HashMap<K, V> map;
    //save, update, delete, findAll, findById, count, existById
    //put, replace, remove, values(), get(i), size, containKey(i)
    public Box(){ this.map = new HashMap<>();}

    public void put(K k, V v){ map.put(k, v);}
    public void replace(K k, V v){ map.replace(k, v);}
    public void remove(K k, V v){ map.remove(k, v);}
    public List<V> values(){ return new ArrayList<>(map.values());}
    public V get(K id){ return map.get(id);}
    public int size(){ return map.size();}
    public boolean containsKey(K k){ return map.containsKey(k);}
    // 테이블 행목록요청시
    public List<V> findAllList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V)e.getValue());
        }
        return ls;
    }
    // 테이블 키값 목록요청시
    public List<V> findAllKeyList() {
        List<V> ls = new ArrayList<>();
        for (Map.Entry<K, V> e: map.entrySet()) {
            ls.add((V)e.getValue());
        }
        return ls;
    }
    // 이름으로 검색된 회원 목록요청시(필터가 필요없이 리액트로 던지는 경우)
    public List<User> findByUserName(String name) {
        List<User> ls = new ArrayList<>();
        for (User v : ls) {  if (name.equals(v.getName())) ls.add(v); }
        return ls;
    }
    // 이름으로 검색된 회원 목록요청시(추가 필터를 통해 더 줄어든 결과값이 필요한 경우)
    public Map<String, User> mapFindByUserName(String name){
        Map<String, User> map = new HashMap<>();
        for (Map.Entry<String, User> e : map.entrySet()) {
            if (name.equals(e.getValue().getName())) map.put(e.getKey(), e.getValue());
        }
        return map;
    }
}

