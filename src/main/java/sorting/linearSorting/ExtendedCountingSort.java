package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	//versao final
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex < array.length && leftIndex >= 0 && array.length > 0) {
			Integer maior = array[leftIndex];
			Integer menor = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i ++) {
				if (array[i].compareTo(maior) > 0) {
					maior = array[i];
				}
				if (array[i].compareTo(menor) < 0) {
					menor = array[i];
				}
			}
			Integer[] count = new Integer[maior - menor + 1];
			Arrays.fill(count, 0);
			Integer[] result = new Integer[rightIndex - leftIndex + 1];
			for (int i = leftIndex; i <= rightIndex; i ++) {
				count[array[i] - menor] ++;
			}
			for (int j = 1; j < count.length; j ++) {
				count[j] += count[j - 1];
			}
			for (int k = rightIndex; k >= leftIndex; k --) {
				result[count[array[k] - menor] - 1] = array[k];
				count[array[k] - menor] -=1 ;
			}
			for (int i = leftIndex; i <= rightIndex; i ++) {
				array[i] = result[i];
			}
		}
	}

}
