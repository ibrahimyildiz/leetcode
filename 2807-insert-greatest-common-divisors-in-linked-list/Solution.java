class Solution {    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val);
            
            ListNode gcdNode = new ListNode(gcdValue);
            
            gcdNode.next = current.next;
            current.next = gcdNode;
            current = gcdNode.next;
        }
        
        return head;
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Create a linked list: 18 -> 24 -> 12
        ListNode head = new ListNode(18);
        head.next = new ListNode(24);
        head.next.next = new ListNode(12);

        ListNode modifiedHead = solution.insertGreatestCommonDivisors(head);
        
        while (modifiedHead != null) {
            System.out.print(modifiedHead.val + " -> ");
            modifiedHead = modifiedHead.next;
        }
        
        System.out.println("null"); // 18 -> 6 -> 24 -> 12 -> 12 -> null
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
