package Bacial_program;

import java.awt.im.InputContext;
import java.util.Scanner;

/*
 * 本题要求编写程序，
 * 计算2个复数的和、差、积、商。
 */
public class programe_7_36 {
private static programe_7_36_ComplexNumber Complex=
new programe_7_36_ComplexNumber(0, 0);
private static programe_7_36_ComplexNumber p1;
private static programe_7_36_ComplexNumber p2;
public  void AddComplex(programe_7_36_ComplexNumber p1
		,programe_7_36_ComplexNumber p2) {
	Complex.setRealPart(p1.getRealPart()+p2.getRealPart());
	Complex.setImaginaryPart(p1.getImaginaryPart()+p2.getImaginaryPart());
	Complex.SetNumber();
	System.out.println("("+p1.GetNumber()+")"+"+"+"("+p2.GetNumber()+")");
	System.out.println(Complex.GetNumber());
}
public  void MinusComplex(programe_7_36_ComplexNumber p1
		,programe_7_36_ComplexNumber p2) {
	Complex.setRealPart(p1.getRealPart()-p2.getRealPart());
	Complex.setImaginaryPart(p1.getImaginaryPart()-p2.getImaginaryPart());
	Complex.SetNumber();
	System.out.println("("+p1.GetNumber()+")"+"-"+"("+p2.GetNumber()+")");
	System.out.println(Complex.GetNumber());
}
public  void MultiplyComplex(programe_7_36_ComplexNumber p1
		,programe_7_36_ComplexNumber p2) {
	Complex.setRealPart(p1.getRealPart()*p2.getRealPart()
			-p1.getImaginaryPart()*p2.getImaginaryPart());
	Complex.setImaginaryPart(p1.getImaginaryPart()*p2.getRealPart()
			+p1.getRealPart()*p2.getImaginaryPart());
	Complex.SetNumber();
	System.out.println("("+p1.GetNumber()+")"+"*"+"("+p2.GetNumber()+")");
	System.out.println(Complex.GetNumber());
}
public  void DivisionComplex(programe_7_36_ComplexNumber p1
		,programe_7_36_ComplexNumber p2) {
	int temp=(int) (p2.getRealPart()*p2.getRealPart()
			+p2.getImaginaryPart()*p2.getImaginaryPart());
	double RealPart=p1.getRealPart()*p2.getRealPart()
			+p1.getImaginaryPart()*p2.getImaginaryPart();
	double ImaginaryPart=p1.getImaginaryPart()*p2.getRealPart()
			-p1.getRealPart()*p2.getImaginaryPart();
	Complex.setRealPart(RealPart/temp);
	Complex.setImaginaryPart(ImaginaryPart/temp);
	Complex.SetNumber();
	System.out.println("("+p1.GetNumber()+")"+"/"+"("+p2.GetNumber()+")");
	System.out.println(Complex.GetNumber());
}
public void Input() {
	Scanner in =new Scanner(System.in);
	double realpart=in.nextDouble();
	double imaginarypart=in.nextDouble();
    p1=new programe_7_36_ComplexNumber(realpart, imaginarypart);
	double realpart1=in.nextDouble();
	double imaginarypart1=in.nextDouble();
    p2=new programe_7_36_ComplexNumber(realpart1, imaginarypart1);
	in.close();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_36 p=new programe_7_36();
p.Input();
p.AddComplex(p1, p2);
p.MinusComplex(p1, p2);
p.MultiplyComplex(p1, p2);
p.DivisionComplex(p1, p2);
	}

}
