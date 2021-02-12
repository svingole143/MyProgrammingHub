package com.shankar.TDDExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shankar Ingole
 *
 */
public class StringCalculator {

	public String delimeter = ",|\\n";
	int count = 0;

	public int Add(String input) throws IllegalArgumentException {

		String[] splitInput = null;

		if (input.isEmpty()) {
			return 0;
		}
		if (input.length() == 1) {
			return parseStringToInt(input);
		}
		int add = 0;
		if (input.startsWith("//")) {
			String[] parts = input.split("\n", 2);
			/*
			 * if(parts[0].contains("[")) { delimeter =
			 * parts[0].substring(parts[0].indexOf("[")+1, parts[0].indexOf("]"));
			 * System.out.println(delimeter); System.out.println(parts[1]); splitInput =
			 * parts[1].split(delimeter); System.out.println(splitInput);
			 * 
			 * }else {
			 */
			delimeter = parts[0].substring(2);
			splitInput = parts[1].split(delimeter);
		} else {
			splitInput = input.split(delimeter);
		}

		for (String val : splitInput) {
			if (parseStringToInt(val) < 0) {
				List<String> negativeNumArr = new ArrayList<String>();
				for (String val1 : splitInput) {
					if (parseStringToInt(val1) < 0) {
						negativeNumArr.add(val1);
					}
				}
				throw new IllegalArgumentException("negatives not allowed " + negativeNumArr);
			} else if (parseStringToInt(val) > 1000) {
				continue;
			} else {
				add += parseStringToInt(val);
			}

		}
		return add;
	}

	public Integer parseStringToInt(String str) {
		return Integer.parseInt(str);
	}
}
