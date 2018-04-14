package algorithmstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class KoreanEnglishMath {

	public static void main(String[] args) throws IOException {
		List<Person> personList = new ArrayList<Person>();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferReader.readLine());
		String name = "";
		int korean = 0;
		int english = 0;
		int math = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bufferReader.readLine(), " ");
			name = st.nextToken();
			korean = Integer.parseInt(st.nextToken());
			english = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			
			if (0 < name.length() && name.length() <= 10) {
				if (1 <= korean && korean <= 100 && 1 <= english && english <= 100 && 1 <= math && math <= 100) {
					Person person = new Person(name, korean, english, math);
					personList.add(person);
				}
			}
		}
		
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				if (p1.getKorean() < p2.getKorean()) {
					return 1;
				}
				else if (p1.getKorean() == p2.getKorean()) {
					if (p1.getEnglis() > p2.getEnglis()) {
						return 1;
					}
					else if (p1.getEnglis() == p2.getEnglis()) {
						if (p1.getMath() < p2.getMath()) {
							return 1;
						}
						else if (p1.getMath() == p2.getMath()) {
							if (p1.getName().compareTo(p2.getName()) > 0) {
								return 1;
							}
							else {
								return -1;
							}
						}
						else {
							return -1;
						}
					}
					else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}
			
		});
		
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i).getName());
		}
	}

}

class Person {
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public Person(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getKorean() {
		return this.korean;
	}
	
	public int getEnglis() {
		return this.english;
	}
	
	public int getMath() {
		return this.math;
	}
}