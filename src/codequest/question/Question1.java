package codequest.question;

import java.io.BufferedReader;
import java.io.IOException;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

public class Question1 implements QuestionInterface {

	@Override
	public void run(String fileName) throws IOException  {
		BufferedReader br = FileUtils.readFile("test.txt");
		System.out.println(br.readLine());		
	}
}
