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
//			Person person = new Person(age, name); // ��ü ����
//			personList.add(person); // ����Ʈ�� �߰�
//		}
//		
//		Collections.sort(personList); // ���� �Լ� ȣ��
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
//	public int compareTo(Person person) { // compareTo �޼ҵ� �������̵��ؾ��� ���ı����� ���ϴ� ��
//		return getAge() - person.age;
//	}
//}