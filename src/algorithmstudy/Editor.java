//package algorithmstudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.StringTokenizer;
//
//public class Editor {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer stringTokenizer;
//		String inputString = bufferedReader.readLine();
//		Cursor cursor = new Cursor(inputString);
//		int N = Integer.parseInt(bufferedReader.readLine());
//
//		for (int i = 0; i < N; i++) {
//			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//			switch (stringTokenizer.nextToken()) {
//			case "L":
//				cursor.cursorL();
//				break;
//			case "D":
//				cursor.cursorD();
//				break;
//			case "B":
//				cursor.cursorB();
//				break;
//			case "P":
//				char word = stringTokenizer.nextToken().charAt(0);
//				cursor.cursorP(word);
//				break;
//			default:
//				break;
//			}
//		}
//		
//		bufferedReader.close();
//		cursor.printString();
//	}
//
//}
//
//class Cursor {
//	private List wordList;
//	private ListIterator<Character> iterator;
//	private int cursorIndex;
//	private char[] wordArray;
//	
//	public Cursor(String inputString) {
//		wordList = new LinkedList<Character>();
//		iterator = wordList.listIterator(wordList.size());
//		wordArray = inputString.toCharArray();
//		initString(wordArray);
//	}
//	
//	public void initString(char[] wordArray) {
//		for (int i = 0; i < wordArray.length; i++) {
//			iterator.add(wordArray[i]);
//		}
//	}
//
//	public void cursorL() {
//		if (iterator.hasPrevious()) {
//			iterator.previous();
//		}
//	}
//
//	public void cursorD() {
//		if (iterator.hasNext()) {
//			iterator.next();
//		}
//	}
//
//	public void cursorB() {
//		if (iterator.hasPrevious()) {
//			iterator.previous();
//			iterator.remove();
//		}
//	}
//
//	public void cursorP(char word) {
//		iterator.add(word);
//	}
//	
//	public void printString() {
//		StringBuilder stringBuilder = new StringBuilder();
//		
//		for (Object c : wordList) {
//			stringBuilder.append(c);
//		}
//		
//		System.out.println(stringBuilder);
//	}
//}