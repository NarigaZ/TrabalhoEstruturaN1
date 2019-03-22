public class Busca {
    public int Sequencial (String vetor[] , String busca){
        for (int i = 0 ; i < vetor.length ; i++ ) {
            if(vetor[i].equals(busca)){
                return i;
            }
        }
        return -1;
    }

    public int Binaria (String vetor[] , String busca){
        int meio;
        int inicio = 0 , fim;
        fim = vetor.length-1;
        while (inicio <= fim){
            meio = (inicio+fim)/2;
            if(vetor[meio] == busca ){
                return meio;
            }else if (vetor[meio].length() < busca.length() ){
                inicio = meio+1;
            }else if (vetor[meio].length() > busca.length()){
                fim = meio-1;
            }else if (vetor[meio].length() == busca.length()){
                for (int i = meio ; i >=0 ; i--){
                    if (vetor[i].length() < busca.length()){
                        inicio = i;
                    }
                }
                for (int i = meio ; i<=fim ; i++){
                    if(vetor[i].length() > busca.length()){
                        fim = i;
                    }
                }
                String Nvetor[] = new String[fim-inicio];
                int aux=inicio;
                for (int j=0 ; j <Nvetor.length ; j++){
                    Nvetor[j] = vetor[aux];
                    aux++;
                }
                return Sequencial(Nvetor,busca);
            }
        }
        return -1;
    }
}
