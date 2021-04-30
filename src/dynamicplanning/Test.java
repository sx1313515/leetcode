package dynamicplanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    static class student{
        public int age;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        System.out.println(list1.getClass() == list2.getClass());
    }
}

