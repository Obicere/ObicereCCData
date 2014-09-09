import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
          description = "Return the sum of a and b.",
          difficulty = 1,
          version = 1.0)
public class SimpleAdditionRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "a"),
            new Parameter(int.class, "b")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int a = random.nextInt(-5000, 5001);
            final int b = random.nextInt(-5000, 5001);
            cases[i] = new Case(a + b, a, b);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "sum";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }

}