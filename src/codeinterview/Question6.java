package codeinterview;

import java.util.*;

/**
 * 用两个栈实现队列，支持队列的基本操作
 * 由两个栈组成的队列
 */
public class Question6 {
    public static void main(String[] args){
        QueueByStack sq = new QueueByStack();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        for(int i=0;i<N;i++){
            String line = scanner.nextLine();
            if(line.startsWith("add")){
                String[] num = line.split(" ");
                int x =Integer.valueOf(num[1]);
                sq.add(x);
            }else if(line.startsWith("poll")){
                sq.poll();
            }
            else if(line.startsWith("peek")){
                int res = sq.peek();
                System.out.println(res);
            }
        }


    }

    private static class QueueByStack {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        public void add(int x) {
            s1.push(x);
        }

        public void poll() {
            while (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            s2.pop();
        }

        public int peek() {
            while (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }
    }
}