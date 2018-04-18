//package algorithmstudy;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.lang.reflect.Array;
//import java.util.Random;
//import java.util.StringTokenizer;
//
//public class KthNumber {
//	static int answer = 0;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		int[] number = new int[N];
//		
//		st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			number[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		quickSort(number, 0, number.length - 1, K);
//		System.out.println(answer);
//		
////		System.out.println(quickSelection(number, 0, number.length - 1, K-1));
////		bw.write(String.valueOf(quickSelection(number, 0, number.length - 1, K-1)));
//		
//		br.close();
//		bw.close();
//	}
//	
//	public static void quickSort(int[] array, int low, int high, int K) {
//		if (low < high) {
//			long pivot = array[high];
//			int left = low - 1;
//			int right = high;
//			
//			while (true) {
//				while (array[++left] < pivot);
//				while (right > low && array[--right] > pivot);
//				
//				if (left >= right) break;
//				swap(array, left, right);
//			}
//			
//			swap(array, left, high);
//			
//			if (left > K - 1) {
//				quickSort(array, low, left - 1, K);
//			} else if (left < K - 1) {
//				quickSort(array, left + 1, high, K);
//			} else {
//				 answer = array[left];
//			}
//		}
//		else if (low == high && low == K - 1) {
//			answer = array[low];
//		}
//	}
//	
////	public static int quickSelection(int[] array, int start, int end, int K) {
////		if (start < end) {
////			int pivot = partition(array, start, end);
////			
////			if (pivot == K) {
////				return array[pivot];
////			}
////			else if (pivot > K) { // K가 피벗보다 작으면
////				return quickSelection(array, start, pivot-1, K); // 왼쪽 탐색
////			}
////			else { // K가 피벗보다 크면 
////				return quickSelection(array, pivot+1, end, K); // 오른쪽 탐색
////			}
////		}
////		
////		return Integer.MIN_VALUE;
////	}
////	
////	public static int partition(int[] array, int start, int end) {
////		int pivot = start + new Random().nextInt(end - start + 1); // start에서 end까지 범위 난수 생성
////		swap(array, end, pivot);
////
////		int i = start - 1;
////		
////		for (int j = start; j < end; j++) {
////			if (array[j] < array[end]) {
////				i++;
////				swap(array, i, j);
////			}
////		}
////		swap(array, i+1, end);
//// 		
////		return i + 1;
////	}
//
//	public static void swap(int[] array, int a, int b) { // 자리 바꾸기
//		int temp = array[a];
//		array[a] = array[b];
//		array[b] = temp;
//	}
//}