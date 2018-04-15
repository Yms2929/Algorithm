//package algorithmstudy;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//
//public class NumberSortThree {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int N = Integer.parseInt(br.readLine());
//		int number[] = new int[N];
//		
//		for (int i = 0; i < N; i++) {
//			number[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(number);
//		
//		for (int i = 0; i < N; i++) {
//			bw.write(Integer.toString(number[i]));
//			bw.write("\n");
//		}
//		br.close();
//		bw.close();
//	}
//
//}