//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 
// 👍 684 👎 0


package com.harry.leetcode.editor.cn;

import java.util.Stack;

public class RemoveDuplicatesFromSortedListIi {
	public static void main(String[] args) {
		//Solution solution = new Solution();
		// Debug here --

	}
	//leetcode submit region begin(Prohibit modification and deletion)

	//Definition for singly-linked list.
	public class ListNode {
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
		public ListNode deleteDuplicates(ListNode head) {
			// 头节点为空 或者 头节点 next 为空，都不需要继续
			// base case
			if (head == null || head.next == null) return head;
			// 不等 则直接递归
			if (head.val != head.next.val) {
				head.next = deleteDuplicates(head.next);
			} else { // 相等 则需要一直找到不等的节点 并进行递归
				ListNode dummy = head.next;
				while (dummy.next != null && dummy.val == dummy.next.val) {
					dummy = dummy.next;
				}
				head.next = deleteDuplicates(dummy.next);
			}
			// 完美
			return head;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}