package com.yi.thread;

public class EnergySystem {
	private final double[] energyBoxs;

	public EnergySystem(int boxNumber, double initailEnergy) {
		energyBoxs = new double[boxNumber];
		for (int i = 0; i < boxNumber; i++) {
			energyBoxs[i] = initailEnergy;
		}
	}

	public void TransferEnergy(int from, int to, double energyNumber) {
		if (energyBoxs[from] < energyNumber) {
			return;
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("��" + from + "����ת�Ƶ�" + to + "����" + energyNumber + "����");
		energyBoxs[from] -= energyNumber;
		energyBoxs[to] += energyNumber;
		System.out.println("�����ܺ�Ϊ" + CountAllEnergy());
	}

	public double CountAllEnergy() {
		double sum = 0;
		for (int i = 0; i < energyBoxs.length; i++) {
			sum += energyBoxs[i];
		}
		return sum;
	}

	public int EnergyBoxLength() {
		return energyBoxs.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
