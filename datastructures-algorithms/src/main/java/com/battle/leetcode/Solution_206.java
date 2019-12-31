package com.battle.leetcode;

/**
 * 206
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */
public class Solution_206 {

    public static void main(String[] args) {

    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(n)O(n)，假设 nn 是列表的长度，时间复杂度是 O(n)O(n)。
     * 空间复杂度：O(1)O(1)。
     * @param head
     * @return
     */
    public ListNode reverseList_1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    public ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList_1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 双指针迭代
     * 我们可以申请两个指针，第一个指针叫pre，最初是指向null的。
     * 第二个指针cur指向head，然后不断遍历cur。
     * 每次迭代到cur，都将cur的next指向pre，然后pre和cur前进一位。
     * 都迭代完了(cur变成null了)，pre就是最后一个节点了。
     * 动画演示如下：
     *
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public class ListNode {
        ListNode data;
        ListNode next;
    }
}
