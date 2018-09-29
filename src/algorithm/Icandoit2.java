/**
 * 
 */
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Yookmoonsu
 *
 */
public class Icandoit2 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			final int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
				String method = tokenizer.nextToken();
				String url = tokenizer.nextToken();
				String body = null;
				if (tokenizer.hasMoreTokens()) {
					body = tokenizer.nextToken();
				}
				
				System.out.println(method + url + body);
				
				/*switch (method) {
				case "POST":
					
					break;
				case "GET":
					
					break;
					default:
						break;
				}*/
			}
		}
	}

}
