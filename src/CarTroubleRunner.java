import java.lang.reflect.Method;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class CarTroubleRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> classToTest) {
		try {
			final Random random = new Random();
			final Object instance = classToTest.newInstance();
			final Method method = classToTest.getMethod("getWarning", boolean.class, boolean.class);
            final Result[] results = new Result[random.nextInt(10)];
            for(int i = 0; i < results.length; i++){
                final boolean a = random.nextBoolean();
                final boolean b = random.nextBoolean();
                results[i] = new Result(method.invoke(instance, a, b), (a ? 1 : 0) + (b ? 2 : 0), a +", " + b);
            }
			return results;
		} catch (Exception e) {
			return new Result[] {};
		}

	}
}