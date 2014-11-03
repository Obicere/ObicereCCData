import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;
import org.obicere.cc.projects.RunnerManifest;

import java.util.Arrays;

/**
 * @author Obicere
 */
@RunnerManifest(author = "Obicere",
                description = "The Zeckendorf representation of a number is given as the sum of nonconsecutive fibonacci numbers.\n" +
                              "Every positive integer can be represented by a Zeckendorf combination.\n" +
                              "For example:\n" +
                              "14 = 1 + 13 = Fib(1) + Fib(7)\n" +
                              "\n" +
                              "Return the Zeckendorf representation of the given positive integer n in order from smallest-to-largest.",
                difficulty = 5,
                version = 1.0)
public class ZeckendorfRunner extends Runner {


    private static final int[] FIB_NUMS = new int[45];

    static {
        FIB_NUMS[0] = 1;
        FIB_NUMS[1] = 1;
        for (int i = 2; i < FIB_NUMS.length; i++) {
            FIB_NUMS[i] = FIB_NUMS[i - 1] + FIB_NUMS[i - 2];
        }
    }

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
                if(last >= FIB_NUMS.length){
                    break;
                }
                // We also start with the +2 index to avoid getting consecutive numbers.
                last = random.nextInt(last, FIB_NUMS.length);
                final int fib = FIB_NUMS[last];
                if (sum + fib <= 0) {
                    break;
                }
                last += 2;
                sum += fib;
                nums[j] = fib;
            }
            int j = nums.length - 1;
            while (j >= 0 && nums[j] != 0) {
                j--;
            }
            final int[] trimNums = Arrays.copyOfRange(nums, 0, nums.length - j);
            cases[i] = new Case(trimNums, sum);
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
