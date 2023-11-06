package br.com.lab360.task360.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static org.antlr.v4.runtime.misc.Utils.count;

@Entity
@Table(name = "cartao")
@Getter
@Setter

public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity usuarioAtribuido;

    @ElementCollection
    private List<String> links = new ArrayList<>();

    @ElementCollection
    private List<String> anexos = new ArrayList<>();

    private List<ChecklistItemEntity> checklist = new ArrayList<>();

    public double calcularPorcentagemConclusao() {
        long totalItens = checklist.size();
        long itensConcluidos = checklist.stream().filter(ChecklistItemEntity::isConcluido).count();

        return (itensConcluidos / (double) totalItens) * 100;
    }

    public void setLista(ListaEntity novaLista) {
    }

    public void setResponsavel(UserEntity responsavel) {
    }
}

