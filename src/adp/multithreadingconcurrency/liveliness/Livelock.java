package adp.multithreadingconcurrency.liveliness;

import adp.multithreadingconcurrency.liveliness.livelockresources.CommonResource;
import adp.multithreadingconcurrency.liveliness.livelockresources.Worker;

/**
 * Livelock:
 * A thread often acts in "response" to the action of another thread.
 * If the other thread's action is "also a response" to the action of another thread,
 * then livelock may result.
 *
 * As with deadlock, livelocked threads are unable to make further progress.
 * However, the threads are not blocked — they are simply too busy responding to each other
 * to resume work. This is comparable to two people attempting to pass each other in a corridor:
 * Alphonse moves to his left to let Gaston pass,
 * while Gaston moves to his right to let Alphonse pass.
 * Seeing that they are still blocking each other,
 * Alphonse moves to his right,
 * while Gaston moves to his left.
 * They're still blocking each other, so... that is livelocked
 */
public class Livelock {
    public static void main (String[] args) {
        final Worker worker1 = new Worker("Worker 1 ", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final CommonResource s = new CommonResource(worker1);

//        new Thread(() -> {
//            worker1.work(s, worker2);
//        }).start();
        // Replaced with expression lambda
        new Thread(() -> worker1.work(s, worker2)).start();

//        new Thread(() -> {
//            worker2.work(s, worker1);
//        }).start();
        // Replaced with expression lambda
        new Thread(() -> worker2.work(s, worker1)).start();
    }
}
/*
For example consider a situation where two threads want to access a shared common resource
via a Worker object but when they see that other Worker (invoked on another thread) is also 'active',
they attempt to hand over the resource to other worker and wait for it to finish.
If initially we make both workers active they will suffer from livelock.

                             Thread1 -> Worker1 -> work on the resource
                                 ^                                 ^
                                 |                                 |  no
Common Resource: Handover to other thread?   <--Yes-- Is other worker active?
                                 |                                 |  no
                                 v                                 v
                              Thread2 -> Worker2 -> work on the resource
 */
