package realinterviewquestions.huanjushidai.serializeAndSocket;

import java.io.Serializable;
import java.util.List;

public class MyObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public String a;
    public int b;
    public List c;
	@Override
	public String toString() {
		return "MyObject [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public List getC() {
		return c;
	}
	public void setC(List c) {
		this.c = c;
	}
	
    
    

}
