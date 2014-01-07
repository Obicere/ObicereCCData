import java.lang.reflect.Method;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class SimpleAdditionRunner extends Runner {

    @Override
    public Result[] getResults(Class<?> c) {
        try {
            final Random random = new Random();
            final Object instance = c.newInstance();
            final Method m = c.getMethod("add", int.class, int.class);
            final Result[] results = new Result[10];
            for (int i = 0; i < results.length; i++) {
                final int x = -3000 + random.nextInt(6000);
                final int y = -3000 + random.nextInt(6000);
                results[i] = new Result(m.invoke(instance, x, y), x + y, x, y);
            }
            return results;
        } catch (Exception e) {
            return new Result[]{};
        }
    }

}