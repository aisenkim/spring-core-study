package hello.core.singleton;

/**
 * Just to test service out
 * Not unit test
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // Private constructor to prevent it from being created
    private SingletonService() {
    }

    // can only get instance through this method
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("Singleton object logic called");
    }

}
