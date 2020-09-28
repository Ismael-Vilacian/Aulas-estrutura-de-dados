package aulasestruturadedados;

/**
 * @author ISMAEL VILACIAN GOMES
 * 
 * */
public class pilha {


    /*Topo da pilha, onde deve ser empilhado e desempilhado*/
    int top;

    /*Tamanho máximo da pilha*/
    int size;

    /*Estrutura estática da pilha*/
    int stack[];
    
    
    pilha(int size) {
        this.top = -1;
        this.size = size;
        this.stack = new int [size];
    }

    


    
    /**Função responsável por empilhar, recebe número por parâmetro e empilha no topo*/
    public void push(int number) throws Exception {
        //Verifica se pilha está cheia. Se estiver cheia não empilha.
        if(isFull()) {
            System.out.println("Pilha cheia!");
            throw new Exception("Pilha cheia");
        } else{
            top++;
            stack[top]=number;
        }
    }

    /**Função responsável por desempilhar, decrementa o topo, perdendo a referência do elemento. E retorna o elemento*/
    public int pop() throws Exception {
        //Verifica se pilha está vazia. Se estiver não retorna nada.
        if(isEmpty()){
            System.out.println("Pilha vazia");
            throw new Exception("Pilha Vazia");
        } else {
            int numero = stack[top];
            top--;
            return numero;
        }
    }

    /**Função responsável por verificar se pilha está vazia*/
    public boolean isEmpty() {
       return top == -1;
    }
    
    /**Função responsável por verificar se pilha está cheia*/
    public boolean isFull() {
        return top == size - 1;
    }

    /**Função responsável por informar o tamamnho atual da pilha*/
    public int lenght() {
        return this.size - 1;
    }
    
    /**Função responsável por printar os elementos da pilha*/
    public void print() throws Exception {
        if(isEmpty()) {
            System.out.println("Pilha vazia");
            throw new Exception("Pilha Vazia");
        }
        
        for(int topAux = this.top; topAux >=0; topAux--) {
            System.out.println(this.stack[topAux]);
        }
    }
}