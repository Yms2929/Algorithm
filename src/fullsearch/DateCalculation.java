package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DateCalculation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken()); // 1 ~ 15
		int S = Integer.parseInt(st.nextToken()); // 1 ~ 28
		int M = Integer.parseInt(st.nextToken()); // 1 ~ 19
		
		int year = 1;
		
		/*while (true) {
			if (E == 1 && S == 1 && M == 1) {
				break;
			}
			
			year++;
			E--;
			S--;
			M--;
			
			if (E < 1) {
				E = 15;
			}
			if (S < 1) {
				S = 28;
			}
			if (M < 1) {
				M = 19;
			}
		}*/
		
		while (true) {
			if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {	
				break;
			}
			year++;
		}
		
		System.out.println(year);
	}

}