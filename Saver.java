package ru.mail.dimapilot;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalAccessException, InvocationTargetException {

		TextContainer tc = new TextContainer();
		Class<?> tcClass = tc.getClass();
		try {
			Method method = tcClass.getDeclaredMethod("save", String.class, String.class);

			Field field = tcClass.getDeclaredField("text");
			String text2 = (String) field.get(tc);

			SaveTo mysaveto = tcClass.getAnnotation(SaveTo.class);

			method.invoke(tc, mysaveto.path(), text2);

		} catch (NoSuchMethodException | IllegalArgumentException e) {
		}

	}

}
