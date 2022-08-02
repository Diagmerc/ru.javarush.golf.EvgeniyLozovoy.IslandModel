package Runner;

import Island.Island;
import Runner.TestThread;
import Runner.TestThread2;

public class Main  {
    public static void main(String[] args) {
        Island island = new Island();
        island.initialize();
        new TestThread2().run();
        new TestThread().run();
    }
}
