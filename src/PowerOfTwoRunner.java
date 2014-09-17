import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
          difficulty = 2,
          description = "Return true if the given integer, num, is a power of two.",
          version = 1.0)
public class PowerOfTwoRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "num")
    };

    @Override
    public Case[] getCases() {
        final int length = 10;
        final Case[] cases = new Case[length];
        for (int i = 0; i < length; i++) {
            final int power = 1 << random.nextInt(32);
            final boolean deviate = random.nextBoolean();
            final int deviation;
            if (deviate) {
                deviation = random.nextInt(power) + 1;
            } else {
                deviation = 0;
            }
            final boolean negate = random.nextBoolean();
            final int n = power + deviation;
            final int num = negate ? -n : n;
            final boolean isTwo = isPowerOfTwo(num);
            cases[i] = new Case(isTwo, num);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "isPowerOfTwo";
    }

    @Override
    public Class<?> getReturnType() {
        return boolean.class;
    }

    private boolean isPowerOfTwo(final int num) {
        if (num == Integer.MIN_VALUE || num == 0) {
            return false;
        }
        return (num & -num) == num;
    }
}
