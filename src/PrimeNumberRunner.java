import org.obicere.cc.executor.Case;
import org.obicere.cc.projects.RunnerManifest;
import org.obicere.cc.projects.Parameter;
import org.obicere.cc.projects.Runner;

@RunnerManifest(author = "Obicere",
          description = "Return the nth prime number in method 'getNthPrime(int n)'.\n" +
                        "n will be bounded by [1, 1000]\n" +
                        "Assume 2 is the first prime number.\n" +
                        "\n" +
                        "getNthPrime(1) = 2\n" +
                        "getNthPrime(2) = 3\n" +
                        "getNthPrime(83) = 431",
          difficulty = 3,
          version = 1.0)
public class PrimeNumberRunner extends Runner {

    private static final int[] PRIMES = getPrimes();

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "n")
    };

    @Override
    public Case[] getCases() {
        final Case[] cases = new Case[10];
        for (int i = 0; i < cases.length; i++) {
            final int n = random.nextInt(1000);
            final int value = PRIMES[n];
            cases[i] = new Case(value, n + 1); // Offset
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters() {
        return PARAMETERS;
    }

    @Override
    public String getMethodName() {
        return "getNthPrime";
    }

    @Override
    public Class<?> getReturnType() {
        return int.class;
    }

    private static int[] getPrimes() {
        final int[] primes = new int[1001];
        primes[0] = 2;
        int counter = 1;
        top:
        for(int i = 3; counter <= 1000; i += 2){
            for(int j = 0; j < counter; j++){
                if(i % primes[j] == 0){
                    continue top;
                }
            }
            primes[counter++] = i;
        }
        return primes;
    }
}