package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드 개수
		int[] card = new int[N]; // 카드들의 숫자
		//HashSet<Integer> set = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			//set.add(Integer.parseInt(st.nextToken()));
		}
		
		/*int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) {
				System.out.print(1);
			}
			else {
				System.out.print(0);
			}
			System.out.print(" ");
		}*/
		
		Arrays.sort(card); // -10 2 3 6 10
		
		int M = Integer.parseInt(br.readLine()); // 확인할 숫자 카드 개수
		int[] number = new int[M]; // 카드들의 숫자
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			int result = 0;
			int max = N;
			int min = 0;
			int middle = 0;
			
			while (max > min + 1) {
				middle = (max + min) / 2;
				
				if (number[i] == card[0]) {
					result = 1;
					break;
				}
				if (number[i] == card[middle]) {
					result = 1;
					break;
				}
				else if (number[i] > card[middle]) {
					min = middle;
				}
				else if (number[i] < card[middle]) {
					max = middle;
				}
			}
			
			System.out.print(result + " ");
		}
	}

}