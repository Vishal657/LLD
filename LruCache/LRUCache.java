import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {

    DoublyLinkedList<K, V> ddl = new DoublyLinkedList<K, V>();
    Map<K, DdlNode<K, V>> hm;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    @Override
    public void addToCache(K key, V value) {
        DdlNode<K, V> reqNode = hm.get(key);
        if (reqNode != null) {
            ddl.remove(reqNode);
            ddl.addFirst(reqNode);
            reqNode.value = value;
            // here we are handling duplicate keys, so consider that LRU,  already
            // contains a key and value of 2 and 2 respectively. So when request of adding
            // new element with key as 2 but value as 1 arrives then it will update the
            // existing key with value of 1
            hm.put(key, reqNode);
            return;
        }
        reqNode = new DdlNode<K, V>(key, value);
        if (hm.size() == capacity) {
            DdlNode<K, V> removedNode = ddl.removeLast();
            hm.remove(removedNode.key);
        }
        hm.put(key, reqNode);
        ddl.addFirst(reqNode);
    }

    @Override
    public V getValue(K key) {
        DdlNode<K, V> reqNode = hm.get(key);
        if (reqNode == null) {
            return null;
        }
        ddl.remove(reqNode);
        ddl.addFirst(reqNode);
        return reqNode.value;
    }
}
