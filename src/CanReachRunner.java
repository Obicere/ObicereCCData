import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          description = "Return true if you can reach the goal (without going over) by adding large blocks (worth 5) and small blocks (worth 1).\nYou only have a number of each of these given in the parameters.",
          difficulty = 3,
          version = 1.0)
public class CanReachRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "small"),
            new Parameter(int.class, "large"),
            new Parameter(int.class, "goal")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int small = random.nextInt(5, 10);
            final int large = random.nextInt(5);
            final int goal = (small + large * 5) + random.nextInt(-5, 5);
            cases[i] = new Case((goal <= small + large * 5) && goal % 5 <= small, small, large, goal);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "canReach";
    }

    @Override
    public Class<?> getReturnType() {
        return boolean.class;
    }
}
