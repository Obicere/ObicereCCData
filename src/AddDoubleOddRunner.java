import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(  author = "Obicere",
            description = "Add parameters x and y, but if x is odd, return double the sum.",
            difficulty = 1,
            version = 1.0)
public class AddDoubleOddRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "x"),
            new Parameter(int.class, "y")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for(int i = 0; i < cases.length; i++){
            final int x = -3000 + random.nextInt(6000);
            final int y = -3000 + random.nextInt(6000);
            final int correct = (x + y) * (x % 2 == 0 ? 1 : 2);
            cases[i] = new Case(correct, x, y);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "addOdd";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }
}
