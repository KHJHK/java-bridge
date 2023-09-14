package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeRandomNumberGenerator bng = new BridgeRandomNumberGenerator();

        int a = bng.generate();
        System.out.println(a);
    }
}
