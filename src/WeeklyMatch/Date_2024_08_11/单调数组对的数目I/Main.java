package WeeklyMatch.Date_2024_08_11.单调数组对的数目I;

public class Main {

    public static int countOfPairs(int[] nums) {
        int n = nums.length;
        final int MOD = 1_000_000_007;
        final int MAX = 101; // nums[i] 最大值加1

        // dp[i][j] 表示前 i 个位置中，arr1[i] = j 时符合条件的单调数组对的数目
        long[][] dp = new long[n][MAX];

        // 初始化第一个位置的 dp 值
        for (int j = 0; j <= nums[0]; j++) {
            dp[0][j] = 1;
        }

        // 动态规划填充 dp 数组
        for (int i = 1; i < n; i++) {
            long[] prefixSum = new long[MAX];

            // 计算前缀和
            prefixSum[0] = dp[i-1][0];
            for (int j = 1; j < MAX; j++) {
                prefixSum[j] = (prefixSum[j-1] + dp[i-1][j]) % MOD;
            }

            // 更新 dp[i] 的值
            for (int j = 0; j <= nums[i]; j++) {
                int maxArr2 = nums[i] - j;
                if (maxArr2 >= 0) {
                    dp[i][j] = prefixSum[j];
                }
            }
        }

        // 计算结果
        long result = 0;
        for (int j = 0; j < MAX; j++) {
            result = (result + dp[n-1][j]) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};

        System.out.println(countOfPairs(nums));

    }
}
