/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author guispiger
 */
public class Calculadora {
    private int tamanho;
    private int elementos;

    public Calculadora(int tamanho, int elementos) {
        this.tamanho = tamanho;
        this.elementos = elementos;
    }
    
    public long permutacoes(){
        long qntPermutacoes = 0;
        qntPermutacoes = fatorial(tamanho) / fatorial(tamanho - elementos);
        return qntPermutacoes;
    }
    
    public long combinacoes(){
        long qntCombinacoes = 0;
        qntCombinacoes = fatorial(tamanho) / (fatorial(elementos) * fatorial(tamanho - elementos));
        return qntCombinacoes;
    }
    
    public static long fatorial( int x ) {
        long fat = 1;
        for (int i = x; i > 1; i--) {
            fat = fat * i;
        }
        return fat;
    }
    
}
