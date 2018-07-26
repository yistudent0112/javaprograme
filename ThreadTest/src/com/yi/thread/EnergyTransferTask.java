package com.yi.thread;

public class EnergyTransferTask implements Runnable{
private EnergySystem energySystem;
private int boxFrom;
private final double maxAmount;
private  int delay=1;
public EnergyTransferTask(EnergySystem energySystem,int boxFrom,double maxAmount) {
	this.energySystem=energySystem;
	this.boxFrom=boxFrom;
	this.maxAmount=maxAmount;
}

	public static void main(String[] args) {
EnergySystem energySystem=new EnergySystem(100, 1000);
for(int i=0;i<100;i++) {
     EnergyTransferTask task=new EnergyTransferTask(energySystem,i, 10000);
     Thread test=new Thread(task);
     test.setName("Current Thread"+i);
     test.start();
}
	}

	@Override
	public void run() {
		while(true) {
			int boxTo=(int) (Math.random()*energySystem.EnergyBoxLength());
			energySystem.TransferEnergy(boxFrom, boxTo, Math.random()*maxAmount);
			try {
				Thread.sleep((long) (Math.random()*delay/100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
