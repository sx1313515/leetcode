package realinterviewquestions.huanjushidai.BlockingQueueImpl;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueImpl<E> implements BlockingQueue<E>{
	private final int Max_Length = 100;  //队列最大长度限制
	private Vector<E> vector = new Vector<E>(Max_Length);
	private ReentrantLock lock = new ReentrantLock(true);  //互斥锁
	private Condition notFull = lock.newCondition();  
	private Condition notempty = lock.newCondition();
	@Override
	public void put(E e) throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lockInterruptibly();  //获取锁
		int size = vector.size();
		try {
			if(size==Max_Length)
				notFull.await();  //进入阻塞状态
			else
			{
				vector.add(e);
				notempty.signal();  //唤醒一个等待线程
			}
		} finally {
			// TODO: handle finally clause
			lock.unlock();  //释放锁
		}
		
	}

	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lockInterruptibly();  //获取锁
		E e = null;
		try {
			if(vector.size()==0)
				notempty.await();  //进入阻塞状态
			else
			{
				e = vector.get(vector.size()-1);
				notFull.signal();  //唤醒一个等待线程
				return e;
			}
			return e;
		} finally {
			// TODO: handle finally clause
			lock.unlock();  //释放锁
		}
	}

}
