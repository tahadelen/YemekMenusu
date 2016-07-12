package com.tahadelen.utils;

import java.lang.reflect.Method;

public class NumberPicker {
	private Object picker;
	private Class<?> classPicker;

	public NumberPicker(Object o) {
		picker = o;
		classPicker = picker.getClass();
	}

	public void setRange(int start, int end) {
		try {
			Method m = classPicker.getMethod("setRange", int.class, int.class);
			m.invoke(picker, start, end);
		} catch (Exception e) {
		}
	}

	public Integer getCurrent() {
		Integer current = -1;
		try {
			Method m = classPicker.getMethod("getCurrent");
			current = (Integer) m.invoke(picker);
		} catch (Exception e) {
		}
		return current;
	}

	public void setCurrent(int current) {
		try {
			Method m = classPicker.getMethod("setCurrent", int.class);
			m.invoke(picker, current);
		} catch (Exception e) {
		}
	}
}
