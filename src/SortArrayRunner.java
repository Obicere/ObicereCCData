import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class SortArrayRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> classToTest) {
		try {
			final Method method = classToTest.getMethod("sort", int[].class);
			final Result[] results = new Result[10];
            final Random ran = new Random();
			for (int i = 0; i < 10; i++) {
                final int[] nums = new int[ran.nextInt(10)];
                for(int j = 0; j < nums.length; j++){
                    nums[j] = ran.nextInt(20) - ran.nextInt(10);
                }
                final int[] sorted = nums.clone();
                Arrays.sort(sorted);
				results[i] = new Result(Arrays.toString((int[]) method.invoke(classToTest.newInstance(), nums)), Arrays.toString(sorted), Arrays.toString(nums));
			}
			return results;
		} catch (Exception e) {
			return new Result[]{};
		}
	}
}