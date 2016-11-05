package br.com.bossini.listaclientesarqdsis_cco;

import java.util.ArrayList;

/**
 * Created by asbonato on 9/18/16.
 */
public class Data {
    public static Cliente[] _lista;

    public static Cliente[] geraListaClientes(){
        if(_lista == null) {
            Cliente[] lista = new Cliente[6];
            lista[0] = new Cliente(1,"15/10/2016","-50,00","lm@usjt.br");
            lista[1] = new Cliente(2,"19/10/2016","-105,00","jk@usjt.br");
            lista[2] = new Cliente(3,"24/10/2016","-20,00","ab@usjt.br");
            lista[3] = new Cliente(4,"01/11/2016","-250,00","fg@usjt.br");
            lista[4] = new Cliente(5,"05/11/2016","-2.500,00","hi@usjt.br");
            lista[5] = new Cliente(6,"11/11/2016","-30,00","cd@usjt.br");

            _lista = lista;
        }
        return _lista;
    }

    public static Cliente[] buscaClientes(String chave){
        Cliente[] lista = geraListaClientes();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Cliente> subLista = new ArrayList<>();
            for(Cliente cliente:lista){
                if(cliente.getData().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(cliente);
                }
            }
            return subLista.toArray(new Cliente[0]);
        }
    }
}