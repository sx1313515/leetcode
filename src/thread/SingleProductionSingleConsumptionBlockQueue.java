package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:单生产单消费，通过阻塞队列实现
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/13 10:40
 */
public class SingleProductionSingleConsumptionBlockQueue {
    private static ArrayBlockingQueue<String> arrayBlockingQueue =
            new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        arrayBlockingQueue.put(i+"");
                        System.out.println("1生产"+i);
                    } catch (InterruptedException e) {


                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 20; i < 40; i++) {
                    try {
                        arrayBlockingQueue.put(i+"");
                        System.out.println("2生产"+i);
                    } catch (InterruptedException e) {


                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("1消费"+arrayBlockingQueue.take());;
                    } catch (InterruptedException e) {


                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        System.out.println("2消费"+arrayBlockingQueue.take());;
                    } catch (InterruptedException e) {


                    }
                }
            }
        });
        executorService.shutdown();
    }



}
