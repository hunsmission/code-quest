package codequest.algorithm;

// 피보나치 수열 정의
// F(0) = 0, F(1) = 1
public class DP1 {
	public void run() {
		int n = 5;
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
