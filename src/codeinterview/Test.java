package codeinterview;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        String str = "aa";
        HashMap<Integer, stu> map = new HashMap<>();
        stu s = new stu();
        s.age = 10;
        map.put(1, s);
        s.age = 11;
        System.out.println(map.get(1).age);;
    }
    static class stu{
        public int age;
    }
}