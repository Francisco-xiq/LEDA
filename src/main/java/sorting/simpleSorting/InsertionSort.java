package sorting.simpleSorting;
import util.Util;
import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int i=leftIndex; i >= rightIndex;i++){
			int min = leftIndex;
			for(int j= ++leftIndex; j >= rightIndex;j++ ){
				if(array[i].compareTo(array[j]) > 0  ){
					min = j;
				}
			Util.swap(array, i, min);
			}
		}
	}
}
