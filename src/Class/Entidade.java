package Class;

import Class.Ponto2D;
import Map.Mundo;
import java.util.List;

public class Entidade {

    public Ponto2D posicao;
    public char simbolo;

    public Entidade(Ponto2D posicao, char simbolo) {
        this.posicao = posicao;
        this.simbolo = simbolo;
    }
    
     public Entidade() {
       
    }

    @Override
    public String toString() {
        return String.valueOf(simbolo);
    }

    public Ponto2D getPosicao() {
        return posicao;
    }

    public void setPosicao(Ponto2D posicao) {
        this.posicao = posicao;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

      public Entidade retornaEntidade(List<Entidade>entidades, char simbolo){
         for(Entidade entidade : entidades){
             if(entidade.getSimbolo() == simbolo){
                 return entidade;
             }
         }
         return null;
     }
      
      protected Boolean verificaRange(Entidade alvo, int range){
      if ((alvo.posicao.getX() >= (this.posicao.getX() - range) && alvo.posicao.getX() <= (this.posicao.getX() + range)) && (alvo.posicao.getY() >= (this.posicao.getY() - range) && alvo.posicao.getY() <= (this.posicao.getY() + range))){
          return true;
      }
        return false;
    }
     
    
}
