package exception;
/*
 * 
 */
public class exception extends Exception {

	/**
	 * @author admin
	 
	 */
	private static final long serialVersionUID = 1L;
public exception(String message) {
	super(message);
}
public void test()throws exception {
	String a="";
	a.equals(""
			+ "");
	System.out.println("test() has caught");
	throw new exception("a new one");
}
public void test2() throws exception {
	try {
	test();
	}
	catch(Exception e) {
		System.out.println("test2() has caught");
		throw new exception("a second one ");
	}
}
public static void main(String[]args) {
	exception e=new exception("");
	String s1="1";
	String s2="1";
	System.out.println(""+(s1=s2));
	try {
		e.test2();
	}
	catch(Exception a){
		a.printStackTrace();
	}
}
}
