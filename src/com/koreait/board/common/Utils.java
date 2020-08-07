package com.koreait.board.common;

public class Utils {
	public static int parseStringToInt(String str, int defualt_num) {
		if(str != null) {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {
				e.printStackTrace();
				return defualt_num;
			}			
		}else {
			return -1;
		}
	}
}
