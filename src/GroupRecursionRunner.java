import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Return true if any combination of the numbers can reach the target.\nStart will always be 0 to begin with.\nRemember that this is recursive, so no loops.",
        difficulty = 4,
        version = 1.0)
public class GroupRecursionRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "start"),
            new Parameter(int.class, "target"),
            new Parameter(int[].class, "nums")
    };

    @Override
    public Case[] getCases(){
        final Case[] cases = new Case[10];
        for(int i = 0; i < 10; i++){
            final int[] nums = new int[random.nextInt(3, 7)];
            for(int j = 0; j < nums.length; j++){
                nums[j] = random.nextInt(-12, 13);
            }
            final int target = random.nextInt(-23, 22);
            cases[i] = new Case(groupSum(0, target, nums), 0, target, nums);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "group";
    }

    @Override
    public Class<?> getReturnType(){
        return boolean.class;
    }

	private boolean groupSum(int start, int target, int[] nums) {
		if (start == nums.length)
			return target == 0;
		return (groupSum(start + 1, target - nums[start], nums)) || groupSum(start + 1, target, nums);
	}
}