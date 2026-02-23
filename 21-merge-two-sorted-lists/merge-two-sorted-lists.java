
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle cases where one of the lists is empty
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Determine the starting node of the merged list
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        // 'curr' will be used to stitch the lists together
        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer forward
            curr = curr.next;
        }

        // If one list is exhausted, attach the remainder of the other
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return head;
    }
}