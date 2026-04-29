# exercise-set-1

Commands using **maven**:

    mvn compile // To build the project

    mvn test // To test the JUnit tests

    mvn test -Dtest=Test1 // Run a single test class

    mvn test -P benchmark-test // To run the benchmarks tests

    mvn exec:java -Dexec.mainClass=<paquete>.<Main> // To execute Main class

    mvn exec:java -Dexec.mainClass=<paquete>.<Main> -Dexec.args="arg1 arg2 ..." // To execute using input args. 
