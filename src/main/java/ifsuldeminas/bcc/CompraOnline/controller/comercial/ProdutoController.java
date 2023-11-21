package ifsuldeminas.bcc.CompraOnline.controller.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.comercial.Produto;
import ifsuldeminas.bcc.CompraOnline.model.repositories.comercial.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //operacao Create
    @PostMapping
    public Produto save(@Valid @RequestBody Produto produto){
        return this.produtoRepository.save(produto);
    }

    //operacao Read
    @GetMapping
    public List<Produto> list(){
        return this.produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        Optional<Produto> opt = produtoRepository.findById(id);
        if(opt.isPresent()){
            Produto produto = opt.get();
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }else{
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    //operacao Updade
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produto){
        Optional<Produto> opt = produtoRepository.findById(id);
        if(opt.isPresent()){
            Produto produtoAux = opt.get();
            produtoAux.setNome(produto.getNome());
            produtoAux.setDescricao(produto.getDescricao());
            produtoAux.setPreco(produto.getPreco());
            produtoRepository.save(produtoAux);
            return new ResponseEntity<Produto>(produtoAux, HttpStatus.OK);
        }else{
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }

    //operacao Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        //falta implementar o tratamento de erro para a operacao Delete
        produtoRepository.deleteById(id);
    }
}
