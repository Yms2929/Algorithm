//package algorithmstudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class AscentNumber {
//
//	public static void main(String[] args) throws IOException {
//		Scanner scanner = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		int N = 0;
//		int x, y = 0;
//		ArrayList<Double> scoreBrown = new ArrayList<Double>();
//		ArrayList<Double> scoreCony = new ArrayList<Double>();
//		int resultScore[] = new int[T];
//		String resultTeam[] = new String[T];
//		String teamName = "";
//		int score = 0;
//				
//		if (1 <= T && T <= 50) {
//			for (int i = 0; i < T; i++) {
//				N = Integer.parseInt(br.readLine());
//				
//				if (2 <= N && N <= 1000) {
//					for (int j = 0; j < N; j++) {
//						String input = br.readLine();
//						StringTokenizer st = new StringTokenizer(input);
//						x = Integer.parseInt(st.nextToken());
//						y = Integer.parseInt(st.nextToken());
//						String team = st.nextToken();
//					
//						if (team.equals("Brown")) {
//							scoreBrown.add(getDistance(0,0,x,y));	
//						}
//						else if (team.equals("Cony")) {
//							scoreCony.add(getDistance(0,0,x,y));
//						}
//					}
//					
//					Ascending ascending = new Ascending();
//					Collections.sort(scoreBrown, ascending);
//					Collections.sort(scoreCony, ascending);
//			
//					if (scoreBrown.get(0) < scoreCony.get(0)) {
//						teamName = "Brown";
//						
//						for (int j = 0; j < scoreBrown.size(); j++) {
//							if (scoreBrown.get(j) < scoreCony.get(0)) {
//								score++;
//							}
//						}
//						resultScore[i] = score;
//						resultTeam[i] = teamName;
//					}
//					else if (scoreBrown.get(0) > scoreCony.get(0)) {
//						 teamName = "Cony";
//						
//						for (int j = 0; j < scoreCony.size(); j++) {
//							if (scoreBrown.get(0) > scoreCony.get(j)) {
//								score++;
//							}
//						}
//						resultScore[i] = score;
//						resultTeam[i] = teamName;
//					}
//					
//					score = 0;
//					teamName = "";
//					scoreBrown.clear();
//					scoreCony.clear();
//				}
//			}	
//			
//			for (int i = 0; i < T; i++) {
//				System.out.println(resultTeam[i] + " " + resultScore[i]);
//			}
//		}	
//	}
//	
//	public static double getDistance(int x1, int y1, int x2, int y2) {
//		return Math.sqrt(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
//	}
//
//}
//
//class Ascending implements Comparator<Double> {
//
//	@Override
//	public int compare(Double arg0, Double arg1) {
//		// TODO Auto-generated method stub
//		return arg0.compareTo(arg1);
//	}
//	
//}