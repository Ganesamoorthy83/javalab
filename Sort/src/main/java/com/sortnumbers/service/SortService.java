package com.sortnumbers.service;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import com.sortnumbers.model.SortResult;

/**
 * Sort a given amount of numerical values by randomly change position of values 
 * in ascending order implemented by using insertion sort algorithm. 
 * Calculates the sorting time duration in Nano Seconds. 
 * Count the changes of position.
 * 
 * @author Ganesamoorthy.S 
 */
public class SortService {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	private final String SUCCESS_STATUS = "success";
	private final String FAILURE_STATUS = "Sort Failed: ";
	
	/**
	 * @param numbers
	 * @return SortResult
	 */
	public SortResult sort(String numbers) {
		int[] arr = null;
		try {
			// convert the string to int[].
			arr = Arrays.stream(numbers.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			logger.error("The given numbers should be in numerial values :" + numbers);
			return new SortResult(numbers, "", 0, 0, (FAILURE_STATUS+"The given numbers ["+ numbers+"] are invalid. " ));
		}
		
		String unSortedNumbers = Arrays.toString(arr);
		LocalTime startTime = LocalTime.now();
		// invoke sort
		int count = sortByRandomNumber(arr);
		LocalTime endTime = LocalTime.now();
		
		// measures the duration between startTime and endTime.
		Duration duration = Duration.between(startTime, endTime);
		
		return new SortResult(unSortedNumbers, Arrays.toString(arr), duration.getNano(), count, SUCCESS_STATUS);
	}

	/**
	 * @param nums
	 * @return swapCount
	 */
	public static int sortByRandomNumber(int nums[]) {
		int swapCount = 0;
		Random random = new Random(nums.length);

		// traverse the array elements until sorted in ascending order
		while (!ArrayUtils.isSorted(nums)) {
			int randomIndex = random.nextInt(nums.length);

			int key = nums[randomIndex];
			int j = randomIndex - 1;

			// Move the elements to right till we find the correct position for
			// the key
			for (; j >= 0 && nums[j] > key; j--) {
				nums[j + 1] = nums[j];
				swapCount++;
			}
			nums[j + 1] = key;
		}
		return swapCount;

	}

}
