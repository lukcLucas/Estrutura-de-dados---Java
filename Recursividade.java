//biblioteca java para caixas de texto 
import javax.swing.JOptionPane;
public class Recursividade {
    //metodo que chama ele mesmo
    //precisa de um ponto de parada 

    /*
      
    Rercursividade 

    trabalha de forma similar a um laço de repetição, 
    na verdade tudo que fazemos em laço, pode ser feito 
    em recursividade. A recursividade é nada mais nada 
    menos do que uma função dentro da outra e ela deve 
    ser pensada como uma pilha (estrutura de dados onde 
    o ultimo a entrar, deve ser o primeiro a sair).
    A estrutura dela consiste em descer até a base 
    fazendo os cálculos ou rotinas de cada instrução, 
    e então da base até o topo da pilha são empilhados 
    os resultados de cada instrução e no final o topo 
    contém o resultado que é retornado. 

    */



  //criando metodo principal
    public static void main(String[] args) {
        

       
        //variavel n recebendo o valor a ser fatorado

        int n = Integer.parseInt(("Digite um valor"));
       
        //objeto sendo instanciado

        Recursividade b = new Recursividade();

        //chamando o metodo recursivo para fatorar a variavel n, retornando
        //o resultado na propria variavel n

        n = b.fatorialRecursivo(n);


        // apresentando o resultado

        JOptionPane.showMessageDialog(null, "O fatorial e:" + n);

    }

   
  public int fatorialRecursivo(int num){ // metodo recursivo 
    
    // se numero e igual a 0, retorna 1

    if(num ==  0)
        return 1;
        
    


    // caso contrario, o metodo recursivo eh chamado

    return num*fatorialRecursivo(num-1);
  }
  /*
     
    importante lembrar também que a recursividade
    trabalha com o conceito de pilha e pode até
    substituir laços de repetição.

  */




}
