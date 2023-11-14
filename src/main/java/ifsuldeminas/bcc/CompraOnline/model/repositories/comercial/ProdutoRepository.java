package ifsuldeminas.bcc.CompraOnline.model.repositories.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.comercial.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
