package com.yi.Sort;

public class Sort2 {
	/**
	 * 
	 * 在做搜索是要考虑搜索范围比较大的情况下，int可能会产生溢出的情况
	 * 所以要用一些范围更大的变量来做二分查找
	 */
	public boolean isBadVersion(int version) {
		if (version >= 1702766719)
			return true;
		else {
			return false;
		}
	}

//	public int firstBadVersion(int n) {
//		if (n < 1) {
//			return 0;
//		}
//		long low = 0;
//		long high = n;
//		long middle = (low + high) / 2;
//		while (middle >= low && middle <= high) {
//			if (isBadVersion((int)middle)) {
//				high = middle;
//				middle = (low + high) / 2;
//			} else {
//				if (isBadVersion((int)middle + 1)) {
//					middle++;
//					break;
//				}
//				low = middle;
//				middle = (low + high) / 2;
//			}
//		}
//		return (int)middle;
//	}
	/*
	 * 别人的优秀代码
	 */
    public int firstBadVersion(int n) {
        int min = 1, max = n, mid = 0;
        while(min <= max){
            mid = min + (max - min) / 2;
            if(isBadVersion(mid)){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort2 test = new Sort2();
		test.firstBadVersion(2126753390);
		String s="1";
		s.concat("2");
		s.equals("1");
	
	}

}
