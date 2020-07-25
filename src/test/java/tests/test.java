package tests;

public class test {

		public static void main(String[] args) {
			int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

			System.out.println(maxSubArray(nums));

		}

		public static int maxSubArray(int[] nums) {
			int a1;
			int a2 = 0;
			int maxSubArray1 = 0;
			int maxSubArray2 = 0;
			int maxSubArray3 = 0;

			for (a1 = 0; a1 < nums.length; a1++) {
				maxSubArray1 = 0;
				for (a2 = a1; a2 < nums.length; a2++) {
					if (maxSubArray3 > maxSubArray1 + nums[a2]) {
						maxSubArray1 = maxSubArray1 + nums[a2];
						continue;
					}
					maxSubArray1 = maxSubArray1 + nums[a2];
					maxSubArray3 = maxSubArray1;
					if (maxSubArray3 > maxSubArray2) {
						maxSubArray2 = maxSubArray3;
					}
				}


			}
			return maxSubArray2;
		}

	}

