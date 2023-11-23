package ifsuldeminas.bcc.CompraOnline.model.services.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.comercial.Produto;
import ifsuldeminas.bcc.CompraOnline.model.repositories.comercial.ProdutoRepository;
import ifsuldeminas.bcc.CompraOnline.model.exceptions.comercial.ProdutoNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> list(){
        return this.produtoRepository.findAll();
    }

    public Produto getById(Long id) throws ProdutoNotFoundException{
        Optional<Produto> opt = produtoRepository.findById(id);
        if(!opt.isPresent()){
            throw new ProdutoNotFoundException(id);
        }
        return opt.get();
    }

    public Produto update(Long id, Produto produto) throws ProdutoNotFoundException{
        Produto produtoAux = this.getById(id);
        produtoAux.setNome(produto.getNome());
        produtoAux.setDescricao(produto.getDescricao());
        produtoAux.setPreco(produto.getPreco());
        return produtoRepository.save(produtoAux);
    }

    public void deleteById(Long id) throws ProdutoNotFoundException{
        if(!this.produtoRepository.existsById(id)){
            throw new ProdutoNotFoundException(id);
        }
        this.produtoRepository.deleteById(id);
    }
}
