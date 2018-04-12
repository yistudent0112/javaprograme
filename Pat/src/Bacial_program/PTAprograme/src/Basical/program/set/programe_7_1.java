package Basical.program.set;
/*
 * 如果已知英制长度的英尺foot和英寸inch的值，
 * 那么对应的米是(foot+inch/12)×0.3048。
 * 现在，如果用户输入的是厘米数，
 * 那么对应英制长度的英尺和英寸是多少呢？
 * 别忘了1英尺等于12英寸。
 */
import Basical.program.set.programe_7_1_Inch;
public class programe_7_1 {
  public double  InchChangeMeter(programe_7_1_Inch Inch) {
	  double meter=0.0;
	  double inch=Inch.getInch();
	  double foot=Inch.getFoot();
	  meter=(foot+inch/12)*0.3048;
	  return meter*100;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_1 p=new programe_7_1();
		programe_7_1_Inch Inch=new programe_7_1_Inch(5,0);
		System.out.println(p.InchChangeMeter(Inch));
	}

}
