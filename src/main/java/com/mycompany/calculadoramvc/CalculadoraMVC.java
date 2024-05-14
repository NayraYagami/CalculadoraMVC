/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.calculadoramvc;

import controller.KeyboardController;
import controller.MouseController;
import interfaces.Controller;
import interfaces.Model;
import interfaces.View;
import model.CalculadoraModel;
import view.SimpleView;

/**
 *
 * @author Usuário
 */
public class CalculadoraMVC {

    public static void main(String[] args) {
        Model model = new CalculadoraModel();
        View view = new SimpleView();
        Controller mouseController = new MouseController(model);
        Controller keyboardController = new KeyboardController(model, view);
        model.addView(view);
        view.addControllers(mouseController, keyboardController);
    }
}
