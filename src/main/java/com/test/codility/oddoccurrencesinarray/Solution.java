package com.test.codility.oddoccurrencesinarray;

import static org.assertj.core.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

import org.junit.*;

public class Solution {

	@Test
	public void oddOccurrencesInArray() {
		int[] array = { 9, 3, 9, 3, 9, 7, 9 };
		assertThat(solution1(array)).isEqualTo(7);

	}

	public static int solution1(int[] array) {
		List<Integer> list = toList(array);
		List<Integer> collectedList = list.stream().filter(num -> {
			List<Integer> collected = list.stream().filter(candidate -> candidate == num).collect(Collectors.toList());
			return collected.size() % 2 != 0;
		}).collect(Collectors.toList());
		return collectedList.stream().filter(num -> num > 0).findFirst().orElse(0);
	}

	public static int solution2(int[] array) {
		System.out.println("array[0]=" + array[0] + "\n\n");
		int unPairedNum = array[0];
		for (int i = 1; i < array.length; i++) {
			System.out.println("array[i]=" + array[i]);
			System.out.println("unPairedNum=" + unPairedNum);
			System.out.println("unPairedNum ^ array[i]=" + ((int) unPairedNum ^ array[i]));
			unPairedNum = unPairedNum ^ array[i];
			System.out.println("new unPairedNum=" + unPairedNum + "\n");
		}
		System.out.println("\nfound unPairedNum=" + unPairedNum + "\n");
		return unPairedNum;
	}

	private static List<Integer> toList(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

}
