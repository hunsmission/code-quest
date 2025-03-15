package codequest.question;

import java.io.IOException;
import java.io.*;
import java.util.*;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. 
M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 
하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

 * */


public class Question6 implements QuestionInterface {

	static int N, M;
	
	@Override
	public void run(String fileName) throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    int[][] map = new int[N][M];
	    
	    // 1. Map에 데이터 저장, 익은 토마토 Queue에 저장
	    Queue<Tomato> queue = new LinkedList<Tomato>();
	    for(int i=0; i<N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0; j<M; j++) {
	    		int status = Integer.parseInt(st.nextToken()); 
	    		map[i][j] = status;
	    		if(status == 1) {
	    			queue.offer(new Tomato(i,j,0));
	    		}	    		
	    	}
	    }
	    
	    // 2. Algorithm - Queue에 저장 된 토마토를 뺀 후 동서남북 토마토가 익지 않은 경우 익은 상태로 변경, day+1
	    int maxDay = 0;
	    int[] dX = {1, -1, 0, 0}; // 동서남북 기준
	    int[] dY = {0, 0, -1, 1};
	    
	    while(!queue.isEmpty()) {
	    	Tomato t = queue.poll();
	    	int nX = t.x;
	    	int nY = t.y;
	    	maxDay = t.day;
	    	
	    	for(int i=0; i<4; i++) {
	    		if((nX + dX[i]) >= N || (nX + dX[i]) < 0 || (nY + dY[i]) >= M || (nY + dY[i]) <0) continue;
	    		if(map[nX+dX[i]][nY+dY[i]] == 0) {
	    			queue.add(new Tomato(nX+dX[i], nY+dY[i], maxDay +1));
	    			map[nX+dX[i]][nY+dY[i]] = 1;
	    		}	    		
	    	}	    	
	    }
	    
	    // 3. Result 
	    boolean completed = true; // true: 토마토가 모두 익은 상태, false: 토마토가 익지 않은 상태
	    for(int i=0; i<N; i++) {	    	
	    	for(int j=0; j<M; j++) {
	    	   if(map[i][j] == 0) {
	    		   completed = false; 
	    	   }
	    	}
	    }
	    
	    if(completed) {
	    	System.out.println(maxDay);
	    }else {
	    	System.out.println(-1);
	    }
		
	}
	
	public class Tomato{
		private int x;
		private int y;
		private int day;
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

}
