package 面试真题.欢聚时代.BlockingQueueImpl;

public  interface BlockingQueue<E> {
	public void put(E e) throws InterruptedException;
    public E take() throws InterruptedException;
}
