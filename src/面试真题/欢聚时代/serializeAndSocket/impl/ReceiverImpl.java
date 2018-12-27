package 面试真题.欢聚时代.serializeAndSocket.impl;


import 面试真题.欢聚时代.serializeAndSocket.MyObject;
import 面试真题.欢聚时代.serializeAndSocket.Receiver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReceiverImpl implements Receiver {

	@Override
	public MyObject receive(byte[] bytes) {
		// TODO Auto-generated method stub
		MyObject o = null;
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
				o = (MyObject) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return o;
	}

}
