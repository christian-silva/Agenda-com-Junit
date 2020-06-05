package agenda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe responsável por armazenar o número do telefone e modelo de telefone informado.
 * @author Christian
 * @date 04-06-2020
 */
public class Telefones {

    private String numero;
    private String modelo;

    /**
     * Informa o numero e modelo do telefone
     *
     * @param numero Número do telefone
     * @param modelo Modelo do telefone
     */
    public Telefones(String numero, String modelo) {
        this.numero = numero;
        this.modelo = modelo;
    }

    /**
     * Obtém o telefone do modelo
     *
     * @return Obtém o telefone do modelo
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Obtém o modelo do telefone
     *
     * @return Obtém o modelo do telefone
     */
    public String getModelo() {
        return modelo;
    }

}
