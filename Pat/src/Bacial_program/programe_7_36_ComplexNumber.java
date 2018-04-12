package Bacial_program;

/*
 * 复数类
 */
public class programe_7_36_ComplexNumber {
	private double RealPart;// 实部的部分
	private double ImaginaryPart;// 虚部的部分
	private String Number;

	
 
	public programe_7_36_ComplexNumber(double realPart, double imaginaryPart) {
		RealPart = realPart;
		ImaginaryPart = imaginaryPart;
		SetNumber();
	}

	public double getRealPart() {
		return RealPart;
	}

	public void setRealPart(double realPart) {
		RealPart = realPart;
	}

	public double getImaginaryPart() {
		return ImaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		ImaginaryPart = imaginaryPart;
	}

	public void SetNumber() {
		if(ImaginaryPart>0) {
		Number=RealPart+"+"+ImaginaryPart+"i";
		}
		else if(ImaginaryPart==0) {
			Number=RealPart+"";
		}else if(ImaginaryPart<0) {
			Number=RealPart+""+ImaginaryPart+"i";
		}
	}

     public String GetNumber() {
    	 return Number;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
