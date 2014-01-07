import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.obicere.cc.executor.Result;
import org.obicere.cc.tasks.projects.Runner;

public class WithoutStringRunner extends Runner {

    private static final char[] CHARS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'J', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    @Override
    public Result[] getResults(Class<?> clazz) {
        try {
            final Method method = clazz.getMethod("withoutString", String[].class, String.class);
            final Random random = new Random();
            final Result[] results = new Result[10];
            for (int i = 0; i < results.length; i++) {
                final String[] ans = new String[3 + random.nextInt(5)];
                for (int j = 0; j < ans.length; j++) {
                    ans[j] = String.valueOf(CHARS[random.nextInt(CHARS.length)]);
                }
                final String remove = ans[random.nextInt(ans.length)];
                results[i] = new Result(Arrays.toString((String[]) method.invoke(clazz.newInstance(), ans, remove)), Arrays.toString(replace(ans, remove)), Arrays.toString(ans), remove);
            }
            return results;
        } catch (Exception e) {
            return new Result[]{};
        }
    }

    private String[] replace(final String[] str, final String replace) {
        final ArrayList<String> list = new ArrayList<>();
        for (String aStr : str) {
            if (!aStr.equals(replace)) {
                list.add(aStr);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}