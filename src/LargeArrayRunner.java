import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Return the array that has a larger sum out of the 2.\n{1, 3, 2}, {5, 3, 2} -> {5, 3, 2}\n{1, 5, 6}, {4, 8, 0} -> {1, 5, 6}\nThey will always be of same length.\nIf they are of same size, return array 'b'",
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

            int counter = 0;
            for (int j = 0; j < length; j++) {
                final int nextA = random.nextInt(-50, 200);
                final int nextB = random.nextInt(-50, 200);
                counter += nextA - nextB;

                a[j] = nextA;
                b[j] = nextB;
            }
            cases[i] = new Case(counter > 0 ? a : b, a, b);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "largerArray";
    }

    @Override
    public Class<?> getReturnType(){
        return int[].class;
    }
}