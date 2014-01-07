import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class EvenlySpacedRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> classToTest) {
		try {
			final Method method = classToTest.getMethod("spaced", int.class, int.class, int.class);
			final Random ran = new Random();
			final Result[] results = new Result[10];
			for (int i = 0; i < 10; i++) {
				final int a = ran.nextInt(10), b = a + (-ran.nextInt(2) + ran.nextInt(4)), c = b + (-ran.nextInt(2) + ran.nextInt(4));
				results[i] = new Result(method.invoke(classToTest.newInstance(), a, b, c), spaced(a, b, c), Arrays.toString(new int[] { a, b, c }));
			}
			return results;
		} catch (Exception e) {
			return new Result[] {};

		}
	}

	private boolean spaced(int a, int b, int c) {
		int diff1 = 0;
		int diff2 = 0;
		int diff3 = 0;

		if (a == b && a == c) {
			return true;
		}

		if (a == b || b == c || a == c) {
			return false;
		}
		diff1 = Math.abs(a - b);
		diff2 = Math.abs(a - c);
		diff3 = Math.abs(b - c);

        return diff1 == diff2 || diff1 == diff3 || diff2 == diff3;

    }
}