import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TestLists {
	private final static int TEST_SIZE = 100000000;
	
	public static void main(String[] args) {
		final Integer[] ints = new Integer[TEST_SIZE];
		
		// Stretch some memory, remove autoboxing from equation
		for (int i = 0; i < TEST_SIZE; i++) {
			ints[i] = i;
		}

		long arrayTime;
		long linkedTime;
		long start;

		start = System.nanoTime();
		final List<Integer> arrayList = new ArrayList<>(); 
		for (int i = 0; i < TEST_SIZE; i++) {
			arrayList.add(ints[i]);
		}
		arrayTime = System.nanoTime() - start;
		
		start = System.nanoTime();
		final List<Integer> linkedList = new LinkedList<>(); 
		for (int i = 0; i < TEST_SIZE; i++) {
			linkedList.add(ints[i]);
		}
		linkedTime = System.nanoTime() - start;

		start = System.nanoTime();
		for (Integer in : linkedList) {
			ints[in] = in;
		}
		linkedTime += System.nanoTime() - start;
		
		start = System.nanoTime();
		for (Integer in : arrayList) {
			ints[in] = in;
		}
		arrayTime += System.nanoTime() - start;
		
		System.out.println("ArrayList : " + arrayTime);
		System.out.println("LinkedList: " + linkedTime);
	}
}
