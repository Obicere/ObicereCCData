import org.obicere.cc.executor.Case;
import org.obicere.cc.util.CharSet;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

import java.util.ArrayList;

@RunnerManifest(author = "Obicere",
          description = "Sweep through the array of Strings and remove an instance of the 'remove' parameter.\nNo null strings will be provided. \nwithoutString({\"a\", \"b\", \"c\", \"a\"}, \"a\") -> {\"b\", \"c\"}",
          difficulty = 2,
          version = 1.0)
public class WithoutStringRunner extends Runner {

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(String[].class, "strings"),
            new Parameter(String.class, "remove")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int length = random.nextInt(10) + 1;
            final String[] strings = new String[length];
            for (int j = 0; j < length; j++) {
                strings[j] = String.valueOf(random.nextChar(CharSet.ALPHA));
            }
            final String remove = strings[random.nextInt(length)];
            final String[] answer = replace(strings, remove);
            cases[i] = new Case(answer, strings, remove);
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "withoutString";
    }

    @Override
    public Class<?> getReturnType() {
        return String[].class;
    }

    private String[] replace(final String[] str, final String replace) {
        final ArrayList<String> list = new ArrayList<>();
        for (final String aStr : str) {
            if (!aStr.equals(replace)) {
                list.add(aStr);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}