/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulasestruturadedados;
import java.util.Scanner;
/**
 *
 * @author ISMAEL VILACIAN GOMES
 */
public class desafioDePilhas {
    public static void main(String[] args) throws Exception{
      Scanner input = new Scanner(System.in);
      desafioDePilhas acesso =  new desafioDePilhas();
      int contadorMovimento = 0;
      pilha pinoUm   = new pilha(4);
      pilha pinoDois = new pilha(4);
      pilha pinoTres = new pilha(4);
      
      int numeroUmLeitura, numeroDoisLeitura, verifica = 1;
      
      
      /*Aplica os valores iniciais na pilha, sendo aplicado um valor
        do menor parar o maior.
      */
      for(int i = 4; i>0; i--){
          pinoUm.push(i);
          pinoDois.push(0);
          pinoTres.push(0);
      }
      
      
      /*Um loop infinito que se encerra quando o jogador 
        finalizar o jogo ou desistir
      */
      while(verifica != 0){
          
          /* Printando os pinos */
          System.out.println("\nPino um:");
          pinoUm.print();
          System.out.println("\nPino dois:");
          pinoDois.print();
          System.out.println("\nPino tres:");
          pinoTres.print();
          System.out.println("");
          
          /*Condição para verificar se o jogo foi finalizado*/
          if(acesso.verificaSeAcabou(pinoDois) == true){
              System.out.println("################");
              System.out.println("# Voce venceu! #");
              System.out.println("################");
              /*
               Contador de jogadas realizadas
               */
              if(contadorMovimento == 15){
                  System.out.println("\nParabens jogada perfeita, movimentos :"+contadorMovimento);
              }else {
                  System.out.println("\nNumero de movimentos : " + contadorMovimento);
              }
              Thread.sleep(2000);
              break;
          }
          
          //Le numeros inteiro
          System.out.println("Digite o pino de origem (1-3):");
          numeroUmLeitura = input.nextInt();
          System.out.println("Digite o pino de destino (1-3):");
          numeroDoisLeitura = input.nextInt();
          
          /*Faz uma verificação se os numeros digitados estão dentro 
            dos parametros, caso esteja, o codigo continua*/
          if(numeroUmLeitura <=3 && numeroUmLeitura>=1
             && numeroDoisLeitura<=3 && numeroDoisLeitura>=1){
             
                if(numeroUmLeitura == 1 && numeroDoisLeitura == 2){
                    acesso.mudaPosições(pinoUm, pinoDois);
                    
            }else if(numeroUmLeitura == 1 && numeroDoisLeitura == 3){
                acesso.mudaPosições(pinoUm, pinoTres);
            }else if(numeroUmLeitura == 2 && numeroDoisLeitura == 1){
                acesso.mudaPosições(pinoDois, pinoUm);
            }else if(numeroUmLeitura == 2 && numeroDoisLeitura == 3){
                acesso.mudaPosições(pinoDois, pinoTres);
            }else if(numeroUmLeitura == 3 && numeroDoisLeitura == 1){
                acesso.mudaPosições(pinoTres, pinoUm);
            }else if(numeroUmLeitura == 3 && numeroDoisLeitura == 2){
                acesso.mudaPosições(pinoTres, pinoDois);
            }
                   
          }else if(numeroUmLeitura != 0 && numeroDoisLeitura != 0){
              System.out.println("Valores Invalidos!");
          }else if(numeroUmLeitura == 0 && numeroDoisLeitura == 0){
              /*Caso os valores de origem e destino for zero
                o jogador encerra o jogo*/ 
              System.out.println("\nEncerrado!");
              verifica = 0;
          }
          
          
          contadorMovimento++;
      }
      
    }
    
    //Metodo para fazer toda as movimentação entre os pinos
    public void mudaPosições(pilha pinoOrigem, pilha pinoDestino) throws Exception{
            
            //Aqui e o codigo pega o valor do pino que seja diferente zero
            int pinoOrigemAux = pinoOrigem.pop();
            while(pinoOrigemAux == 0){
                if(pinoOrigem.isEmpty()){
                    break;
                }
                pinoOrigemAux = pinoOrigem.pop();
            }
            /*Caso o codigo percorra todo o pino e não encontre nenhum 
              valor diferente de zero, quer dizer que o pino esta vazio
              e não sera possivel realizar o movimento*/
            if(pinoOrigemAux == 0){
                System.out.println("#########################");
                System.out.println("# Pino de origem vazio! #");
                System.out.println("#########################");
                Thread.sleep(2000);
                if(!pinoOrigem.isFull()){
                    while(!pinoOrigem.isFull()){
                        pinoOrigem.push(0);
                    }
                    
                }
            }else{
                int pinoDestinoAux = 0, auxOrigem = 0, auxDestino = 0;
                /*O numero ZERO quer dizer que a posição está "Vazia"
                  então, o while serve para tirar todos os valores da pilha
                  até que ela esteja sem nenhum valor gravado, para que consiga 
                  gravar o novo valor na pilha*/
                while(pinoOrigemAux == 0){
                    pinoOrigemAux = pinoOrigem.pop();
                    auxOrigem++;
                }
                while(pinoDestinoAux == 0){
                    if(pinoDestino.isEmpty()){
                        break;
                    }else{
                        pinoDestinoAux = pinoDestino.pop();
                        auxDestino++;
                    }
                }

                /*Esta condição faz uma verificação em que o ultimo numero tirado do
                  pino de origem tem que ser diferente de zero (não pode estar vazio)
                  e tambem faz uma verificação de a orgirem e menor que o destino*/
                if(pinoOrigemAux != 0 && pinoOrigemAux <= pinoDestinoAux || pinoDestinoAux == 0){
                    /*Verifica de o estado atual do pino e vazio ou não, caso for
                      vazio, e feito a gravação do valor atual, sem recuperar o estado 
                      atual do pino*/
                    if(pinoDestinoAux == 0){
                        //Grava o valor no pino de destino
                        pinoDestino.push(pinoOrigemAux);
                        //Verifica se a pilha não esta cheia
                        if(!pinoDestino.isFull()){
                            //Preenche o restante da pilha destino com ZERO (vazio)
                            for(int i = 0; i < auxDestino - 1; i++){
                                pinoDestino.push(0);
                            }
                        }
                        //Preenche o restante da pilha origem com ZERO (vazio)
                        while(!pinoOrigem.isFull()){
                            pinoOrigem.push(0);
                        }
                    }else {
                        pinoDestino.push(pinoDestinoAux);
                        pinoDestino.push(pinoOrigemAux);
                        for(int i = 0; i < auxDestino - 2; i++){
                            pinoDestino.push(0);
                        }
                        while(!pinoOrigem.isFull()){
                            pinoOrigem.push(0);
                        }
                    }



                }else {
                    //Volta as pilhas para os estados originais
                    System.out.println("#######################");
                    System.out.println("# Movimento invalido! #");
                    System.out.println("#######################");
                    Thread.sleep(2000);
                    pinoOrigem.push(pinoOrigemAux);
                    if(!pinoOrigem.isFull()){
                        while(!pinoOrigem.isFull()){
                            pinoOrigem.push(0);
                        }

                    }
                    pinoDestino.push(pinoDestinoAux);
                    if(!pinoDestino.isFull()){
                        while(!pinoDestino.isFull()){
                            pinoDestino.push(0);
                        }
                    }
                }

        }
    }
    
    //Metodo para verificar se o jogo acabou
    public boolean verificaSeAcabou(pilha pinoDois) throws Exception{
        
        int [] pino = new int [4];
       
        pino[0] = pinoDois.pop();
        pino[1] = pinoDois.pop();
        pino[2] = pinoDois.pop();
        pino[3] = pinoDois.pop();
        
        pinoDois.push(pino[3]);
        pinoDois.push(pino[2]);
        pinoDois.push(pino[1]);
        pinoDois.push(pino[0]);
       
        
        if(pino[0] == 1 && pino[1] == 2 && pino[2] == 3 && pino[3] == 4){
            return true;
        }else{
            return false;
        }
    }
}
