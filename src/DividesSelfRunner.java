import java.lang.reflect.Method;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class DividesSelfRunner extends Runner {

	@Override
	public Result[] getResults(Class<?> clazz) {
		try {
			final Method method = clazz.getMethod("canDivide", int.class);
			final Random ran = new Random();
			final Result[] results = new Result[10];
			for (int i = 0; i < results.length; i++) {
				int selected = ran.nextInt(501) + ran.nextInt(500);
				results[i] = new Result(method.invoke(clazz.newInstance(), selected), canDivide(selected), selected);
			}
			return results;
		} catch (Exception e) {
			return new Result[]{};
		}
	}

	private boolean canDivide(int num) {
        int count = (int) Math.log10(num) + 1;
        for(int i = 0; i < count; i++){
            int next = ((int) (num / Math.pow(10, i))) % 10;
            if(next == 0){
                return false;
            }
            if(num % next != 0){
                return false;
            }
        }
        return true;
	}
}
