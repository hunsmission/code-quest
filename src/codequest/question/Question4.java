package codequest.question;

import java.util.*;
import java.io.*;
import java.math.*;
import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
Algoritm: 정수 구하기
백준 1929번 소수 구하기

M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

Input 
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

Output
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * */

public class Question4 implements QuestionInterface {

	@Override
	public void run(String fileName) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] result = new int[N+1];
		// Initialize result
		result[1] = 0;
		for(int i=2; i<=N; i++) {
			result[i] = i;
		}
		
		// 순차적으로 각 배수를 지운다.
		for (int i =2; i <= Math.sqrt(N); i++) {
			if(result[i] == 0) continue;
			
			for(int j = i + i; j <= N; j=j+i) {
				result[j] = 0;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(result[i] != 0) System.out.println(result[i]);;
		}
		
	}

}
