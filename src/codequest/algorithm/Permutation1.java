package codequest.algorithm;

import java.util.Arrays;

// 순서를 고려하면서 서로 다른 n개에서 중복 없이 r개를 일렬로 나열하는 수이다.
// 경우의 수는 nPr = n! / (n-r)! 로 시간 복잡도는 O(n!) 이 소요된다.

public class Permutation1 {
	static int N = 4, R = 3;
	static int[] arr = {1,2,3,4}; // n에 해당하는 배열
	static int[] output;           // r개를 뽑은 배열
	static boolean[] visited;
	public void run() {
		output = new int[R]; // R개를 뽑은 배열 초기화
		visited = new boolean[N];
		// -- permutation
		System.out.println("----------- 순열 -----------------");
		permutation(0, N, R);
		
		// -- repeat permutation 중복순열
		System.out.println("----------- 중복 순열 -----------------");
		repeatPermutation(0,N,R);
		
		// -- Combination 조합
		System.out.println("------------ 조합 ----------------");
		combination(0, 0, N, R);
		
	}
	
	// 순열
	public static void permutation(int depth, int n, int r) {
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i = 0; i<n; i++ ) {
			// 방문하지 않은 값이면 넣기
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i]; // 현재 Depth를 인덱스로 사용
				permutation(depth +1, n, r);
				visited[i] = false; // 다음 순열을 뽑기 위해 방문처리 제거 
			}		
		}
	}
	
	// 중복 순열
	public static void repeatPermutation(int depth, int n , int r) {
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i = 0; i<n; i++ ) {
			output[depth] = arr[i];
			repeatPermutation(depth+1, n, r);
		}
		
	}
	
	// -- 조합
	public static void combination(int start, int depth, int n , int r) {
		if(depth == r) {
			System.out.println(Arrays.toString(output));
			return;
		}
		
		for(int i=start; i<n; i++) {
			output[depth] = arr[i];
			combination(i+1, depth+1, n, r);
		}
		
	}
	
}
