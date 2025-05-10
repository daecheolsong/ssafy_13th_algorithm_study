import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static Deque<Integer> q;

	static class Person {
		Integer age;
		String name;

		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(sb);
	}

	private static void go(String action, int num) {

		switch (action) {
		case "push": {
			q.add(num);
			break;
		}
		case "pop": {
			sb.append(q.isEmpty() ? -1 : q.pop()).append("\n");
			break;
		}
		case "size": {
			sb.append(q.size()).append("\n");
			break;
		}
		case "empty": {
			sb.append(q.isEmpty() ? 1 : 0).append("\n");
			break;
		}
		case "front": {
			sb.append(q.isEmpty()? -1 : q.peekFirst()).append("\n");
			break;
		}
		case "back": {
			sb.append(q.isEmpty()? -1 : q.peekLast()).append("\n");
			break;
		}
		}

	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String action = "";
			int num = 0;
			if (str.contains("push")) {
				st = new StringTokenizer(str, " ");
				action = st.nextToken();

				num = Integer.parseInt(st.nextToken());
				go(action, num);

			} else {
				action = str;
				go(action, num);

			}

		}

	}

}
