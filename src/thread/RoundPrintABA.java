package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C，要求, 同时启动三个线程, 按顺序输出ABC, 循环10次
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/10 4:49 下午
 */
public class RoundPrintABA {

    private static int count = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            while (count <= 30) {
                lock.lock();
                if (count % 3 == 0) {
                    System.out.print("A");
                    count++;
                }
                lock.unlock();
            }
        });
        executorService.execute(() -> {
            while (count <= 30) {
                lock.lock();
                if (count % 3 == 1) {
                    System.out.print("B");
                    count++;
                }
                lock.unlock();
            }
        });
        executorService.execute(() -> {
            while (count <= 30) {
                lock.lock();
                if (count % 3 == 2) {
                    System.out.print("C");
                    count++;
                }
                lock.unlock();
            }
        });
        executorService.shutdown();
    }
}
