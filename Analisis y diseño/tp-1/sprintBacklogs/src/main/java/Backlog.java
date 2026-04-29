import java.util.*;

public class Backlog {

	private int sprintTime;
	private Set<Functionality> mochila;
	/**
	 * 
	 */
	public Backlog(Set<Functionality> functionalitySet, int sprintTime) {
			mochila = functionalitySet;
			this.sprintTime = sprintTime;
			mochila = optimalSet();

	}

	/**
	 * 
	 */
	public Set<Functionality> optimalSet() {
		Functionality[] arr = new Functionality[mochila.size()];
		int[][] matriz = new int[sprintTime + 1][mochila.size() + 1];

		for(int i = 0 ; i <= mochila.size();i++){
			matriz[0][i] = 0;
		}
		for(int j = 0; j <= sprintTime; j++){
			matriz[j][0] = 0;
		}
	
		int k = 0;
		for(Functionality f : mochila){
			arr[k++] = f;
			
		}
		
		for(int i=1;i<= sprintTime;i++){
            for(int j=1;j<=mochila.size();j++){
                if(arr[j-1].getTimeCost() <= i){
					int aux = arr[j-1].getValue() + matriz[i-arr[j-1].getTimeCost()][j-1];
					if(aux > matriz[i][j-1]){
						matriz[i][j] = aux;
					}else {
						matriz[i][j] = matriz[i][j-1];
					}
				}else {
					matriz[i][j] = matriz[i][j-1];
				}
            }
        }

		Set<Functionality> result = new HashSet<>();

        int i = sprintTime;
        int j = mochila.size();

        while (i > 0 && j > 0) {
            if (matriz[i][j] != matriz[i][j - 1]) {
                result.add(arr[j-1]);
                i -= arr[j-1].getTimeCost();
            }
                j--;
            
            
        }

		return result;		
	}



	/**
	 *
	 */

	public  int getSpentTime() {
		int spentTime = 0;
		for(Functionality p : mochila){
			spentTime += p.getTimeCost();
		}
		return spentTime;
	}

  /**
   * 
   */
	public int getValue() {
		int valueTime = 0;
		for(Functionality p : mochila){
			valueTime += p.getValue();
		}
		return valueTime;
	}
}
