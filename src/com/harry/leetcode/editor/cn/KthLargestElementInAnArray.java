//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1216 👎 0


package com.harry.leetcode.editor.cn;
public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		Solution solution = new KthLargestElementInAnArray().new Solution();
		// Debug here --

	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		// 两种方法
		//一种用最大堆，另一种是利用快排中的分区
		public int findKthLargest(int[] nums, int k) {
//			int n = nums.length;
//			if (n < k) return -1;
//			int partition = partition(nums, 0, n - 1);
//			while (partition + 1 != k) {
//				if (partition + 1 < k) {
//					partition = partition(nums, partition + 1, n - 1);
//				} else {
//					partition = partition(nums, 0, partition - 1);
//				}
//			}
//			return nums[partition];

			int heapSize = nums.length;
			buildMaxHeap(nums, heapSize);
			for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
				swap(nums, 0, i);
				--heapSize;
				maxHeapify(nums, 0, heapSize);
			}
			return nums[0];
		}

		private void buildMaxHeap(int[] a, int heapSize) {
			for (int i = heapSize >> 1; i >= 0; --i) {
				maxHeapify(a, i, heapSize);
			}
		}

		private void maxHeapify(int[] a, int i, int heapSize) {
			int l = (i << 1) + 1, r = (i << 1) + 2, largest = i;
			if (l < heapSize && a[l] > a[largest]) largest = l;
			if (r < heapSize && a[r] > a[largest]) largest = r;
			if (largest != i) {
				swap(a, i, largest);
				maxHeapify(a, largest, heapSize);
			}
		}

//		private int partition(int[] nums, int l, int r) {
//			int pivot = nums[r];
//			int i = l;
//			for (int j = l; j < r; ++j) {
//				if (nums[j] >= pivot) {
//					swap(nums, i, j);
//					++i;
//				}
//			}
//			swap(nums, i, r);
//			return i;
//		}

		private void swap(int[] nums, int l, int r) {
			if (l == r) return;
			int tmp = nums[l];
			nums[l] = nums[r];
			nums[r] = tmp;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}