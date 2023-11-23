package ifsuldeminas.bcc.CompraOnline.exceptions.comercial;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(Long id){
        super("Produto #" + id + " não encontrado");
    }
}
