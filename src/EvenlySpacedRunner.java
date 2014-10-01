import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          description = "Given 3 integers, return true if the difference between small and medium is the same as the difference between medium and large.\nThey won't necessarily be in order",
          difficulty = 2,
          version = 1.0)
public class EvenlySpacedRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "a"),
            new Parameter(int.class, "b"),
            new Parameter(int.class, "c")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int a = random.nextInt(100);
            final int delta = random.nextInt(-50, 50);
            final int b = a + delta + random.nextInt(3);
            final int c = b + delta + random.nextInt(3);

            cases[i] = new Case(spaced(a, b, c), a, b, c);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "evenlySpaced";
    }

    @Override
    public Class<?> getReturnType() {
        return boolean.class;
    }

    private boolean spaced(final int a, final int b, final int c) {

        final int diff1 = Math.abs(a - b);
        final int diff2 = Math.abs(a - c);
        final int diff3 = Math.abs(b - c);

        return diff1 == diff2 || diff1 == diff3 || diff2 == diff3;
    }
}