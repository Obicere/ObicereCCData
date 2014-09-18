import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.Manifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

import java.util.ArrayList;

@Manifest(author = "Obicere",
          description = "Return the nth fibonacci number. Note that:\nfibonacci(0) = 0\nfibonacci(1) = 1\nfibonacci(2) = 1\n...",
          difficulty = 2,
          version = 1.0)
public class FibonacciRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "n")
    };

    private static final ArrayList<Integer> FIBONACCI = new ArrayList<>();

    static {
        FIBONACCI.add(0);
        FIBONACCI.add(1);
        FIBONACCI.add(1);
    }

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int n = random.nextInt(46); // 1,836,311,903
            cases[i] = new Case(fibonacci(n), n);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "fibonacci";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }

    public static int fibonacci(final int i) {
        if (i < 0) {
            return 0;
        }
        if (i < FIBONACCI.size()) {
            return FIBONACCI.get(i);
        }
        final int num = fibonacci(i - 2) + fibonacci(i - 1);
        FIBONACCI.add(num);
        return num;
    }
}