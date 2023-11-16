package ifsuldeminas.bcc.CompraOnline.controller.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.comercial.Produto;
import ifsuldeminas.bcc.CompraOnline.model.repositories.comercial.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //operacao Create
    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return this.produtoRepository.save(produto);
    }

    //operacao Read
    @GetMapping
    public List<Produto> list(){
        return this.produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto show(@PathVariable Long id){
        return this.produtoRepository.getById(id);
    }

    //operacao Updade
    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto){
        Produto produtoAux = produtoRepository.getById(id);
        produtoAux.setNome(produto.getNome());
        produtoAux.setDescricao(produto.getDescricao());
        produtoAux.setPreco(produto.getPreco());
        return produtoRepository.save(produtoAux);
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
