package dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class OneWayLinkedList {
    public class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }
    private ListNode head = null;

    public OneWayLinkedList() {
        this.head = null;
    }

    public OneWayLinkedList add(int val){
        if(this.head == null) this.head = new ListNode(val);
        else {
            ListNode end = new ListNode(val);
            ListNode now = this.head;
            while (now.next != null) now = now.next;
            now.next = end;
        }
        return this;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode now = head;
        while (now != null) {
            list.add(now.val);
            now = now.next;
        }
        return list.toString();
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode oldHead = head;

        if(oldHead == null) return head;

        while (oldHead != null){
            ListNode m = oldHead;
            ListNode n = oldHead.next;
            m.next = newHead;
            newHead = m;
            oldHead = n;
        }
        return newHead;
    }

    public static void main(String[] args) {
        OneWayLinkedList list = new OneWayLinkedList();
        list.add(1).add(2).add(3);
        System.out.println(list);
        list.head = list.ReverseList(list.head);
        System.out.println(list);
    }
}
