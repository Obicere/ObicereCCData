import org.obicere.cc.executor.Case;
import org.obicere.cc.methods.CharSet;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Return the length of the largest block of repetitive characters in a String.",
        difficulty = 3,
        version = 1.0)
public class MaxBlockRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(String.class, "str")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final StringBuilder builder = new StringBuilder();
            int max = 0;
            for (int j = 0; j < random.nextInt(3, 7); j++) {
                final char c = random.nextChar(CharSet.ALPHA);
                final int length = random.nextInt(5);
                for(int k = 0; k < length; k++){
                    builder.append(c);
                }
                if(length > max){
                    max = length;
                }
            }
            cases[i] = new Case(max, builder.toString());
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "maxBlock";
    }

    @Override
    public Class<?> getReturnType(){
        return int.class;
    }

}