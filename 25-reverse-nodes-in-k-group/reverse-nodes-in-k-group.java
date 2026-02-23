class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack=new Stack<>();
        ListNode thead=head;
        ListNode nhead=new ListNode(0);
        ListNode ans=nhead;
        int rev=k;
        while(thead!=null){
            ListNode prev=thead;
            while(rev-->0&&thead!=null){
                stack.push(thead);
                thead=thead.next;
            }
            if(stack.size()!=k){
                nhead.next=prev;
                return ans.next;
            }
            rev=k;
            while(!stack.isEmpty()){
                nhead.next=stack.pop();
                nhead=nhead.next;
            }
            nhead.next=thead;
        }
        return ans.next;
    }
}