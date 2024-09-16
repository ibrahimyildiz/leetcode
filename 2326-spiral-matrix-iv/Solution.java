public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode current = head;

        while (current != null) {
            // left to right
            for (int j = left; j <= right && current != null; j++) {
                matrix[top][j] = current.val;
                current = current.next;
            }
            top++;

            // top to bottom
            for (int i = top; i <= bottom && current != null; i++) {
                matrix[i][right] = current.val;
                current = current.next;
            }
            right--;

            // right to left
            for (int j = right; j >= left && current != null; j--) {
                matrix[bottom][j] = current.val;
                current = current.next;
            }
            bottom--;

            // bottom to top
            for (int i = bottom; i >= top && current != null; i--) {
                matrix[i][left] = current.val;
                current = current.next;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int m = 3;
        int n = 4;

        Solution solution = new Solution();
        int[][] result = solution.spiralMatrix(m, n, head);

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();

            /*
                1 2 3 4 
                10 -1 -1 5 
                9 8 7 6 
            */
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
