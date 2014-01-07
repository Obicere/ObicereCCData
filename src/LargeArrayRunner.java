import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class LargeArrayRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> clazz) {
		try {
			final Method method = clazz.getMethod("largerArray", int[].class,
					int[].class);
			final Result[] results = new Result[10];
			final Random random = new Random();
			for (int i = 0; i < results.length; i++) {
				final int count = random.nextInt(5);
				final int[] a = new int[count];
				for (int j = 0; j < a.length; j++) {
					a[j] = random.nextInt(50);
				}
				final int[] b = new int[count];
				for (int j = 0; j < b.length; j++) {
					b[j] = random.nextInt(50);
				}
				results[i] = new Result(Arrays.toString((int[]) method.invoke(
						clazz.newInstance(), a, b)), Arrays.toString(larger(a,
						b)), Arrays.toString(a), Arrays.toString(b));
			}
			return results;
		} catch (Exception e) {
			return new Result[]{};
		}
	}

	private int[] larger(int[] a, int[] b) {
		int sum = 0;
		for (int i = 0; i < Math.max(a.length, b.length); i++) {
			sum += a[i] - b[i];
		}
		return sum > 0 ? a : b;
	}
}