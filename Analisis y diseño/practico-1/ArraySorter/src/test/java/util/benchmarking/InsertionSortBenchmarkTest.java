package util.benchmarking;

import org.junit.Test;
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
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import util.ArraySorter;
import util.SortAlgorithm;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * Runs benchmark on selection sort algorithm.
 * This class uses JMH benchmarking framework.
 * @author aguirre
 *
 */
public class InsertionSortBenchmarkTest {

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
	 * @author aguirre
	 *
	 */
	@State(Scope.Benchmark)
	public static class BenchmarkState {

		/**
		 * Sizes of the arrays to be used for benchmarking.
		 * Change/extend the param for other array sizes.
		 */
		@Param({"10", "100", "1000"})
		public int arraySize;

		/**
		 * The array to be sorted.
		 */
		public Integer[] testArray;

		/**
		 * Sets test array with a random array of arraySize.
		 */
		@Setup(Level.Trial)
		public void setUp() {
			testArray = new Random()
					.ints()
					.limit(arraySize)
					.boxed().toArray(Integer[]::new);
		}
	}


	/**
	 * Benchmark method. Runs selection sort and takes measurements described in 
	 * the tags.
	 * Runs multiple times for each size, taking into account warmup runs and iterations.
	 * @param state is the (parameterized) state on which the benchmark method runs.
	 */
	@Fork(value = 1, warmups = 1)
	@Warmup(iterations = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void benchmarkInsertionSort(BenchmarkState state) {

		ArraySorter<Integer> sorter = new ArraySorter<Integer>(state.testArray, SortAlgorithm.INSERTIONSORT);
		sorter.sort();

	}

}

