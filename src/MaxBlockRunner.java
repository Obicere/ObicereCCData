import org.obicere.cc.executor.Case;
import org.obicere.cc.util.CharacterGroup;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          description = "Return the length of the largest block of sequential characters in a String.",
          difficulty = 3,
          version = 1.0)
public class MaxBlockRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(String.class, "str")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < random.nextInt(3, 7); j++) {
                final char c = random.nextChar(CharacterGroup.ALPHA);
                final int length = random.nextInt(5);
                for (int k = 0; k < length; k++) {
                    builder.append(c);
                }
            }
            final String str = builder.toString();
            cases[i] = new Case(maxBlock(str), str);
        }
        return cases;
    }

    private int maxBlock(final String str) {
        int max = 0;
        final char[] c = str.toCharArray();
        for (int i = 0; i < c.length;) {
            int counter = 0;
            final char next = c[i];
            while (i < c.length && next == c[i]) {
                counter++;
                i++;
            }
            if (max < counter) {
                max = counter;
            }
        }
        return max;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "maxBlock";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }

}