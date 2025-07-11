package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex < array.length && leftIndex >= 0 && array.length > 0) {
			Integer maior = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i ++) {
				if (array[i].compareTo(maior) > 0) {
					maior = array[i];
				}
			}
			Integer[] count = new Integer[maior + 1];
			Arrays.fill(count, 0);
			Integer[] result = new Integer[rightIndex - leftIndex + 1];
			for (int i = leftIndex; i <= rightIndex; i ++) {
				count[array[i]] ++;
			}
			for (int j = 1; j <= maior; j ++) {
				count[j] += count[j - 1];
			}
			for (int k = rightIndex; k >= leftIndex; k --) {
				result[count[array[k]] - 1] = array[k];
				count[array[k]] -=1 ;
			}
			for (int i = leftIndex; i <= rightIndex; i ++) {
				array[i] = result[i];
			}
		}
	}
}
