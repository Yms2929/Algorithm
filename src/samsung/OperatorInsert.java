package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class OperatorInsert {
	static int N;
	static int[] number;
	static int[] operation;
	static int sum;
	static List<Integer> list = new ArrayList<>();
	static char[] temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operation = new int[4]; // + - * /
		temp = new char[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
	
		st = new StringTokenizer(br.readLine());
		int index = 0;
		while (st.hasMoreTokens()) {
			operation[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		
		DFS(1, number[0]);
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	public static void DFS(int index, int sum) {
		for (int i = 0; i < 4; i++) {
			if (operation[i] != 0) {
				operation[i]--;
				
				switch (i) {
				case 0:
					temp[index - 1] = '+';
					DFS(index + 1, sum + number[index]);
					break;
				case 1:
					temp[index - 1] = '-';
					DFS(index + 1, sum - number[index]);
					break;
				case 2:
					temp[index - 1] = '*';
					DFS(index + 1, sum * number[index]);
					break;
				case 3:
					temp[index - 1] = '/';
					DFS(index + 1, sum / number[index]);
					break;
				}
				
				temp[index] = 0;
				operation[i]++;
			}
		}
		
		if (index == N) {
			/*for (int i = 0; i < N; i++) {
				System.out.print(number[i] + " ");
				System.out.print(temp[i] + " ");
			}
			System.out.print("= " + sum);
			System.out.println();*/
			
			list.add(sum);
		}
	}
}