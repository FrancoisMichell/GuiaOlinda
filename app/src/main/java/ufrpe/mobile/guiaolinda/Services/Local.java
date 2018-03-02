package ufrpe.mobile.guiaolinda.Services;

import java.util.UUID;

public class Local {
    private UUID mId;
    private int id;
    private int imagem;
    private String image;
    private String email;
    private String horario;
    private String descricao;
    private String nome_local;
    private String tipo;
    private String endereco;
    private String telefone;
    private String site;
    private double latitude;
    private double longitude;
    private String preco;

    public Local() {
        mId = (UUID.randomUUID());
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getid() {
        return this.id;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
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

    public void setId(int id) {
        this.id = id;
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
