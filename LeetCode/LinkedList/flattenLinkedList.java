public class Solution {

    // Time Complexity -> O(N)
    // Space Complexity -> O(1)
    public static Node flattenLinkedList(Node head) {
        if( head == null || head.next == null ){
            return head;
        }

        Node mergehead = flattenLinkedList(head.next);
        return mergelist(head, mergehead);
    }

    private static Node mergelist(Node list1, Node list2){
        Node dummy = new Node(0);
        Node res = dummy;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                res.child = list1;
                res = list1;
                list1 = list1.child;
            }else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
        }
        if(list1 != null){
            res.child = list1;
        }
        else{
            res.child = list2;
        }
        return dummy.child;

    }