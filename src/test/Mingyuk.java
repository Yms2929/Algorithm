package test;

import java.util.HashMap;

public class Mingyuk {

	public static void main(String[] args) {
		String[] names1 = new String[] {"Ava", "Emma", "Olivia", "Moonsu"};
		String[] names2 = new String[] {"Olivia", "Sophia", "Emma", "Sul", "Moonsu"};
		
		System.out.println(String.join(", ", Mingyuk.uniqueNames(names1, names2)));
	}
	
	public static String uniqueNames(String[] names1, String[] names2) {
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<>();
		
		for (int i = 0; i < names1.length; i++) {
			hashMap.put(names1[i], names1[i]);
			sb.append(names1[i]);
			sb.append(", ");
		}
		
		for (int i = 0; i < names2.length; i++) {
			if (hashMap.containsKey(names2[i])) {
				continue;
			}
			else {
				sb.append(names2[i]);
				sb.append(", ");
			}
		}
		
		sb.delete(sb.length() - 2, sb.length());
		
		return sb.toString();
	}

}