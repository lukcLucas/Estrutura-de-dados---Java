public class ListaGenerics<T> { //Conhecido como operador "diamond"(diamante)<>
    private T[] elementos;
    private int tamanho;


    public ListaGenerics(int capacidade){
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0; // inializar o tamanho
    }
    /*
    public ListaGenerics(int capacidade, Class<T> tipoClasse){
        this.elementos =(T[]) array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0; // inializar o tamanho
    }*/
    
    
     
    
    // add elemento no final da lista 
    public boolean adiciona(T elemento){
        this.aumentaCapacidade();
       if(this.tamanho < this.elementos.length){
        this.elementos[this.tamanho] = elemento;
        this.tamanho++; 
        return true;
       } 

       return false;

        
    } //Add elemento em qualquer posicao

    public boolean adiciona(int posicao, T elemento){
         this.aumentaCapacidade();
        // verificar posicao do usuario ta passando pelo metodo e uma posicao valida 
        if(!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posicao invalida");
        }

       // move todo os elementos

       for(int i=this.tamanho-1; i>=posicao;i--){
            // remover elementos
           this.elementos[i + 1] = this.elementos[i];
       }
       // 0 1 2 3 4 5 6 = tamanho = 5
       // B C E F G + +
       // i=5


       this.elementos[posicao] = elemento;
       this.tamanho++;

        
        return false;
    }


    //adicionar elemento aumentar capacidade da lista

    private void aumentaCapacidade(){
        if(this.tamanho == this.elementos.length){

         T[] elementosNovos = (T[]) new Object[this.elementos.length *2];
          
         for (int i=0;i<this.elementos.length;i++){
            elementosNovos[i] = this.elementos[i];
         }
         
         this.elementos = elementosNovos;
        }
    }

    // metodo remove ---> remover o indice da lista 

    public void remove(int posicao ){
        if(!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posicao invalida");
        }

       for(int i=posicao;i<this.tamanho-1;i++){
          this.elementos[i] = this.elementos[i + 1];
          
       }

       this.tamanho--;



    }

    //Exercicio03- metodo remover elemento

   public void remove(T elemento){
     
    int pos = this.busca(elemento);

    if(pos > -1){
        this.remove(pos);
    }

     

}

    




   // obter elementos de uma posicao da lista 
    public T busca(int posicao){

        if(!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posicao invalida");
        }
        return this.elementos[posicao];
    }


    // verificar se elementos exixte na lista 

    public int  busca(T elemento){
          for(int i=0;i<this.tamanho;i++){
               if(this.elementos[i].equals(elemento)){
                   return i;
               }
          }
          return -1; // -1 eh uma posicao que nao existe 
    }

    //Exercicio04 - Metodo Obtem(get)

    public T obtem(int posicao){
        return this.busca(posicao);
    }


    // exercicio01 - metodo contem

    public boolean contem(T elemento){
       
         /*int pos =busca(elemento)

         if(pos > -1){
             return true
         }

         return false; */



        return busca(elemento) > -1 ; //>=0
    }

    //Exercicio02- metodo ultimo indice 

   public int ultimoIndice(T elemento){

   
    for(int i =this.tamanho-1; i>=0;i--){
        if(this.elementos[i].equals(elemento)){
            return i;
        }
    }
      
      return -1;

   }

   
  //Exercicio05 - Metodo remover todos elementos(clear)

   public void limpar(){
       //opcao 1
       //his.elementos =(T[]) new Object[this.elementos.length]

       //opcao 2
       //this.tamanho = 0

        //opcao 3

        for(int i=0;i<this.tamanho;i++){
            this.elementos[i] = null;
        }

        this.tamanho = 0;

   }





  public int tamanho(){
      return this.tamanho; // metodo para expor o tamanho 
  }
  //concartenar string 
  @Override 
  public String toString(){

       StringBuilder s = new StringBuilder();
       s.append("[");
    
       for(int i = 0; i < this.tamanho-1; i++){
            s.append(this.elementos[i]) ;
            s.append(", ");
           
       }if(this.tamanho > 0){
       s.append(this.elementos[this.tamanho-1]);
    }
      s.append("]");

      return  s.toString() ;
  } 
}
