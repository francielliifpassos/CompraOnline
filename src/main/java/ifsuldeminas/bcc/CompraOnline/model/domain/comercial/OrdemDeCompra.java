package ifsuldeminas.bcc.CompraOnline.model.domain.comercial;

import ifsuldeminas.bcc.CompraOnline.model.domain.pessoal.Usuario;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class OrdemDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaCompra;
    @OneToMany(mappedBy = "ordemDeCompra")
    Set<Item> itens;
    @ManyToOne
    private Usuario usuario;
}
