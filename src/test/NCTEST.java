package test;

import java.util.HashMap;

public class NCTEST {

	public static void main(String[] args) {
		/*int[] arr = new int[] {
				4, 1, 3
		};
		
		System.out.println(solution(arr));*/
		
		/*String[] bakery_schedule = {"09:05 10", "12:20 5","13:25 6","14:24 5"};
		String current_time = "12:05";
		int K = 10;
		
		System.out.println(solution(bakery_schedule, current_time, K));*/
		
		int[][] board = new int[][] {
			{1,1,3,3},
			{4,1,3,4},
			{1,2,1,1},
			{2,1,3,2}
		};
		
		System.out.println(solution(board));
	}
	
	public static int solution(int[][] board) {
		int answer = 0;
		int max = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {		
				if (max < getScore(board, new Point(i,j))) {
					answer = max;
				}
			}
		}
		
		return answer;
	}	
	
	public static int getScore(int[][] board, Point hammer) {
		int score = 0;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		int candy = 0;
		boolean next = true;
		
		while (next) {
			score++;
			int count = 0;
			
			for (int i = hammer.x; i < board.length; i++) {
				board[hammer.x - i + 2][hammer.y] = board[hammer.x - i + 1][hammer.y];
			}
			
			candy = board[hammer.x][hammer.y];
			
			for (int i = board.length - 1; i > 0; i--) {
				if (board[i][hammer.y] == candy) {
					count++;
				}
			}
			
			if (count >= 3) {
				score += count;
				
				for (int j = board.length - 1; j > 0; j--) {
					board[j][hammer.y] = 0;
				}
			}
		}	
		
		return score;
	}
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	/*public static int solution(String[] bakery_schedule, String current_time, int K) {
        int answer = 0;
        int totalBakery = 0;
        
        for (int i = 0; i < bakery_schedule.length; i++) { 	
        	String[] bakeryInfo = bakery_schedule[i].split(" ");
        	String bakeryTime = bakeryInfo[0]; // 12:00
        	int bakeryNumber = Integer.parseInt(bakeryInfo[1]); // 10
        	
        	int bakeryHour = Integer.parseInt(bakeryTime.substring(0, 2));
    		int bakeryMinute = Integer.parseInt(bakeryTime.substring(3));
    		int currentHour = Integer.parseInt(current_time.substring(0, 2));
    		int currentMinute = Integer.parseInt(current_time.substring(3));
    		
    		if (bakeryHour == currentHour) {
    			if (bakeryMinute >= currentMinute) {
    				totalBakery += bakeryNumber; // 5
    				
    				if (totalBakery < K) {
    					answer += bakeryMinute - currentMinute; // 15
    				}
    				else if (totalBakery == K) {
    					answer = 0;
    				}
    				else {
    					answer = -1;
        				break;
    				}
    			}
    		}
    		else if (bakeryHour < currentHour) {
    			continue;
    		}
    		else {
    			answer = 0;
    			totalBakery += bakeryNumber;
    			answer += (bakeryHour - currentHour) * 60 + bakeryMinute - currentMinute;
    			if (totalBakery > K) {
    				break;
    			}
    		}      		      	
        }
        
        if (totalBakery < K) {
        	answer = -1;
        }
        
        return answer;
    }*/

	/*public static boolean solution(int[] arr) {
		boolean answer = true;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			hashMap.put(arr[i], arr[i]);
		}
		
		for (int i = 0; i < n; i++) {
			if (!hashMap.containsKey(i + 1)) {
				answer = false;
				break;
			}
			else {
				answer = true;
			}
		}

		return answer;
	}*/
}
