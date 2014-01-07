import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class AddMinusRunner extends Runner {

    @Override
    public Result[] getResults(Class<?> clazz) {
        try {
            Result[] results = new Result[10];
            Method method = clazz.getMethod("addMinus", int[].class);
            Random ran = new Random();
            for (int i = 0; i < 10; i++) {
                int[] nums = new int[]{ran.nextInt(10), ran.nextInt(10), ran.nextInt(10), ran.nextInt(10), ran.nextInt(10)};
                results[i] = new Result(method.invoke(clazz.newInstance(), nums), addMinus(nums), Arrays.toString(nums));
            }
            return results;
        } catch (Exception e) {
            return new Result[]{};
        }
    }

    private int addMinus(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        return sum;
    }

}