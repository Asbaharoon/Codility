package com.test.codility.permmissingelem;

import static org.assertj.core.api.Assertions.*;

import org.junit.*;

public class Solution {

	@Test
	public void permMissingElem() {
		int[] array = { 2, 3, 1, 5 };
		int expected = 4;

		assertThat(solution(array)).isEqualTo(expected);
	}

	public int solution(int[] array) {
		int elements = array.length + 1;
		int calc = elements * (elements + 1) / 2;

		for (int number : array) {

			calc -= number;
		}

		return calc;
	}
}
