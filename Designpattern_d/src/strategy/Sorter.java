package strategy;

public class Sorter {
	
	private SortStrategy strategy;

	public Sorter(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public SortStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	public void sort(){
		strategy.sort();// hier immer ein anderes Sort-Objekt (BublleSort)
	}

}
