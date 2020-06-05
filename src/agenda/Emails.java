/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

/**
 * Classe responsável por adicionar emails 
 * @author Christian
 */
public class Emails {
    private String email;

    /**
     * Email do Contato
     * @param email Email do contato
     */
    public Emails(String email) {
        this.email = email;
    }
    /**
     * Obtém o email do contato
     * @return Obtém o email do contato
     */
    public String getEmail() {
        return email;
    }
    
    
}
