package Map;

import Class.Entidade;
import Class.Ponto2D;

public class Celula extends Entidade {
    
    private boolean bloqueado;

    public Celula(boolean bloqueado, Ponto2D posicao, char simbolo) {
        super(posicao, simbolo);
        this.bloqueado = bloqueado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
