import java.util.HashSet;

class Solution {
    public ListNode removeElements(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {
            if (set.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        
        // 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        int[] nums = {6, 3};

        ListNode modifiedHead = solution.removeElements(head, nums);

        ListNode current = modifiedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // 1 2 4 5 
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
