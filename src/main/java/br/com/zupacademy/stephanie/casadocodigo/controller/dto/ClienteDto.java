package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Cliente;
import br.com.zupacademy.stephanie.casadocodigo.model.Estado;
import br.com.zupacademy.stephanie.casadocodigo.model.Pais;
import br.com.zupacademy.stephanie.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.ObjectExists;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

public class ClienteDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;


    @NotBlank
    @Column(nullable = false, unique = true)
    private String documento;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @ObjectExists(field = "id", entity = Pais.class)
    private Long pais;

    private Long estado;

    public ClienteDto(Long id, String email, String documento, String nome,
                      String sobrenome, String endereco, String complemento, String cidade, String cep, String telefone, Long pais, Long estado) {
        this.id = id;
        this.email = email;
        this.documento = documento;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.pais = pais;
        this.estado = estado;
    }

    public ClienteDto() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Optional<Pais> paisObj = paisRepository.findById(pais);
        Cliente cliente = new Cliente(id, email, nome, sobrenome, documento, endereco, complemento,cidade, paisObj.get(), cep, telefone);

        if(estadoIsPresent()){
            Optional<Estado> estadoObj = estadoRepository.findById(estado);
            cliente.setEstado(estadoObj.get());
        }
        return cliente;
    }

    public boolean estadoIsPresent(){
        return this.estado != null;
    }

}
