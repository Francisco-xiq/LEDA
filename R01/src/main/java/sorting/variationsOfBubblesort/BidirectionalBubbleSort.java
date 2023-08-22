package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if(array != null && leftIndex >= 0 && rightIndex <= array.length - 1){
			boolean swapou = true;
			while(swapou){
				swapou = false;
				for (int IndexMenor = leftIndex; IndexMenor < rightIndex; IndexMenor++) { //um for buscando o maior e levando ate o index mais alto, indo de leftindex ate rightindex
					if (array[IndexMenor].compareTo(array[IndexMenor+1]) > 0) {
						Util.swap(array, IndexMenor, IndexMenor+1);
						swapou = true;
					} 
				}
				for (int IndexMaior = rightIndex; IndexMaior > leftIndex; IndexMaior--) { //um for bucsando o menor e levanto ate o index mais baixo, indo de rightindex ate leftindex
					if (array[IndexMaior].compareTo(array[IndexMaior-1])<0) {
						Util.swap(array, IndexMaior, IndexMaior-1);
						swapou = true;
					}
				}
			
			}
		}
	}
}