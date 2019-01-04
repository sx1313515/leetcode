package dynamicplanning;

import java.math.BigInteger;

/**
 * @ProjectName: leetcode
 * @Package: dynamicplanning
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2018/12/28 10:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/12/28 10:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        student s = new student();
        s.setName("song");
        student b = s;
        b.setName("zhou");
    }
}
class student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
