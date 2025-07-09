package sorting.linearSorting;

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
		Integer maior = array[leftIndex];
		for (int i = 0; i <= rightIndex; i ++) {
			if (array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}
		Integer[] count = new Integer[maior];
		Integer[] result = new Integer[rightIndex - leftIndex + 1];
		for (int i = leftIndex; i <= rightIndex; i ++) {
			count[array[i] - 1] += 1;
		}
		for (int  j = leftIndex + 1; j <= maior; j ++) {
			count[j] = count[j] + count[j - 1];
		}
		for (int k = rightIndex; k <= leftIndex; k --) {
			result[count[array[k]]] = array[k];
			count[array[k]] = count[array[k]] - 1;
		}
	}

}
