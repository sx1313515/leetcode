package dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test extends Thread{
    public Test() {
        this.setName("sadas");
    }


    static class student{
        public int age;
    }

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1,new ArrayBlockingQueue<String>(2),);
        ExecutorService executorService = Executors.newFixedThreadPool(10);


    }
}

