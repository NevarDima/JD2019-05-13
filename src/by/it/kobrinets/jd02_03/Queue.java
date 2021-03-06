package by.it.kobrinets.jd02_03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Queue {

    private final static BlockingQueue<Buyer> internalQueue = new LinkedBlockingQueue<>(30);
    private static void printSize() {
        if (internalQueue.size() > 0)
            System.out.println("Queue size: " + internalQueue.size());
    }

    static void add(Buyer buyer) {
        try {
            internalQueue.put(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSize();
    }

    static Buyer extract(){
        Buyer buyer = internalQueue.poll();
        printSize();
        return buyer;
    }

    static boolean buyerInQueue(Buyer buyer) {
        return internalQueue.contains(buyer);
    }
}