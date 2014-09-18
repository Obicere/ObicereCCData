import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.Manifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@Manifest(author = "Obicere",
          description = "Return true if the array has three of the same element in a row.\n{1, 4, 5, 5, 5, 8} -> true\n{1, 4, 5, 6, 5, 5, 8} -> false",
          difficulty = 2,
          version = 1.0)
public class HasTripleRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(5, 15);
            final int[] nums = new int[length];
            for (int k = 0; k < length; ) {

                final int val = random.nextInt(100);
                final int max = random.nextInt(3);

                for (int j = 0; j < max && k < length; j++) {
                    nums[k] = val;
                    k++;
                }
            }
            cases[i] = new Case(hasTriple(nums), nums);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "hasTriple";
    }

    @Override
    public Class<?> getReturnType() {
        return boolean.class;
    }

    private boolean hasTriple(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] == nums[i] && nums[i + 2] == nums[i]) {
                return true;
            }
        }
        return false;
    }

}
