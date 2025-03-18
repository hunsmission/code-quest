package codequest.question;

import java.util.*;
import java.io.*;
import java.io.IOException;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
얼마 전 GPT의 실수 비교 방식이 화제가 된 적이 있었다.

질문) "3.9와 3.11 중에 뭐가 더 커?" / 답변) "3.11이 더 큽니다."

수학 시간에 졸지 않은 사람들은 3.9가 3.11보다 크다고 생각하지만, GPT의 눈으로 보면 Python 3.9와 Python 3.11 중 후자를 더 크게 보는 학습 데이터가 많아 저렇게 생각할 수 있다. GPT의 세상에서 3.1은 3보다 크고, 마찬가지로 3.9는 3.2보다 크지만, 3.10은 3.2보다 큰 값으로 처리된다.

구체적으로, 소수점을 기준으로 왼쪽을 수로 읽은 값을 x, 오른쪽을 수로 읽은 값을 y라고 할 때 두 수의 비교가 다음과 같이 이루어진다:

x값이 더 작으면 더 작은 수이다.
x값이 같을 경우 y값이 더 작으면 더 작은 수이다.
소수점이 없는 경우는 같은 수의 소수점이 있는 경우보다 항상 작게 취급된다. (다시 말해, GPT에게 3은 3.0보다 작다.)
N개의 수들이 주어졌을 때, 이를 GPT의 기준에 따라 비내림차순으로 정렬해보자.

제약조건
[문제 제약 조건]

[조건 1] N은 1 이상 1,000 이하이다.

[조건 2] 각 수는 실수 혹은 정수로 표현되고, 0 이상 100 이하이며, 소수점이 없거나 소수점 아래 최대 3자리까지 주어진다.



[서브 태스크별 제약 조건]

별도의 서브 태스크가 존재하지 않습니다.

입력형식
첫 번째 줄에 N이 주어진다.

두 번째 줄부터 N개의 줄에 걸쳐, 각 수가 한 줄에 하나씩 주어진다.

01.23, 3.001과 같이 소수점을 기준으로 각 파트의 0이 아닌 수 이전에 leading zero가 나오는 경우는 주어지지 않는다.

추가로, 3.00, 3.000, 또는 00.1과 같이 소수점을 기준으로 한 파트에 두 개 이상의 0만 주어지는 입력은 없다.

출력형식
첫 번째 줄부터 N개의 줄에 걸쳐, 입력으로 주어진 수들을 GPT의 기준으로 비내림차순으로 정렬한 순서대로 한 줄에 하나씩 출력한다.
 * */

public class Question8 implements QuestionInterface {
	static int N;
	static List<String> list;
	
	@Override
	public void run(String fileName) throws IOException {
		
		// 1. 입력
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<String>();
		for(int i=0 ; i<N; i++) {
			list.add(br.readLine());
		}
		
		// 2. Algorithm
		list.sort((a,b) -> compareGPT(a,b));
		
		// 3. 출력
		for(String str: list) {
			System.out.println(str);
		}
		
	}

	// 왼쪽이 작으면 -1, 같으면 0, 오른쪽이 작으면 1
	private static int compareGPT(String a, String b) {		
		// 소수점 기준으로 나누기
		String[] aParts = a.split("\\.");
		String[] bParts = b.split("\\.");
		
		// 1. 정수 부분 비교
		int x1 = Integer.parseInt(aParts[0]);
		int x2 = Integer.parseInt(bParts[0]);
		if(x1!=x2) return Integer.compare(x1, x2);
		
		// 2. 정수 부분 같고 + 소수점이 없는 경우, 있는 경우보다 항상 작음
	    if(aParts.length == 1 && bParts.length >1) return -1;
	    if(aParts.length >1 && bParts.length ==1) return 1;
	    
	    // 3. 정수 부분 같고 + 소수점 이하 부분 비교(둘다 소수점이 있는 경우)
	    if(aParts.length > 1 && bParts.length > 1) {
	    	int y1 = Integer.parseInt(aParts[1]);
	    	int y2 = Integer.parseInt(bParts[1]);
	    	return Integer.compare(y1, y2);
	    }
		
	    // 4. 같은 경우 
		return 0; 
	}
	

}
