import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          version = 1.0,
          description = "Given an array of integers, sum all the integers.\n" +
                        "But, if the number is odd, subtract it from the sum. ",
          difficulty = 1)
public class AddMinusRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    private int addMinus(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        return sum;
    }

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int[] numbers = new int[random.nextInt(10)];
            for (int j = 0; j < numbers.length; j++) {
                numbers[j] = random.nextInt(-1000, 1000);
            }
            cases[i] = new Case(addMinus(numbers), numbers);
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