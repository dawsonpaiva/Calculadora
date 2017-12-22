/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.calculadora;

/**
 *
 * @author Dawson Paiva Lima 201719070016
 */
public class OperacaoAritmetica {

    public Double soma(Double num1, Double num2) {
        return num1 + num2;
    }

    public Double subtracao(Double num1, Double num2) {
        return num1 - num2;
    }

    public Double multiplicacao(Double num1, Double num2) {
        return num1 * num2;
    }

    public Double divisao(Double num1, Double num2) throws Exception {
        if (num2 == 0) {
            throw new RuntimeException("Erro: Divisão por zero!");
        }
        return num1 / num2;
    }

}
