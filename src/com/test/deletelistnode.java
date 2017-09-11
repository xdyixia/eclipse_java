package com.test;

class ListNode{
    int val;
    ListNode nextNode;
    ListNode(int val){
        this.val=val;
        this.nextNode=null;
    }
}
public class deletelistnode {

    static ListNode head=null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input=new int[]{1,2,3,3,4,4,5};
        ListNode listNode=buildListNode(input);
        head=listNode;
        while(listNode!=null){
            System.out.println("val"+listNode.val+"/listNode"+listNode.nextNode);
            listNode=listNode.nextNode;
        }
        head=removeElements(head,3);
        listNode=head;
        while(listNode!=null){
            System.out.println("val"+listNode.val+"/listNode"+listNode.nextNode);
            listNode=listNode.nextNode;
        }

    }
    private static ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        int num;
        if(input.length>0){
            for(int i=0;i<input.length;i++){
                newNode=new ListNode(input[i]);
                newNode.nextNode=null;
                if(first==null){
                    first=newNode;
                    last=newNode;
                }
                else{
                    last.nextNode=newNode;
                    last=newNode;
                }

            }
        }
        return first;
    }
    private static ListNode removeElements(ListNode head,int val){
        if(head==null){
            return null;
        }
        ListNode p=head,q=head.nextNode;
        while(q!=null){
            if(q.val==val){
                p.nextNode=q.nextNode;
                q=q.nextNode;
            }else{
                p=p.nextNode;
                q=q.nextNode;
            }
        }
        if(head.val==val){
            return head.nextNode;
        }
        return head;

    }

}