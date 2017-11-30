package com.test.codility.binarygap;

import static org.assertj.core.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class Solution {

	@Test
	public void binaryGap() {
		Integer number = 1041;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(5);
		number = 15;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 1;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 5;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(1);
		number = 2147483647;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 6;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 328;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(2);
		number = 16;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 1024;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(0);
		number = 1376796946;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(5);
		number = 1073741825;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(29);
		number = 1610612737;
		System.out.println(number.toString() + "=" + Integer.toBinaryString(number));
		assertThat(solution(number)).isEqualTo(28);
	}

	public static int solution(int number) {
		String bin = Integer.toBinaryString(number).replaceAll("0*$", "");
		String[] splited = bin.split("1");
		ArrayList<String> list = toList(splited);
		int last = list.size() - 1;
		if (last > -1 && last != 0 && list.lastIndexOf("0") == last) {
			list.remove(last);
		}
		int max = 0;
		for (String gap : list) {
			if (gap.length() > max) {
				max = gap.length();
			}
		}
		return max;
	}

	private static ArrayList<String> toList(String[] splited) {
		return (ArrayList<String>) Arrays.stream(splited).filter(i -> i.length() > 0).collect(Collectors.toList());
	}

}
