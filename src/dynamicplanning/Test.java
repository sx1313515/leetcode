package dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    static class student{
        public int age;
    }

    public static void main(String[] args) {
        student s1 = new student();
        s1.age = 10;
        student s2 = s1;
        System.out.println(s1.age);
        s2.age = 20;
        System.out.println(s1.age);
    }
}

