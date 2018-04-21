package exception;

public class main {
public static boolean  test() {
	boolean temp=false;
	try {
		int i=1/0;
		return true;
	}
//System.out.println("processing");
	catch(Exception e) {
		System.out.println("catch the exception");
		temp=true;
	}
	finally {
		temp=false;
		
	}
	return temp;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
if(test())
	System.out.println("true");;
	}

}
