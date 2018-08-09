package com.yi.test;

/**
 * 
 * ö�����͵�ʹ��˵��
 * ö����enum��һ��������
 * 
 *
 */
enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public enum EnumFlight {
	OW(1, "����"), RT(2, "����"), ZJ(3, "ת��");
	public Integer flightCode;
	public String flightDescription;
/**
 * 
 * ö�����͵Ĺ��캯����ֻ���б��������ã��û��Լ��޷����ã�Ҳ�Ͳ��������µ�ʵ��������
 */
	private EnumFlight(Integer code, String desc) {
		flightCode = code;
		flightDescription = desc;
	}

	public Integer getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(Integer flightCode) {
		this.flightCode = flightCode;
	}

	public String getFlightDescription() {
		return flightDescription;
	}

	public void setFlightDescription(String flightDescription) {
		this.flightDescription = flightDescription;
	}

	public static EnumFlight FindFlightByCode(Integer code) {
		EnumFlight defaultFlight = OW;
		for (EnumFlight ftemp : EnumFlight.values()) {
			if (ftemp.flightCode == code) {
				defaultFlight = ftemp;
			}
		}
		return defaultFlight;
	}

	public static void main(String[] args) {
//		EnumFlight ftemp = FindFlightByCode(4);
//		// System.out.println(ftemp.flightDescription);
//		Day[] days = new Day[] { Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY,
//				Day.SUNDAY };
//
//		for (int i = 0; i < days.length; i++) {
//			System.out.println("day[" + i + "].ordinal():" + days[i].ordinal());
//		}
		// EnumFlight ftemp=new EnumFlight();
	}
}
