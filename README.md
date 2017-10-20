# BatalhaNaval


Batalha naval

--------------------------------------------
classe Barco
    Atributos
        int tamanho
        String posicao

 --------------------------------------------
classe Tabuleiro
    Atributos
        String tabuleiro
    Metodos 
        String posicionarBarco(Barco barco);
            //define a posicao na matriz e retorna
            //a posicao para comparacao futura

        boolean verificaPosicao(String posicao);
              //dentro deste metodo define se é      
              //horizontal ou vertical.
              //verifica se esta vazio ou se existe a          
              //posicao desejada, chama no 
              //metodo posicionarBarco();

classe Jogador
    Atributo

    Metodos
        boolean atacar(String posicao);
            //ataca e se acertar devolve true e 
            //adiciona a posicao em um vetor 
            //para comparacao futura msmo 
            //para false

        

   
