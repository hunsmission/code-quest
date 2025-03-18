package codequest.question;

import java.util.*;
import java.io.*;
import java.io.IOException;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

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
