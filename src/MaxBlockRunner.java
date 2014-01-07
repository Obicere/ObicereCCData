import java.lang.reflect.Method;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class MaxBlockRunner extends Runner {

	private static final char[] CHARS = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'J', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };

	@Override
	public Result[] getResults(Class<?> clazz) {
		try {
			Method method = clazz.getMethod("maxBlock", String.class);
			Result[] results = new Result[10];
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				String string = "";
				for (int j = 0; j < 4 + random.nextInt(3); j++) {
					char c = CHARS[random.nextInt(CHARS.length)];
					for(int k = 0; k < random.nextInt(5); k++){
						string += c;
					}
				}
				results[i] = new Result(method.invoke(clazz.newInstance(), string), maxBlock(string), string);

			}
			return results;
		} catch (Exception e) {
            return new Result[]{};
		}
	}

	private int maxBlock(String str) {
		int i;
		return str.isEmpty() ? 0 : Math.max(i = str.replaceAll("(.)(\\1*).*", "$1$2").length(), maxBlock(str.substring(i)));
	}
}