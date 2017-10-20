# BatalhaNaval


Batalha naval

--------------------------------------------
classe Barco
    atributos
        int tamanho
        String posicao

 --------------------------------------------
classe Tabuleiro
    atributos
        String tabuleiro
    metodos 
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
    atributo

    metodos
        boolean atacar(String posicao);
            //ataca e se acertar devolve true e 
            //adiciona a posicao em um vetor 
            //para comparacao futura msmo 
            //para false

        

   
