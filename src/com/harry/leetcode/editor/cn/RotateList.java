//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 606 👎 0


package com.harry.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotateList {
	public static void main(String[] args) {
		Solution solution = new RotateList().new Solution();
		// Debug here --
		ListNode head = new ListNode(1,
							new ListNode(2,
								new ListNode(3,
									new ListNode(4,
											new ListNode(5)))));
		ListNode d = solution.rotateRight(head, 2);
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			if (k == 0 || head == null || head.next == null) return head;
			int n = 1;
			ListNode iter = head;
			while (iter.next != null) {
				++n;
				iter = iter.next;
			}
			int add = n - k % n;
			if (add == n) {
				return head;
			}
			iter.next = head;
			while (add-- > 0) {
				iter = iter.next;
			}
			ListNode ret = iter.next;
			iter.next = null;
			return ret;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}