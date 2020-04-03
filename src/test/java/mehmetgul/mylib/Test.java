package mehmetgul.mylib;

public class Test {
	public static String betterCompression(String s) {

		char[] str = s.toCharArray();
		int[] map = new int[26];
		int i = 0;
		int n = s.length();
		while (i < n) {
			char ch = str[i];
			if (ch >= 'a' && ch <= 'z') {
				int start = i + 1;
				int end = start;
				while (end < n && (str[end] >= '0' && str[end] <= '9')) {
					end++;
				}

				int count = Integer.parseInt(s.substring(start, end));

				map[ch - 'a'] += count;
				i = end;
			} else {
				i++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (map[ch - 'a'] > 0) {
				sb.append(ch);
				sb.append(map[ch - 'a']);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)  {

		System.out.println(betterCompression("a3c9b2c1"));
	}
}
