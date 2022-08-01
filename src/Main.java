import Animals.Animal;
import Island.Island;

import java.util.List;

public class Main  {
    public static void main(String[] args) {
        TestThread test = new TestThread();
        TestThread2 testThread2 = new TestThread2();
        test.run();
        testThread2.run();
    }
}
