public class Client {
    LRUCache<String, Integer> cache;        // instead of Datanode we are passing int, we can pass anything

    Client() {
        cache = new LRUCache<>(2);
    }

    public static void main(String[] args) {
        Client c = new Client();

        c.cache.addToCache("1",1);
        c.cache.addToCache("2",2);

        System.out.println(c.cache.getValue("1"));      // 1
        System.out.println(c.cache.getValue("2"));      // 2

        c.cache.addToCache("3",3);
        System.out.println(c.cache.getValue("3"));      // 3

        System.out.println(c.cache.getValue("1"));      // null
        System.out.println(c.cache.getValue("2"));      // 2

    }

}
