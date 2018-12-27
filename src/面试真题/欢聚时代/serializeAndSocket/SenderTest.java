package 面试真题.欢聚时代.serializeAndSocket;


import 面试真题.欢聚时代.serializeAndSocket.impl.SenderImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SenderTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("127.0.0.1", 7778);
			System.out.println("客户端启动，即将连接服务器");
			OutputStream os = socket.getOutputStream();
			SenderImpl send = new SenderImpl();
			MyObject o = new MyObject();
			List list = new ArrayList();
			list.add(10);
			list.add(20);
			o.setA("我日你");
			o.setB(43);
			o.setC(list);
			byte[] bytes = send.send(o);
			System.out.println(new String(bytes));
			os.write(bytes);
			os.flush();
			socket.shutdownOutput();//关闭输出流
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			char[] ch = new char[1024];
			int i;
			while((i=isr.read(ch, 0, ch.length))!=-1)
			{
				System.out.println("我是客户端,"+new String(ch));
			}
			//4.关闭资源
			os.close();
			is.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
