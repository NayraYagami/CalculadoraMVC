/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.awt.event.KeyEvent;

/**
 *
 * @author Usuário
 */
public interface Controller {

    public void keyPressed(KeyEvent e);

    public void alterarInput(String input);

    public void alterarOperador(char operator);

    public void calcular();

    public void limpar();
}
