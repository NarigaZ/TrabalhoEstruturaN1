public class Ordenacao {

    public static String[] BubleSort(String vetor[], int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho - 1; j++) {
                if (vetor[j].length() > vetor[j + 1].length()) {
                    String aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
        return vetor;
    }

    public static String[] InsertionSort(String vetor[], int tamanho) {
        int j;
        String key;
        int i;
        for (j = 1; j < vetor.length; j++) {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i].length() > key.length()); i--) {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        return vetor;
    }

    public static String[] quickSort(String[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
        return vetor;
    }

    private static int separar(String[] vetor, int inicio, int fim) {
        String pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i].length() <= pivo.length())
                i++;
            else if (pivo.length() < vetor[f].length())
                f--;
            else {
                String troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    public static String[] selectionSort(String[] vetor) {
        for (int fixo = 0; fixo < vetor.length - 1; fixo++) {
            int menor = fixo;
            for (int i = menor + 1; i < vetor.length; i++) {
                if (vetor[i].length() < vetor[menor].length()) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                String t = vetor[fixo];
                vetor[fixo] = vetor[menor];
                vetor[menor] = t;
            }
        }
        return vetor;
    }
}
