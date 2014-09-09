import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

import java.util.Arrays;

@Manifest(author = "Obicere",
          description = "Sort the numbers of the given array from least to greatest, and return a new array containing the sorted list.\n{3, 4, 1, 6, 8} -> {1, 3, 4, 6, 8}",
          difficulty = 2,
          version = 1.0)
public class SortArrayRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(5, 20);
            final int[] nums = new int[length];
            final int[] sorted = new int[length];
            for (int j = 0; j < length; j++) {
                final int next = random.nextInt(-100, 101);
                nums[j] = next;
                sorted[j] = next;
            }
            Arrays.sort(sorted);
            cases[i] = new Case(sorted, nums);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "sort";
    }

    @Override
    public Class<?> getReturnType() {
        return int[].class;
    }
}