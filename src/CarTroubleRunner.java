import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
          description = "Given parameters boolean lowGas and boolean lowOil, using the getWarning method return the following:\n0 if you have no issues\n1 if you have lowOil\n2 if you have lowGas\n3 if you have both.",
          difficulty = 1,
          version = 1.0)
public class CarTroubleRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(boolean.class, "lowGas"),
            new Parameter(boolean.class, "lowOil")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final boolean lowGas = random.nextBoolean();
            final boolean lowOil = random.nextBoolean();
            cases[i] = new Case((lowOil ? 1 : 0) + (lowGas ? 2 : 0), lowGas, lowOil);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "getWarning";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }
}