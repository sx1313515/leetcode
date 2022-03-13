package designpattern;

/**
 * 描述:
 *
 * @Author: xiang_song
 * @CreateDate: 2022/3/13 13:43
 */
public interface Parent {
    void fun();
}

abstract class AbstractSon implements Parent {
    public void call() {
        fun();
    }
}

class Son extends AbstractSon {

    @Override
    public void fun() {

    }
}
