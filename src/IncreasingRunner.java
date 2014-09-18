import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.Manifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@Manifest(author = "Obicere",
          description = "Return true if the parameters a, b, c increase as you read them from left-to-right, or stay the same.\n{1, 2, 4} -> true\n{1, 2, 2} -> true\n{1, 4, 3} -> false",
          difficulty = 2,
          version = 1.0)
public class IncreasingRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(3, 10);
            final int[] nums = new int[length];

            int last = random.nextInt(-100, 100);
            for (int j = 0; j < length; j++) {
                final int delta = random.nextInt(-2, 5);
                final int next = last + delta;
                nums[j] = next;
                last = next;
            }
            cases[i] = new Case(increasing(nums), nums);
        }
        return cases;
    }

    private boolean increasing(final int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] > nums[j]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "increasing";
    }

    @Override
    public Class<?> getReturnType() {
        return boolean.class;
    }

}