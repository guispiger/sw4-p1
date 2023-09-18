/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author aluno
 */
@Named(value = "navBean")
@SessionScoped
public class NavegacaoBean implements Serializable {

    /**
     * Creates a new instance of NavegacaoBean
     */
    public NavegacaoBean() {
    }
    
    public String jogarNovamente(){
        return "jogada";
    }
    
    public String estatisticas(){
        return "estatisticas";
    }
    
    public String inicio(){
        return "index";
    }
    
}
