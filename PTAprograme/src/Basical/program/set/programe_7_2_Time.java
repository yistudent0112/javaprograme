package Basical.program.set;

public class programe_7_2_Time {
	private int hour;
	private int minute;

	public programe_7_2_Time(int minute, int hour) {
		this.minute = minute;
		this.hour = hour;
		regular(minute,hour);
	}

	// ���ڽ�time���ʱ��ת��Ϊ������ʱ��
	// ��23��69��ת��Ϊ0��9��
	public void regular(int minute, int hour) {
		// ��minute����Ϊ����ʱ��
        if(minute<0||minute>60) {
        	
        	while(minute<0) {
        		minute=minute+60;
        		hour--;
        	}
        	while(minute>59) { 		
        		minute=minute-60;
        		hour++;
        	}
        }
		// ��hour����Ϊ����ʱ��
		if (hour < 0 || hour > 23) {
			while (hour > 23) {
				hour = hour - 24;
			}
			while (hour < 0) {
				hour = hour + 24;
			}
		}
        this.minute=minute;
        this.hour=hour;			      
	}

/*
 * ����ʱ�������˱���minute���Ӻ��ʱ��Ϊ���㼸��
 * �� ʱ��Ϊ12:00 ����Ϊ 100
 * ��ʱ��Ϊ13:40
 * ����minute��Ϊ����
 */
	public void add(int minute) {
		boolean minus=false;
		if(minute<0) {
			minute=-minute;
			minus=true;
		}
    programe_7_2_Time p=new programe_7_2_Time(minute,0);
    //p.show();
    if(minus) {
    	this.minute=this.minute-p.minute;
    	this.hour=this.hour-p.hour;
    }else {
    	this.minute=this.minute+p.minute;
    	this.hour=this.hour+p.hour;
    }
    regular(this.minute, this.hour);
	}
	
	//��ʾ��ǰʱ��
    public void show() {
    	if(this.minute<10) {
    		System.out.println(this.hour+":0"+this.minute);
    	}else {
    	System.out.println(this.hour+":"+this.minute);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      programe_7_2_Time p=new programe_7_2_Time(69, 23);
      p.show();
      p.add(100);
      p.show();
      p.add(-110);
      p.show();
//      p.regular(69,24);
	}

}