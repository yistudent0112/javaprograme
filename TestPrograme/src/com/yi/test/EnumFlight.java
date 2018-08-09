package com.yi.test;

/**
 * 
 * 枚举类型的使用说明
 * 枚举类enum是一个抽象类
 * 
 *
 */
enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public enum EnumFlight {
	OW(1, "单程"), RT(2, "往返"), ZJ(3, "转机");
	public Integer flightCode;
	public String flightDescription;
/**
 * 
 * 枚举类型的构造函数，只能有编译器调用，用户自己无法调用，也就不能生成新的实例化对象
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
