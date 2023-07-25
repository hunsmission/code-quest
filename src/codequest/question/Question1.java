package codequest.question;

import java.io.*;
import java.util.*;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
백준 11659번
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N

총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 * */
public class Question1 implements QuestionInterface {

	static int N;
	static int M;

	@Override
	public void run(String fileName) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		BufferedReader br = FileUtils.readFile(fileName);

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 값을 저장 할 배열
		int[] data = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		data[0] = 0;
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		// 각 구간의 합을 저장할 배열
		int[] sum = new int[N + 1];
		int total = 0;
		sum[0] = 0;

		for (int i = 1; i <= N; i++) {
			total += data[i];
			sum[i] = total;
		}

		// 각 구간의 합 구하기
		// ex) 2, 4의 경우 sum[1] =5 , sum[4] = 14 -> sum[4] - sum[1] = 9		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());			
			System.out.println(sum[last] - sum[first-1]);
		}
		
	}
}
