package codequest;

import java.io.IOException;

import codequest.question.Question1;

public class Main {

	public static void main(String[] args) throws IOException {		
		Question1 q1 = new Question1();
		q1.run("test.txt");
	}

}
