//You are given two non-empty linked lists representing two non-negative integers. 
//给出了两个非空链表，表示两个非负整数。
//The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//数字以倒序存储，每个节点都包含一个数字。添加两个数字并将其作为一个链表返回。
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//你可以假设这两个数字不包含任何前导零，除了数字0本身。
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8


package com.test;

//class ListNode{
//    int val;
//    ListNode nextNode;
//    ListNode(int val){
//        this.val=val;
//        this.nextNode=null;
//    }
//}

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.nextNode;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.nextNode;
            }
            d.nextNode = new ListNode(sum % 10);
            d = d.nextNode;
        }
        if (sum / 10 == 1)
            d.nextNode = new ListNode(1);
        return sentinel.nextNode;
    }
    
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
//    	ListNode l1 = new ListNode(342);
//    	ListNode l2 = new ListNode(465);
//    	
//    	addTwoNumbers add = new addTwoNumbers();
//    	ListNode sol = add.addTwoNumbers(l1,l2);
//    	System.out.println(sol.val);

	}
}