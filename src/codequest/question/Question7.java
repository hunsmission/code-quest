package codequest.question;

import java.util.*;
import java.io.*;

import codequest.inf.QuestionInterface;
import codequest.utils.FileUtils;

/*
 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 
 입력: 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 출력: 첫째 줄에 지나야 하는 최소 칸수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 출력한다.
 * */
public class Question7 implements QuestionInterface {
   
	static int N, M;
	static Queue<Miro> queue;
	@Override
	public void run(String fileName) throws IOException {
		
		// 1. Input
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = FileUtils.readFile(fileName);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];		
		boolean[][] visited = new boolean[N+1][M+1];
		String str;
		for(int i=1; i<=N; i++) {			
			str = br.readLine();
			for(int j=1; j<=M; j++) {				
				map[i][j] = Character.getNumericValue(str.charAt(j-1));				
			}
		}
		
		// 2. Algorithm 1,1 부터 시작해서 근접해있는 칸이 1일때 Queue에 저장 + result map에 Count 저장		
		int[][] resultMap = new int[N+1][M+1];
        queue = new LinkedList<Miro>();
        queue.offer(new Miro(1,1,1));
        resultMap[1][1] = 1;
        visited[1][1] = true; 
		// 좌표 이동 (상하좌우)
		int[] dX = {0,0,-1,1};
		int[] dY = {1,-1,0,0};
		
		while(!queue.isEmpty()) {
			Miro tmp = queue.poll();
			for(int i=0; i<4; i++) {
				int tmpX = tmp.x + dX[i];
				int tmpY = tmp.y + dY[i];
				int tmpCnt = tmp.cnt;
				if(tmpX <=0 || tmpX>N || tmpY<=0 || tmpY>M) {
					continue;					
				}
				
				if(map[tmpX][tmpY] == 1 && !visited[tmpX][tmpY]) {
					queue.offer(new Miro(tmpX, tmpY, tmpCnt+1));
					resultMap[tmpX][tmpY] = tmpCnt + 1; 
					visited[tmpX][tmpY] = true;
				}				
			}
		}
		
		// 3. 결과 출력
	    System.out.print(resultMap[N][M]);
		
	}
	
	// Miro 좌표를 위한 Inner Class
	public class Miro{
		int x;
		int y;
		int cnt;
		public Miro(int x, int y, int cnt) { 
			this.x = x; 
			this.y = y;
			this.cnt = cnt;
		}
	}

}
