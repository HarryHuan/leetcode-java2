//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 
// 👍 627 👎 0


package com.harry.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedList{
	public static void main(String[] args){
		Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
		// Debug here --

	}
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.*/
 public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
            head = deleteDuplicates(dummy.next);
        }
        // 完美
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}