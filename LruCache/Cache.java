public interface Cache<K, V> {

    void addToCache(K key, V value);
    V getValue(K key);

}
