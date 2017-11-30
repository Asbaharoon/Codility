package com.test.codility.cyclicrotation;

import static org.assertj.core.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class Solution {

	@Test
	public void test() {
		// int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int[] expected = { 4, 5, 6, 7, 8, 1, 2, 3 };
		int[] array = { 3, 8, 9, 7, 6 };
		int[] expected = { 9, 7, 6, 3, 8 };
		int rotations = 3;

		assertThat(solution(array, rotations)).isEqualTo(expected);

	}

	public int[] solution(int[] array, int rotations) {
		if (array.length == 0 || array.length == 1) {
			return array;
		}
		List<Integer> list = toList(array);
		for (int i = 0; i < rotations; i++) {
			Integer last = list.get(list.size() - 1);
			List<Integer> subList = list.subList(0, list.size() - 1);
			list = new ArrayList<Integer>();
			list.add(last);
			list.addAll(subList);
		}
		// int[] result = new int[list.size()];
		// for (int i = 0; i < list.size(); i++) {
		// result[i] = list.get(i);
		// }
		// return result;
		return list.stream().mapToInt(i -> i).toArray();
	}

	private static List<Integer> toList(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}
}
