package Bacial_program;

/*
 * ������
 */
public class programe_7_36_ComplexNumber {
	private double RealPart;// ʵ���Ĳ���
	private double ImaginaryPart;// �鲿�Ĳ���
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
