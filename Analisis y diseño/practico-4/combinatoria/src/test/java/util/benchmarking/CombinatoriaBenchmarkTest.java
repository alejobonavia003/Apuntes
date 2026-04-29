package util.benchmarking;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import combinatoria.Combinatoria;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Runs benchmark on combinatorial algorithms.
 * This class uses JMH benchmarking framework.
 * @author vale
 *
 */
public class CombinatoriaBenchmarkTest {

	/**
	 * Runner for JMH, implemented as a jUnit test.
	 * @throws Exception when parameter options or run fails
	 */
	@Test 
	public void launchBenchmark() throws Exception {

		Options opt = new OptionsBuilder()
				.include(this.getClass().getName() + ".*")
				.mode (Mode.AverageTime)
				.timeUnit(TimeUnit.MICROSECONDS)
				.warmupTime(TimeValue.seconds(1))
				.warmupIterations(2)
				.measurementTime(TimeValue.seconds(1))
				.measurementIterations(2)
				.threads(2)
				.forks(1)
				.shouldFailOnError(true)
				.shouldDoGC(true)
				.build();

		new Runner(opt).run();
	}

	/**
	 * State to be used for benchmarking. 
	 * This is a form of parameterized benchmarking.
	 * Benchmark will be run on all BenchmarkState produced.
	 * 
	 * @author bengolea
	 *
	 */
	@State(Scope.Benchmark)
	public static class BenchmarkState {

		@Param("10")
	    public int maxSize;
		
		public int n;

	    public int k;

		
		/**
		 * Sets test values with  random ints.
		 */
		@Setup(Level.Invocation)
		public void setUp() {
			k = new Random().nextInt(maxSize) + 1; 

			n = new Random().nextInt(maxSize) + k; 
		}
	}


	/**
	 * Benchmark method. Runs Divide and Conquer combinatorial algorithm and takes measurements described in 
	 * the tags.
	 * Runs multiple times, taking into account warmup runs and iterations.
	 * @param state is the (parameterized) state on which the benchmark method runs.
	 */
	@Fork(value = 1, warmups = 1)
	@Warmup(iterations = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void benchmarkCombinatoria(BenchmarkState state) {
		Combinatoria.combinatoria(state.n, state.k);	
	}
	
	

	/**
	 * Benchmark method. Runs Dynamic Programming combinatorial algorithm and takes measurements described in 
	 * the tags.
	 * Runs multiple times, taking into account warmup runs and iterations.
	 * @param state is the (parameterized) state on which the benchmark method runs.
	 */
	@Fork(value = 1, warmups = 1)
	@Warmup(iterations = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void benchmarkPDCombinatoria(BenchmarkState state) {
		Combinatoria.PDCombinatoria(state.n, state.k);	
	}

}

