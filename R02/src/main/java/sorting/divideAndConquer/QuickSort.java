package sorting.divideAndConquer;
import util.Util;
import sorting.AbstractSorting;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length != 0){
			if(leftIndex < rightIndex){
				int pivotIndex = partition(array, leftIndex, rightIndex);
				sort(array, leftIndex, pivotIndex - 1); //chamada recursiva que pega a parte inferior ao pivot
				sort(array, pivotIndex + 1, rightIndex); // chamada recursiva que pega a parte superior ao pivot
			}
		}
	}

		public int partition(T[] array, int leftIndex, int rightIndex){
			
			T pivot = array[leftIndex];
			int i = leftIndex;
			
			//laco verificando todos os outros elementos do array e comparando com o pivot, se for menor q o pivot, troca com i++
			for(int j = leftIndex + 1; j <= rightIndex; j++){
				if(array[j].compareTo(pivot) < 0){
					i++;
					Util.swap(array, i, j);
				}
			}  

			//um swap pra trocar o pivot (index i) com o primeiro elemento do array
			Util.swap(array, leftIndex, i);
			
			return i;
		
		
		}
}