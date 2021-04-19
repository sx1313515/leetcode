package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:单生产单消费
 *
 * @Author: xiang_song
 * @CreateDate: 2021/4/13 10:40
 */
public class SingleProductionSingleConsumption {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static boolean flag = false;
    private static String value = null;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; ) {
                        if (!flag) {
                            flag = true;
                            value = "生产"+i;
                            System.out.println(value);
                            c2.signal();
                            i++;
                        } else {
                            c1.await();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }finally {
                    lock.unlock();
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; ) {
                        if (flag) {
                            flag = false;
                            value = "消费"+i;
                            System.out.println(value);
                            c1.signal();
                            i++;
                        } else {
                            c2.await();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }finally {
                    lock.unlock();
                }
            }
        });
        executorService.shutdown();
    }



}
