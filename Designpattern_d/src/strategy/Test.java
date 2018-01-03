package strategy;

public class Test {

	public static void main(String[] args) {

		
		Sorter sorter = new Sorter(new BubbleSort());
		
		sorter.sort();
		
		sorter.setStrategy(new QuickSort());
		
		sorter.sort();
	}

}
