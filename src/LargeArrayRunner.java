import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
                description = "Return the sum of the array that has a larger sum out of the 2.\n{1, 3, 2}, {5, 3, 2} -> sum({5, 3, 2}) -> 10\n{1, 5, 6}, {4, 8, 0} -> sum({1, 5, 6}) -> 12\nThey will always be of same length.\nIf they are of same size, return 0.",
                difficulty = 1,
                version = 1.0)
public class LargeArrayRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "a"),
            new Parameter(int[].class, "b")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(3, 10);
            final int[] a = new int[length];
            final int[] b = new int[length];

            int aSum = 0;
            int bSum = 0;
            for (int j = 0; j < length; j++) {
                final int nextA = random.nextInt(-50, 200);
                final int nextB = random.nextInt(-50, 200);
                aSum += nextA;
                bSum += nextB;

                a[j] = nextA;
                b[j] = nextB;
            }
            final int value;
            if (aSum > bSum) {
                value = aSum;
            } else if (aSum < bSum) {
                value = bSum;
            } else {
                value = 0;
            }
            cases[i] = new Case(value, a, b);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "largerArray";
    }

    @Override
    public Class<?> getReturnType() {
        return int[].class;
    }
}