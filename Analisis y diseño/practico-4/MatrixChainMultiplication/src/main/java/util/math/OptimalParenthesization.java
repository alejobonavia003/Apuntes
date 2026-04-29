package util.math;

public class OptimalParenthesization {
	
	private final int cost;
    private final String parenthesization;

    public OptimalParenthesization(int cost, String parenthesization) {
        this.cost = cost;
        this.parenthesization = parenthesization;
    }

    public int getCost() {
        return cost;
    }

    public String getParenthesization() {
        return parenthesization;
    }

    @Override
    public String toString() {
        return "Optimal Cost: " + cost + "\nParenthesization: " + parenthesization;
    }

}
