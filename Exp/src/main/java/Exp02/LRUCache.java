package Exp02;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public HashMap<Integer,Node> hashMap;
    public DoubleLinkList cache;
    public int cap;

    public LRUCache(int capacity){
        hashMap = new HashMap<Integer, Node>();
        cache = new DoubleLinkList();
        this.cap = capacity;
    }
    // 将某个key提升为最近访问
    private void makeRecently(int key){
        Node node = hashMap.get(key);
        cache.remove(node);
        cache.addFirst(node);
    }
    // 添加最近使用元素
    private void addRecently(int key,int counter,int recency){
        Node newNode = new Node(key, counter, recency);
        cache.addFirst(newNode);
        hashMap.put(key,newNode);
    }

    // 删除某一个key
    private void deleteKey(int key){
        Node node = hashMap.get(key);
        cache.remove(node);
        hashMap.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently(){
        // 链表最后一个就是最久未使用的
        Node node = cache.removeLast();
        hashMap.remove(node.key);
    }

    public int getCounter(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return hashMap.get(key).counter;
    }

    public int getRecency(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return hashMap.get(key).recency;
    }

    public void put(int key,int counter,int recency){
        if (hashMap.containsKey(key)){
            deleteKey(key);
            addRecently(key, counter, recency);
            return;
        }
        if (cap==cache.size()){
            removeLeastRecently();
        }
        addRecently(key, counter, recency);
    }

}

