package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepeatSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int temp = 0;
		int index = 0;
		boolean[] visited = new boolean[236197];
		int[] numbers = new int[236197];
				
		while (true) {
			if (visited[A]) {
				break;
			}
			
			visited[A] = true;
			temp = 0;
			numbers[index] = A;
			index++;
			
			while (A > 0) {
				temp += Math.pow((A % 10), P);
				A /= 10;
			}
			
			A = temp;
			//System.out.print(numbers[index-1] + " ");
		}
	
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == A) {
				System.out.println(i);
				break;
			}
		}
	}

}