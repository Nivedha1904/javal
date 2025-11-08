package multi_Threading;

public class Thread_baking implements Runnable {

    public void run() {
        try {
            System.out.println("\nPreparation done by " + Thread.currentThread().getName() + " | Priority: " + Thread.currentThread().getPriority());
            Thread.sleep(500);
            System.out.println("Mixing done by " + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("Baking Cake done by " + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("Decoration done by " + Thread.currentThread().getName());
            System.out.println("---------------------------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread_baking t = new Thread_baking();

        Thread th = new Thread(t, "team1");
        Thread th2 = new Thread(t, "team2");
        Thread th3 = new Thread(t, "team3");

        th.setPriority(Thread.MIN_PRIORITY);
        th2.setPriority(Thread.NORM_PRIORITY);
        th3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("State of th before start: " + th.getState());
        th.start();
        th2.start();
        th3.start();

        System.out.println("State of th after start: " + th.getState());

        Thread.sleep(2000);

        System.out.println("\nBefore join:");
        System.out.println("th alive: " + th.isAlive());
        System.out.println("th2 alive: " + th2.isAlive());
        System.out.println("th3 alive: " + th3.isAlive());

        th.join();
        th2.join();
        th3.join();

        System.out.println("\nAfter join:");
        System.out.println("th alive: " + th.isAlive());
        System.out.println("th2 alive: " + th2.isAlive());
        System.out.println("th3 alive: " + th3.isAlive());

        System.out.println("\nState of th after join: " + th.getState());
    }
}
