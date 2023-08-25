package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length != 0){
			if(leftIndex < rightIndex){
				int pivotIndex = pickPivot(array, leftIndex, rightIndex);
				sort(array, leftIndex, pivotIndex - 1); //chamada recursiva que pega a parte inferior ao pivot
				sort(array, pivotIndex + 1, rightIndex); // chamada recursiva que pega a parte superior ao pivot
			}
		}
	}

	public int pickPivot(T[] array, int leftIndex, int rightIndex){
		int mid = (leftIndex + rightIndex) / 2;

		T[] arrayOrganizado = (T[]) new Comparable[]{array[leftIndex], array[mid], array[rightIndex]};
		Arrays.sort(arrayOrganizado);

		if (arrayOrganizado[1] == array[leftIndex]) {
			return leftIndex;
		}else if(arrayOrganizado[1] == array[mid]){ 
			 return mid;
		}else{ 
			return rightIndex;
		}
		
	}
	
}
