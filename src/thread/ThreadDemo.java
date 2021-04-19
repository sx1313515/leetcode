package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待唤醒机制的最经典实例。 生产消费者模式 多生产者多消费者模式 。
 *
 * 1,出现多生产，多消费问题？？？if(flag)-->while(flag)
 *
 * 2,多生产者多消费者模式的等待唤醒机制中的死锁？？？notifyAll()
 *
 * 3,notifyAll();唤醒所用的线程，浪费资源？？？ 使用Luck和 Condition实现一个方锁两个监视器
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        BoundedBuffer r = new BoundedBuffer();
        Producter in = new Producter(r);
        Consumer out = new Consumer(r);

        Thread tin = new Thread(in);
        Thread tin1 = new Thread(in);

        Thread tout = new Thread(out);
        Thread tout1 = new Thread(out);

        tin.start();
        tin1.start();
        tout.start();
        tout1.start();
    }
}

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[10];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            System.out.println("生產結束 現在個數="+count);
            bl(items);
            System.out.println("");
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            items[takeptr]="[ ]";
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            System.out.println("消費結束 現在個數="+count);
            bl(items);
            System.out.println("");
            lock.unlock();
        }
    }


    private void bl(Object[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.print("元素有:");
            System.out.print(i+"="+items[i]+" ");
        }
    }
}

class Producter implements Runnable {
    BoundedBuffer r;

    Producter(BoundedBuffer r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            try {
                r.put("烤鸭");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    BoundedBuffer r;
    Consumer(BoundedBuffer r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            try {
                r.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}