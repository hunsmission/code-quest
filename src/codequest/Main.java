package codequest;

import java.util.*;
import java.io.*;

import codequest.algorithm.DP1;
import codequest.algorithm.DP2;
import codequest.algorithm.Permutation1;
import codequest.question.Question5;
import codequest.question.Question6;

public class Main {

	public static void main(String[] args) throws IOException {		
		
		// Coding Test
		Question6 q6 = new Question6();
		q6.run("q6_testcase.txt");
		
		// -- Algorithm
		Permutation1 p1 = new Permutation1();
		p1.run();
	}

}
