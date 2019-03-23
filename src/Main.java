import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ordenacao t = new Ordenacao();
        Busca b = new Busca();
        long tempo1, tempo2;
        int op3;
        String nome = "";
        do {
            System.out.println("Escolha qual dicionario quer ordenar:");
            System.out.println("1 - English");
            System.out.println("2 - Bulgarian");
            System.out.println("3 - Spanish");
            op3 = in.nextInt();
        }while (op3<0 || op3>4);

        if (op3==1){
            nome = "./Files/English.txt";
        }else if (op3==2){
            nome = "./Files/Bulgarian.txt";
        }else if (op3==3){
            nome = "./Files/Spanish.txt";
        }

        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            int tamanho = Integer.parseInt(lerArq.readLine()); // lê a primeira linha
            String vetor[] = new String[tamanho];
            String vetorOrdenado[] = new String[tamanho];
            int i = 0;
            String linha = "";
            linha = lerArq.readLine();
            vetor[0] = linha;
            while (linha != null) { // a variável "linha" recebe o valor "null" quando o processo
                linha = lerArq.readLine(); // lê da segunda até a última linha
                i++;
                if (i < tamanho) {
                    vetor[i] = linha;// de repetição atingir o final do arquivo texto
                }
            }
            arq.close();
            int op = 1;

            do {
                System.out.println("Escolha o metodo de Ordenacao");
                System.out.println("1 - BubleSort");
                System.out.println("2 - SelectionSort");
                System.out.println("3 - QuickSort");
                System.out.println("4 - SelectionSort");
                System.out.println("0 - Sair");
                op = in.nextInt();
                switch (op) {
                    case 1:
                        tempo1 = System.currentTimeMillis();
                        vetorOrdenado = t.BubleSort(vetor, tamanho);
                        tempo2 = System.currentTimeMillis();
                        System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                        break;
                    case 2:
                        tempo1 = System.currentTimeMillis();
                        vetorOrdenado = t.InsertionSort(vetor,tamanho);
                        tempo2 = System.currentTimeMillis();
                        System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                        break;
                    case 3:
                        tempo1 = System.currentTimeMillis();
                        vetorOrdenado = t.quickSort(vetor,0,vetor.length-1);
                        tempo2 = System.currentTimeMillis();
                        System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                        break;
                    case 4:
                        tempo1 = System.currentTimeMillis();
                        vetorOrdenado = t.selectionSort(vetor);
                        tempo2 = System.currentTimeMillis();
                        System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                        break;
                }
            } while (op != 0);
            int op2 = 1;

            do {
                System.out.println("Escolha o metodo de Busca");
                System.out.println("1 - Sequencial");
                System.out.println("2 - Binaria");
                System.out.println("0 - Sair");
                op2 = in.nextInt();
                String palavra;
                int pos;
                switch (op2) {
                    case 1:
                        System.out.print("Qual palavra deseja buscar: ");
                        palavra = in.next();
                        pos = b.Sequencial(vetorOrdenado, palavra);
                        tempo1 = System.currentTimeMillis();
                        if (pos == -1) {
                            System.out.println("Nao contem palavra");
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                            break;
                        } else {
                            System.out.printf("Palavra na posicao [%d]", pos + 1);
                            System.out.println();
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                            break;
                        }
                    case 2:
                        System.out.print("Qual palavra deseja buscar: ");
                        palavra = in.next();
                        tempo1 = System.currentTimeMillis();
                        pos = b.Sequencial(vetorOrdenado, palavra);
                        if (pos == -1) {
                            System.out.println("Nao contem palavra");
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                            break;
                        } else {
                            System.out.printf("Palavra na posicao [%d]", pos + 1);
                            System.out.println();
                            tempo2 = System.currentTimeMillis();
                            System.out.printf("Tempo de Ordenação em segundos : %d\n",((tempo2 - tempo1))/1000);
                            break;
                        }
                }
            } while (op2 != 0);

            FileWriter arqs = new FileWriter(".\\Files\\Saida.txt");
            PrintWriter gravarArq = new PrintWriter(arqs);

            for (int j = 0; j < tamanho; j++) {
                gravarArq.println(vetorOrdenado[j] + "[" + vetorOrdenado[j].length() + "]");
            }
            arqs.close();
            System.out.println("Arquivo Gravado com Sucesso!");
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
    }
}