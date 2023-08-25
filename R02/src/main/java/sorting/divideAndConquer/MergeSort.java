package sorting.divideAndConquer;
import java.util.Arrays;
import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (rightIndex > leftIndex && leftIndex >= 0 && leftIndex <= array.length - 1 && rightIndex >= 0 && rightIndex <= array.length - 1){
				int middle = (leftIndex + rightIndex) / 2;

				// chamadas recursivas pra primeira parte e pra segunda parte
				
				sort(array, leftIndex, middle);
				sort(array, middle + 1, rightIndex);

				// aqui os passos recursivos acontencem primeiro, e depois q vem a parte logica
				// nao sei exatamente o pq mas na minha visao eh pq a gente so comeca a fazer algo
				// dps de dividir todin, ai quando divide nos pega voltano e reorganizando

				merge(array, leftIndex, middle, rightIndex);

			}
		}
	
	
	public void merge(T[] array, int leftIndex, int middle,int rightIndex){
		
		// fazer a copia do array pra a gente poder verificar os numeros nessa copia e depois alterar no array original
		T[] copia = Arrays.copyOf(array, array.length);
		
		// definindo os indicies 
		

		// parte logica do merge, consiste em um while que faz com que 
		// ou um elemento da primeira parte entre no canto certo, ou o elemento da segunda parte
		// e depois dois while pra ir colocando o restante caso alguma parte acabe primeiro
		
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		while (i <= middle && j <= rightIndex) {
			if (copia[i].compareTo(copia[j]) <= 0) {
				array[k++] = copia[i++];
			} else {
				array[k++] = copia[j++];
			}
		}
		// agora os whiles caso uma parte acabe primeiro

		while(i <= middle){
			array[k++] = copia[i++];
		
		}

		while(j <= rightIndex){
			array[k++] = copia[j++];
			
		}


	}
}







