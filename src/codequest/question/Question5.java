package codequest.question;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
 * 문제 배열 A가 주어졌을 때, N번째 큰 값을 출력하는 프로그램을 작성하시오. 배열 A의 크기는 항상 10이고, 자연수만 가지고 있다. N은 항상 3이다.
 * 
 * 입력 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 배열 A의 원소 10개가 공백으로 구분되어 주어진다. 이 원소는 1보다 크거나 같고, 1,000보다 작거나 같은 자연수이다.
 * 
 * 출력 각 테스트 케이스에 대해 한 줄에 하나씩 배열 A에서 3번째 큰 값을 출력한다.
 * 
4 
1 2 3 4 5 6 7 8 9 1000 
338 304 619 95 343 496 489 116 98 127 
931 240 986 894 826 640 965 833 136 138 
940 955 364 188 133 254 501 122 768 408
 */
public class Question5 implements QuestionInterface {

	@Override
	public void run(String fileName) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		int N = Integer.valueOf(br.readLine());

		HashMap<Integer, int[]> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] array = new int[11];
			for (int j = 1; j < 11; j++) {
				array[j] = Integer.parseInt(st.nextToken());
			}
			map.put(i, array);
		}
		int[] result = new int[N + 1];
		// 세번째로 큰 값 구하기
		for (int i = 1; i <= N; i++) {
			int[] array = map.get(i);
			for (int cnt = 1; cnt <= 3; cnt++) {
				int MAX_VALUE = Integer.MIN_VALUE;
				int maxIdx = 0;
				for (int idx = 1; idx <= 10; idx++) {
					if (MAX_VALUE < array[idx]) {
						maxIdx = idx;
						MAX_VALUE = array[idx];
					}
				}
				if (cnt != 3) {
					array[maxIdx] = 0;
				} else {
					result[i] = array[maxIdx];
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

}
