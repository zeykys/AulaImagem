package br.com.bossini.listaclientesarqdsis_cco;

/**
 * Created by rodrigo on 29/09/16.
 */

public class Cliente {

    private   int id;
    private String data;
    private String valor;
    private String nome;

    public Cliente(){
    }
    public Cliente(int id, String data, String valor, String nome) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFoto(){
        String foto = nome.replace('@','_');
        foto = foto.replace('.','_');
        return foto;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        if (id != other.id)
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }
}
