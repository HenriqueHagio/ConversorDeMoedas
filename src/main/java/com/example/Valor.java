package com.example;
import javax.swing.JOptionPane;

public class Valor {
    private String titulo;
    private double valor;

    Valor(double valor, String titulo) {
        this.titulo = titulo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void MostraValor() {
        boolean valorValido = false;
        while (!valorValido) {
            String valorInserido = JOptionPane.showInputDialog(null, "Insira o valor:", "Conversor de moedas",
                    JOptionPane.PLAIN_MESSAGE);

            try {

                double valorDouble = Double.parseDouble(valorInserido);
                this.valor = valorDouble;
                valorValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido!, Apenas numeros são aceitos", "Conversor de moedas",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}

