package ifsuldeminas.bcc.CompraOnline.model.domain.comercial;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private OrdemDeCompra ordemDeCompra;
}
