/***********************************************************************************************************

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


**************************************************************************/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = null;
        
        if(list1==null && list2!=null) {
            return list2;
        }
        else if(list2==null && list1!=null) {
            return list1;
        }
        else if(list1==null && list2==null) return null;
        
        else {
            ListNode tmp;
            if(list1.val >= list2.val) {
                head = list2;
                list2 = list2.next;
            }
            else {
                head = list1;
                list1 = list1.next;
            }
            tmp = head;
            while(list1!=null && list2!=null) {
                int a = list1.val, b = list2.val;
                if(a>=b) {
                    tmp.next = list2;
                    list2 = list2.next;
                    tmp = tmp.next;
                }
                else if(a<b) {
                    tmp.next = list1;
                    list1 = list1.next;
                    tmp = tmp.next;
                }
            }
            
            if(list1!=null) {
                while(list1!=null) {
                    tmp.next = list1;
                    list1 = list1.next;
                    tmp = tmp.next;
                }
            }
            if(list2!=null) {
                while(list2!=null) {
                    tmp.next = list2;
                    list2 = list2.next;
                    tmp = tmp.next;
                }
            }
            
        }
        
        return head;
        
    }
}


/**

Runtime: 1 ms, faster than 80.06% of Java online submissions for Merge Two Sorted Lists.
Memory Usage: 42.4 MB, less than 82.03% of Java online submissions for Merge Two Sorted Lists.

**/
