package com.takovh.myAlgorithm.c01_dataStructure.list;

import java.util.HashSet;

public class ListUtils {

    /**
     * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        return null;
    }

    /**
     * 判断给定的链表中是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle0(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null){
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断给定的链表中是否有环
     * 原理:两个人一快一慢往前跑，若有环，快的会追上慢的
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }

    /**
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 拓展：
     * 你能给出不利用额外空间的解法么？
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        return null;
    }
}
