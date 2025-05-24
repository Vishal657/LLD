public class DdlNode<K, V> {

    DdlNode<K, V> right;
    DdlNode<K, V> left;

    K key;
    V value;

    DdlNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
