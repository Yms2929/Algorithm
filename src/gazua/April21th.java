package gazua;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class April21th {

	public static void main(String[] args) {
	
		//System.out.println(getSum(123));
	
		//System.out.println(sortDEC(118372));
	
		
	}
	
		

	// ���� ������������ ��ġ�ϱ�
	public static long sortDEC(long n) {
		long answer = 0;
		
		List<Long> list = new ArrayList<>();
		while (n > 0) {
			list.add(n % 10);
			n /= 10;
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i) * Math.pow(10, i);
		}
		
		return answer;
	}
	
	// �ڸ��� ���ϱ�
	public static int getSum(int n) {
		int answer = 0;
		
		while (n > 0) {
			answer += n % 10;
			n /= 10;
		}
		
		return answer;
	}
}