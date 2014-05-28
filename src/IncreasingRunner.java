import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Return true if the parameters a, b, c increase as you read them from left-to-right, or stay the same.\n{1, 2, 4} -> true\n{1, 2, 2} -> true\n{1, 4, 3} -> false",
        difficulty = 2,
        version = 1.0)
public class IncreasingRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for(int i = 0; i < cases.length; i++){
            final int length = random.nextInt(3, 10);
            final int[] nums = new int[length];

            boolean flag = true;
            int last = random.nextInt(-100, 100);
            for(int j = 0; j < length; j++){
                final int delta = random.nextInt(-2, 5);
                final int next = last + delta;

                if(delta < 0){
                    flag = false;
                }
                nums[j] = next;
                last = next;
            }
            cases[i] = new Case(flag, nums);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "increasing";
    }

    @Override
    public Class<?> getReturnType(){
        return boolean.class;
    }

}