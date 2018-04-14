//package algorithmstudy;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class AgeSort {
//
//	public static void main(String[] args) {
//		List<Person> personList = new ArrayList<Person>();
//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//		int age = 0;
//		String name = " ";
//		
//		for (int i = 0; i < N; i++) {
//			age = scanner.nextInt();
//			name = scanner.next();
//			Person person = new Person(age, name); // 객체 생성
//			personList.add(person); // 리스트에 추가
//		}
//		
//		Collections.sort(personList); // 정렬 함수 호출
//		
//		for (int i = 0; i < personList.size(); i++) {
//			System.out.println(personList.get(i).getAge() + " " + personList.get(i).getName());
//		}
//	}
//	
//}
//
//class Person implements Comparable<Person> {
//	private int age;
//	private String name;
//	
//	public Person(int age, String name) {
//		this.age = age;
//		this.name = name;
//	}
//	
//	public int getAge() {
//		return this.age;
//	}
//	
//	public String getName() {
//		return this.name;
//	}
//
//	@Override
//	public int compareTo(Person person) { // compareTo 메소드 오버라이드해야함 정렬기준을 정하는 것
//		return getAge() - person.age;
//	}
//}