/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import interfaces.Controller;
import interfaces.Model;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuário
 */
public class MouseController implements Controller {

    private Model model;
    private StringBuilder numeroAtual = new StringBuilder();

    public MouseController(Model model) {
        this.model = model;
    }

    @Override
    public void alterarInput(String input) {
        numeroAtual.append(input);
        System.out.println("Input via Mouse: " + numeroAtual);
    }

    @Override
    public void alterarOperador(char operador) {
        if (numeroAtual.length() > 0) {
            enviarNumeroAtualParaModelo();
        }
        model.receberOperador(operador);
    }

    @Override
    public void calcular() {
        if (numeroAtual.length() > 0) {
            enviarNumeroAtualParaModelo();
        }
        model.calcular();
    }

    private void enviarNumeroAtualParaModelo() {
        double numero = Double.parseDouble(numeroAtual.toString());
        model.receberInput(numero);
        numeroAtual.setLength(0);
    }

    @Override
    public void limpar() {
        model.reset();
        numeroAtual.setLength(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
