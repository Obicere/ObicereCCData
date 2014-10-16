import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;
import org.obicere.cc.projects.RunnerManifest;

/**
 * @author Obicere
 */
@RunnerManifest(author = "Obicere",
                description = "The Zeckendorf representation of a number is given as the sum of nonconsecutive fibonacci numbers.\n" +
                              "Every positive integer can be represented by a Zeckendorf combination.\n" +
                              "For example:\n" +
                              "14 = 1 + 13\n" +
                              "\n" +
                              "Return the Zeckendorf representation of the given positive integer n in order from smallest-to-largest.",
                difficulty = 5,
                version = 1.0)
public class ZeckendorfRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "n")
    };

    @Override
    public Case[] getCases() {
        final int count = 10;
        final Case[] cases = new Case[count];
        for (int i = 0; i < count; i++) {
            final int numbers = random.nextInt(4) + 1;
            final int[] nums = new int[numbers];

            int sum = 0;
            int last = 0;
            for (int j = 0; j < numbers; j++) {

                final int next = random.nextInt(last + 1, 46);
                final int fib = FibonacciRunner.fibonacci(next);
                if (next == 45) {
                    break; // We don't want to overflow ints
                }
                last = next;
                sum += fib;
                nums[j] = fib;
            }
            cases[i] = new Case(nums, sum);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "asZeckendorfRepresentation";
    }

    @Override
    public Class<?> getReturnType() {
        return int[].class;
    }
}
