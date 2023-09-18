/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controle;

import dao.JogadorDAO;
import exceptions.JogadorJaCadastradoException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Jogador;

/**
 *
 * @author guispiger
 */
@Named(value = "jogoBean")
@SessionScoped
public class JogoBean implements Serializable {

    private String nome;
    private Jogador jogador;
    private boolean ganhou;
    private char opcaoJogador;
    private char opcaoComp;
    
    
    /**
     * Creates a new instance of JogoBean
     */
    public JogoBean() {
    }

    public char getOpcaoJogador() {
        return opcaoJogador;
    }

    public void setOpcaoJogador(char opcaoJogador) {
        this.opcaoJogador = opcaoJogador;
    }

    public char getOpcaoComp() {
        return opcaoComp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
    public ArrayList getJogadores(){
        return JogadorDAO.listar();
    }
    
    public String entrar(){
        jogador = JogadorDAO.buscarPorNome(nome);
        
        if(jogador == null){
            jogador = new Jogador();
            jogador.setNome(nome);
            try {
                JogadorDAO.inserir(jogador);
            } catch (JogadorJaCadastradoException ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Jogador já existe!!"));
            }
        }
        
        return "jogada";
        
    }
    
    public String jogar(){    
       jogadaComp();
       
       jogador.addJogo();
        
        switch (opcaoJogador) {
            case 'p':
                //pedra
                if(opcaoComp == 'p'){
                    jogador.addEmpate();
                }else if (opcaoComp == 'a'){
                    jogador.addDerota();
                }else{
                    jogador.addVitoria();
                    ganhou = true;
                }
                break;
            case 't':
                //tesoura
                if(opcaoComp == 't'){
                    jogador.addEmpate();
                }else if (opcaoComp == 'p'){
                    jogador.addDerota();
                }else{
                    jogador.addVitoria();
                    ganhou = true;
                }
                break;    
            case 'a':
                //papel
                if(opcaoComp == 'a'){
                    jogador.addEmpate();
                }else if (opcaoComp == 't'){
                    jogador.addDerota();
                }else{
                    jogador.addVitoria();
                    ganhou = true;
                }
                break;
            default:
                throw new AssertionError();
        }
        return "resultado";
    }
    
    private void jogadaComp(){
        Random rnd = new Random();
        int ale = rnd.nextInt(3) + 1;
        
        if(ale == 1){
            //pedra
            this.opcaoComp = 'p';
        } else if(ale == 2){
            //tesoura
            this.opcaoComp = 't';
        } else {
            //papel
            this.opcaoComp = 'a';
        }
    } 
}