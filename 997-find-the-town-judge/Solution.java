class Solution {
    public static int findJudge(int n, int[][] trust) {
        int[] judge = new int[n+1];
        int[] people = new int[n+1];

        for (int i = 0; i < trust.length; i++) {
            people[trust[i][0]]++; 
            judge[trust[i][1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if(people[i] == 0 && judge[i] == n-1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        int result = Solution.findJudge(n, trust);
        System.out.println(result); // 3
    }

}