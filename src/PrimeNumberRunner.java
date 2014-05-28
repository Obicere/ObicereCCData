import org.obicere.cc.executor.Case;
import org.obicere.cc.tasks.projects.Manifest;
import org.obicere.cc.tasks.projects.Parameter;
import org.obicere.cc.tasks.projects.Runner;

@Manifest(author = "Obicere",
        description = "Return the nth prime number in method 'getNthPrime(int n)'.\nn will be bounded by [1, 1000]\nAssume 2 is the first prime number.",
        difficulty = 3,
        version = 1.0)
public class PrimeNumberRunner extends Runner {

    private static final int[] PRIMES = getPrimes();

    private static final Parameter[] PARAMETERS = new Parameter[]{
            new Parameter(int.class, "n")
    };

    @Override
    public Case[] getCases(){
        final Case[] cases = new Case[10];
        for(int i = 0; i < cases.length; i++){
            final int n = random.nextInt(1000);
            final int value = PRIMES[n];
            cases[i] = new Case(value, n + 1); // Offset
        }
        return cases;
    }

    @Override
    public Parameter[] getParameters(){
        return PARAMETERS;
    }

    @Override
    public String getMethodName(){
        return "getNthPrime";
    }

    @Override
    public Class<?> getReturnType(){
        return int.class;
    }

	private static int[] getPrimes() {
		final int[] primes = new int[1000];
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		for (int idx = 3; idx < primes.length;) {
			primeSearch: for (int i = primes[idx - 1] + 2;; i += 2) {
				for (int j = 0; j < idx; j++) {
					if (i % primes[j] == 0) {
						continue primeSearch;
					}
				}
				if (idx == primes.length) {
					break;
				}
				primes[idx++] = i;
			}
		}
		return primes;
	}
}