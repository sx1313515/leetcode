package backtrackingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 描述:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @Author: g
 * @CreateDate: 2019/1/3 9:40
 */
public class NonRepeatingElement {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        int count=0;
        fun(result,list,candidates,target,count,0);
        return result;
    }

    private void fun(List<List<Integer>> result,List<Integer> list, int[] candidates, int target,int count,int index) {
        int length = candidates.length;
        for(int i=index;i<length;i++){
            count = count+candidates[i];
            list.add(candidates[i]);
            if(count==target){
                boolean flag = true;
                for(int h=0;h<result.size();h++){
                    List<Integer> integers = result.get(h);
                    if(integers.size()!=list.size())
                        continue;
                    else{
                        int j;
                        for(j=0;j<list.size();j++){
                            if(list.get(j)!=integers.get(j)) {
                                break;
                            }
                        }
                        if(j==list.size()){
                            flag = false;
                            break;
                        }

                    }
                }
                if(flag){
                    result.add(new ArrayList<>(list));
                }
                count = count -candidates[i];
                list.remove(list.size() - 1);
                break;
            }else if(count>target){
                count = count -candidates[i];
                list.remove(list.size() - 1);
                break;
            }else {
                fun(result,list,candidates,target,count,i);
            }
            count = count -candidates[i];
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
//        NonRepeatingElement n = new NonRepeatingElement();
//        List<List<Integer>> result = n.combinationSum(new int[]{2, 3, 6, 7}, 7);
//        System.out.println();
//        List<Student> list = new ArrayList<>();

//        Student a = new Student();
//        a.setAge(20);
//        a.setName("song");
//        Student[] students = new Student[]{a};
//        list.add(a);
//        a = new Student();
//        a.setAge(30);
//        a.setName("zhou");
//        System.out.println();
        int j;
        for(j=0;j<10;j++){

        }
        System.out.println(j);
    }
}
class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
