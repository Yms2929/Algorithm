package fullsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[10001];

			String result = BFS(A, B, visited);
			System.out.println(result);
		}
		
		br.close();
	}

	public static String BFS(int start, int end, boolean[] visited) {
		Queue<Register> queue = new LinkedList<>();
		StringBuilder sb = null;
		String[] order = {"D", "S", "L", "R"};
		int[] next = new int[4]; // 4가지 경우의 수
		
		queue.add(new Register(start, ""));
		visited[start] = true;

		/*while (!queue.isEmpty()) {
			Register register = queue.poll();
			
			if (register.getNum() == end) {
				return register.getCommand();
			}
			
			for (int i = 0; i < 4; i++) {
				next[i] = setOrder(register.getNum(), order[i]);
			}	
			
			for (int i = 0; i < 4; i++) {
				if (!visited[next[i]]) {
					visited[next[i]] = true;
					sb = new StringBuilder(register.getCommand());
					sb.append(order[i]);
					queue.add(new Register(next[i], sb.toString()));
				}
			}
		}*/
		
        while (!queue.isEmpty()) {
            Register register = queue.poll();
            if (register.getNum() == end) {
                return register.getCommand();
            }

            if (!visited[commandD(register.getNum())]) {
                int num = commandD(register.getNum());
                visited[num] = true;
                StringBuilder commands = new StringBuilder(register.getCommand());
                queue.offer(new Register(num, commands.append("D").toString()));
            }

            if (!visited[commandS(register.getNum())]) {
                int num = commandS(register.getNum());
                visited[num] = true;
                StringBuilder commands = new StringBuilder(register.getCommand());
                queue.offer(new Register(num, commands.append("S").toString()));
            }

            if (!visited[commandL(register.getNum())]) {
                int num = commandL(register.getNum());
                visited[num] = true;
                StringBuilder commands = new StringBuilder(register.getCommand());
                queue.offer(new Register(num, commands.append("L").toString()));
            }

            if (!visited[commandR(register.getNum())]) {
                int num = commandR(register.getNum());
                visited[num] = true;
                StringBuilder commands = new StringBuilder(register.getCommand());
                queue.offer(new Register(num, commands.append("R").toString()));
            }
        }

		return sb.toString();
	}
	
	public static int commandD(int n) {
        return (n*2) % 10000;
    }

    public static int commandS(int n) {
        return (n == 0) ? 9999 : n-1;
    }

    public static int commandL(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    public static int commandR(int n) {
        return (n % 10) * 1000 + (n / 10);
    }

	public static int setOrder(int temp, String order) {
		if (order == "D") {
			temp = temp * 2;
			if (9999 < temp) {
				temp = temp % 10000;
			}
		}
		else if (order == "S") {
			temp = temp - 1;
			if (temp == 0) {
				temp = 9999;
			}
		}
		else if (order == "L") {
			temp = (temp % 1000) * 10 + (temp / 1000);
		}
		else if (order == "R") {
			temp = (temp % 10) * 1000 + (temp / 10);
		}

		return temp;
	}
	
	static class Register {
		private int num;
		private String command;
		
		public Register(int num, String command) {
			this.num = num;
			this.command = command;
		}
		
		public int getNum() {
			return this.num;
		}
		
		public String getCommand() {
			return this.command;
		}
	}

}