package English.programe;

public class programe_6_3_Node {
private int Coefficient;//多项式系数
private int Exponent;//多项式的指数

	public programe_6_3_Node(int coefficient, int exponent) {
	Coefficient = coefficient;
	Exponent = exponent;
}

	@Override
	public String toString() {
		return "programe_6_3_Node [Coefficient=" + Coefficient + ", Exponent=" + Exponent + "]";
	}

	public int getCoefficient() {
	return Coefficient;
}

public void setCoefficient(int coefficient) {
	Coefficient = coefficient;
}

public int getExponent() {
	return Exponent;
}

public void setExponent(int exponent) {
	Exponent = exponent;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
