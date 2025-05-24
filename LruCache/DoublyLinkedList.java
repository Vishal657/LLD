public class DoublyLinkedList<K, V> {
    DdlNode<K, V> head, tail;

    void addFirst(DdlNode<K, V> newNode) {
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.right = head;
        newNode.left = null;
        head.left = newNode;
        head = newNode;
    }

    void remove(DdlNode<K, V> node) {
        if (head == tail) {
            head = tail = null;
            return;
        }
        if (node == head) {
            head = node.right;
            head.left = null;
            return;
        }
        if (node == tail) {
            tail = tail.left;
            tail.right = null;
            return;
        }
        node.left.right = node.right;
        node.right.left = node.left;
    }

    DdlNode<K, V> removeLast() {
        DdlNode<K, V> tempNode = tail;
        remove(tail);
        return tempNode;
    }

}
