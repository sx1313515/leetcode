package realinterviewquestions.huanjushidai.serializeAndSocket;


import realinterviewquestions.huanjushidai.serializeAndSocket.impl.ReceiverImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server;
		try {
			server = new ServerSocket(7778);
			System.out.println("服务器启动，等待客户端的连接");
			Socket socket = server.accept();
			InputStream is = socket.getInputStream();
			byte[] bytes = new byte[1024];
			is.read(bytes);
			ReceiverImpl receive = new ReceiverImpl();
			MyObject no = null;
			no = receive.receive(bytes);
			System.out.println(no.toString());
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			osw.write("服务器说：接受完毕！");
			osw.flush();
			socket.shutdownOutput();
			//关闭资源
			os.close();
			osw.close();
			socket.close();
			//while(is.read())
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
