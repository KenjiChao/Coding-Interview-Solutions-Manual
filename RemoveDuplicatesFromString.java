import java.util.*;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		String str = "I love to play soccer very much.";
		System.out.println(str);
		System.out.println(removeDuplicates(str));
	}

	public static String removeDuplicates(String string) {
		char[] chars = string.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		for (char c : chars)
		charSet.add(c);

		StringBuilder sb = new StringBuilder();
		for (Character character : charSet)
			sb.append(character);
		return sb.toString();
	}
}
