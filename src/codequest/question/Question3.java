package codequest.question;

import java.io.*;
import java.util.*;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
Algorithm: 그리디 알고리즘
백준 1541번 잃어버린 괄호

세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

Input 
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 
Output
첫째 줄에 정답을 출력한다.

 */

public class Question3 implements QuestionInterface {

	@Override
	public void run(String fileName) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		
		
		// Solution -> '-' 로 Split 해서 전부 더한 후에 연산을 진행한다.
		String[] expression = br.readLine().split("-");
		
		int answer = sum(expression[0]);
		for(int i=1; i < expression.length; i++) {
			answer -= sum(expression[i]);
		}	
		
		System.out.println(answer);
		
	}
	
	public Integer sum(String str) {
		String[] nums = str.split("\\+");
		int sum = 0;
		for(String num : nums) {
			sum += Integer.parseInt(num);
		}
		
		return sum;
	}

}
