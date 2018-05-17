package English.programe;

public class programe_6_8_priority_queue3 {
	private static int[] arr;
	private static int Length;
	private static int Capcity;

	public programe_6_8_priority_queue3(int n) {
		/*
		 * Scanner in =new Scanner(System.in); int n=in.nextInt();
		 */
		Capcity = n;
		arr = new int[n];
	}

	public boolean IsFull() {
		boolean flag = true;
		if (Length < Capcity) {
			flag = false;
		}
		return flag;
	}

	public boolean IsEmpty() {
		boolean flag = true;
		if (Length > 0) {
			flag = false;
		}
		return flag;
	}

	public void AddElement(int number) {
		if (!IsFull()) {
			arr[Length] = number;
			swim(Length);
			Length++;
		}
	}

	public int DeleteElement() {
		int number = -1;
		if (!IsEmpty()) {
			swap(0, --Length);
			number = arr[Length];
			arr[Length] = 0;
			sink(0);
		}
		return number;
	}

	public void swim(int index) {
		while (index > 0 && Compare(index, index / 2)) {
			swap(index, index / 2);
			index = index / 2;
		}
	}

	public void sink(int index) {
		while (2 * index <= Length) {
			int j = 2 * index;
			if (j < Length && !Compare(j, j + 1)) {
				j++;
			}
			if (Compare(j, index)) {
				swap(j, index);
			}
			index = j;
		}
	}

	public boolean Compare(int index1, int index2) {
		boolean flag = false;
		if (arr[index1] > arr[index2]) {
			flag = true;
		}
		return flag;
	}

	public void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		programe_6_8_priority_queue3 p = new programe_6_8_priority_queue3(10);
		p.AddElement(10);
	    p.AddElement(10);
	    p.AddElement(20);
		// p.AddElement(15);
		p.AddElement(30);
		p.AddElement(50);
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
	//	System.out.println(p.DeleteElement());
		System.out.println(p.DeleteElement());
	}

}
