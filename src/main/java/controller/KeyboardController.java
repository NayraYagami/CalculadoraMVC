/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import interfaces.Controller;
import interfaces.Model;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import interfaces.View;

/**
 *
 * @author Usuário
 */
public class KeyboardController implements Controller, KeyListener {

    private Model model;
    private View view;
    private StringBuilder numeroAtual = new StringBuilder();

    public KeyboardController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void alterarInput(String input) {
        numeroAtual.append(input);
        System.out.println("Input via Mouse: " + numeroAtual);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar)) {
            alterarInput(String.valueOf(Character.getNumericValue(keyChar)));
            view.atualizarDisplay(numeroAtual.toString());  // Atualiza o display diretamente
        } else {
            switch (keyChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    if (numeroAtual.length() > 0) {
                        enviarNumeroAtualParaModelo();
                    }
                    model.receberOperador(keyChar);
                    view.atualizarDisplay(numeroAtual.toString() + keyChar); // Atualiza display com o operador
                    break;
                case '=':
                case KeyEvent.VK_ENTER:
                    calcular();
                    break;
                case 'c':
                case 'C':
                    limpar();
                    break;
            }
        }
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
        System.out.println("Enviando para o modelo: " + numero);
    }

    @Override
    public void limpar() {
        model.reset();
        numeroAtual.setLength(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
