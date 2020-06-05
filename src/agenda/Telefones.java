package agenda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Classe respons�vel por armazenar o n�mero do telefone e modelo de telefone informado.
 * @author Christian
 * @date 04-06-2020
 */
public class Telefones {

    private String numero;
    private String modelo;

    /**
     * Informa o numero e modelo do telefone
     *
     * @param numero N�mero do telefone
     * @param modelo Modelo do telefone
     */
    public Telefones(String numero, String modelo) {
        this.numero = numero;
        this.modelo = modelo;
    }

    /**
     * Obt�m o telefone do modelo
     *
     * @return Obt�m o telefone do modelo
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Obt�m o modelo do telefone
     *
     * @return Obt�m o modelo do telefone
     */
    public String getModelo() {
        return modelo;
    }

}
