package Basical.program.set;

public class programe_7_24_number {
	private int number;
	private int numbers[] = new int[100];
	//用来控制数组的真实长度
    private int length=0;
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLength() {
		return length;
	}

	public programe_7_24_number(int number) {
		this.number = number;
	}
//算出这个数的所有最小公因数，并把它保存到一个数组中去
	public void Count() {
		int border = Math.abs(number/2);
		int j = 0;
		int temp=number;
		for (int i = 2; i <= border; i++) {
			if ((temp % i) == 0) {
				numbers[j] = i;
				temp = temp / i;
				j++;
				i = 1;
				length++;
			}
		}
	}
    public int[] GetNumbers() {
    	return numbers;
    }
	public void print() {
		for (int i = 0; i <length; i++) {
			System.out.println(numbers[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_7_24_number p = new programe_7_24_number(120);
		p.Count();
		p.print();
	}

}
