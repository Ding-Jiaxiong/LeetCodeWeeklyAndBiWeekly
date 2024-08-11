package WeeklyMatch.Date_2024_08_11.单调数组对的数目II;

public class Main {

    private static final int mod = 1_000_000_007;

    public static int countOfPairs(int[] nums) {
        int[] dp = new int[1001];
        boolean isFirst = true;
        int last = -1;
        for (int n : nums) {
            int[] nextDp = new int[n + 1];
            if (isFirst) {
                for (int i = 0; i <= n; ++i) {
                    nextDp[i] = 1;
                }
            } else {
                int sum = 0, st = 0;
                for (int i = 0; i <= n; ++i) {
                    int curArr2 = n - i;
                    while (st <= Math.min(i, last) && last - st >= curArr2) {
                        sum = (sum + dp[st]) % mod;
                        ++st;
                    }
                    nextDp[i] = sum;
                }
            }
            isFirst = false;
            dp = nextDp;
            last = n;
        }
        int res = 0;
        for (int n : dp) {
            res = (res + n) % mod;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 2};

        System.out.println(countOfPairs(nums));

    }
}
