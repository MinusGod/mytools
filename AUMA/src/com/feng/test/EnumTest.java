package com.feng.test;

public enum EnumTest {
	Feng, Liu, Zhang;
	public static EnumTest initInstance(int init) {
		if (1 == init) {
			return Feng;
		} else if (2 == init) {
			return Liu;
		} else {
			return Zhang;
		}
	}

}
