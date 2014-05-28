import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Round each number in the list to the nearest number divisible by 10.\nThen, return the sum of all the rounded numbers.\nFor example:\n5 rounds to 10\n14 rounds to 10\n23 rounds to 20.",
        difficulty = 1,
        version = 1.0)
public class RoundSumRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases(){
        final Case[] cases = new Case[10];
        for(int i = 0; i < cases.length; i++){
            final int length = random.nextInt(3, 12);
            final int[] nums = new int[length];
            int sum = 0;
            for(int j = 0; j < length; j++){
                final int next = random.nextInt(0, 1000);
                nums[j] = next;
                sum += (int) ((next / 10d) + 0.5) * 10;
            }
            cases[i] = new Case(sum, nums);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "roundSum";
    }

    @Override
    public Class<?> getReturnType(){
        return int.class;
    }

}