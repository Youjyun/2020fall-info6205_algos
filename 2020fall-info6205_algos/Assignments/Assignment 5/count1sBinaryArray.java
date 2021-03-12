package edu.northeastern.info6205;

class solution {

	public int countOnes(int arr[], int low, int high) {
		if (high >= low) {
			// get the middle index
			int mid = low + (high - low) / 2;

			// check if the element at middle index is last 1
			if ((mid == high || arr[mid + 1] == 0) && (arr[mid] == 1)) {
				return mid + 1;
			}
			// If element is not last 1, recur for right side
			if (arr[mid] == 1) {
				return countOnes(arr, (mid + 1), high);
			}
			// else recur for left side
			return countOnes(arr, low, (mid - 1));
		}
		return 0;
	}
}
