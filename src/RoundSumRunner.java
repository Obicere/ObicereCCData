import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class RoundSumRunner extends Runner {
	@Override
	public Result[] getResults(Class<?> clazz) {
		try {
			final Method method = clazz.getMethod("roundSum", int[].class);
			final Random ran = new Random();
			final Result[] results = new Result[15];
			for (int j = 0; j < results.length; j++) {
				int childCount = ran.nextInt(5) + ran.nextInt(5);
				int[] nums = new int[childCount];
				for (int i = 0; i < nums.length; i++) {
					nums[i] = ran.nextInt(100);
				}
				results[j] = new Result(method.invoke(clazz.newInstance(), nums), roundSum(nums), Arrays.toString(nums));
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result[]{};
	}

	public int roundSum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += (int) ((i / 10d) + 0.5) * 10;
		}
		return sum;
	}
}