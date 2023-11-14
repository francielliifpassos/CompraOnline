package ifsuldeminas.bcc.CompraOnline.controller.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.comercial.Produto;
import ifsuldeminas.bcc.CompraOnline.model.repositories.comercial.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
