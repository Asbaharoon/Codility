package com.test.codility.smallestintmissing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		int[] arr = { -5, -3, -1, 0, 1, 2, 4, 6, 9 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] array) {
		List<Integer> numbers = toList(array);
		numbers = removeInvalidValues(numbers);
		for (Integer number : numbers) {
			int lessOne = number - 1;
			int plusOne = number + 1;
			if (lessOne > 0 && !numbers.contains(lessOne)) {
				return lessOne;
			} else if (!numbers.contains(plusOne)) {
				return plusOne;
			}
		}
		return 0;
	}

	private static List<Integer> toList(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	private static List<Integer> removeInvalidValues(List<Integer> numbers) {
		return numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
	}

}
