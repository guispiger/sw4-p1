/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.JogadorJaCadastradoException;
import java.util.ArrayList;
import modelo.Jogador;

/**
 *
 * @author guispiger
 */
public class JogadorDAO {
    private static ArrayList<Jogador> jogadores = new ArrayList<>();
    
    public static void inserir(Jogador j) throws JogadorJaCadastradoException{
        if(!jogadores.contains(j)){
            jogadores.add(j);
        } else{
            throw new JogadorJaCadastradoException();
        }
    }
    
    public static Jogador buscarPorNome(String nome){
        Jogador j = null;
        for (Jogador jogador : jogadores) {
            if(jogador.getNome().equalsIgnoreCase(nome)){
                j = jogador;
            }
        }
        return j;
    }
    
    public static ArrayList listar(){
        return jogadores;
    }
}
