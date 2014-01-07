import java.lang.reflect.Method;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class PrimeNumberRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> classToTest) {
		final Random random = new Random();
		final int[] primes = getPrimes();
		try {
			final Method method = classToTest.getMethod("getNthPrime", int.class);
			final Result[] results = new Result[10];
			for (int i = 0; i < 10; i++) {
				int param = random.nextInt(1000);
				results[i] = new Result(method.invoke(classToTest.newInstance(), param + 1), primes[param], param + 1);
			}
			return results;
		} catch (Exception e) {
			return new Result[]{};
		}
	}

	private static int[] getPrimes() {
		final int[] primes = new int[1000];
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		for (int idx = 3; idx < primes.length;) {
			primeSearch: for (int i = primes[idx - 1] + 2;; i += 2) {
				for (int j = 0; j < idx; j++) {
					if (i % primes[j] == 0) {
						continue primeSearch;
					}
				}
				if (idx == primes.length) {
					break;
				}
				primes[idx++] = i;
			}
		}
		return primes;
	}
}