import org.obicere.cc.executor.Case;
import org.obicere.cc.util.CharacterGroup;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          description = "Return the sum of all the numbers contained in the string.\n\"Aj7b7s6\" -> 7 + 7 + 6 = 20",
          difficulty = 2,
          version = 1.0)
public class ParseSumRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(String.class, "str")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(5, 15);
            final StringBuilder str = new StringBuilder(length);
            int sum = 0;
            for (int j = 0; j < length; j++) {
                final char next = random.nextChar(CharacterGroup.ALPHANUMERIC);
                if (Character.isDigit(next)) {
                    sum += next - '0';
                }
                str.append(next);
            }
            cases[i] = new Case(sum, str.toString());
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "getSum";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }
}