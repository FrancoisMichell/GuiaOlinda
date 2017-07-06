package ufrpe.mobile.guiaolinda;

import java.util.UUID;

public class Local {
    private UUID mId;
    private String email;
    private String horario;
    private String nome_local;
    private String tipo;
    private String endereco;
    private String telefone;
    private String site;

    public Local(){
        mId = (UUID.randomUUID());
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return mId;
    }

    public String get_nome_local() {
        return nome_local;
    }

    public void set_nome_local(String nome_local) {
        this.nome_local = nome_local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
