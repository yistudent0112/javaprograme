package Basical.program.set;

public class programe_7_2_Time {
	private int hour;
	private int minute;

	public programe_7_2_Time(int minute, int hour) {
		this.minute = minute;
		this.hour = hour;
		regular(minute,hour);
	}

	// 用于将time类的时间转化为正常的时间
	// 例23点69分转换为0点9分
	public void regular(int minute, int hour) {
		// 将minute纠正为正常时间
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
		// 将hour纠正为正常时间
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
 * 计算时钟增加了变量minute分钟后的时间为几点几分
 * 例 时间为12:00 分钟为 100
 * 则时间为13:40
 * 变量minute可为负数
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
	
	//显示当前时间
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
