/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.Model;
import interfaces.Subscriber;
import interfaces.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class CalculadoraModel implements Model {

    private double resultado = 0.0;
    private double operando = 0.0;
    private char operador = ' ';
    private List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void addView(View view) {
        subscribers.add(view);
    }

    @Override
    public void avisar(Subscriber subscriber) {
        subscriber.receberAviso(resultado);
    }

    @Override
    public void receberInput(double input) {
        System.out.println("Aqui no receive: " + input);
        operando = input;
    }

    @Override
    public void receberOperador(char operador) {

        System.out.println("Operando atual" + resultado + "Lastre" + operando);
        if (this.operador != ' ') {
            calcular();
        } else if (resultado != 0.0) {
            this.operando = 0;
            this.operador = operador;
            return;
        } else {
            resultado = operando;
        }

        this.operando = 0;
        this.operador = operador;
    }

    @Override
    public void calcular() {
        switch (operador) {
            case '+':
                resultado += operando;
                break;
            case '-':
                resultado -= operando;
                break;
            case '*':
                resultado *= operando;
                break;
            case '/':
                if (operando != 0) {
                    resultado /= operando;
                } else {
                    resultado = Double.POSITIVE_INFINITY;
                }
                break;
        }
        operando = 0;
        operador = ' ';
        notifyAllSubscribers();
        System.out.println("Resultado" + resultado);
    }

    @Override
    public void reset() {
        resultado = 0.0;
        operando = 0.0;
        operador = ' ';
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        for (Subscriber sub : subscribers) {
            sub.receberAviso(resultado);
        }
    }

}
