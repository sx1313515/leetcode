package realinterviewquestions.huanjushidai.serializeAndSocket;


import realinterviewquestions.huanjushidai.serializeAndSocket.impl.ReceiverImpl;
import realinterviewquestions.huanjushidai.serializeAndSocket.impl.SenderImpl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		SenderImpl send = new SenderImpl();
		ReceiverImpl receive = new ReceiverImpl();
		MyObject o = new MyObject();
		MyObject no = null;
		List list = new ArrayList();
		list.add(10);
		list.add(20);
		o.setA("我日你");
		o.setB(43);
		o.setC(list);
		byte[] bytes = send.send(o);
		no = receive.receive(bytes);
		System.out.println(no.toString());
	}

}
