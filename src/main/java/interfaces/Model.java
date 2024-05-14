/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

/**
 *
 * @author Usuário
 */
public interface Model extends Publisher{

    public void addView(View view);

    public void receberInput(double parseDouble);

    public void receberOperador(char operador);

    public void calcular();

    public void reset();
    
}
