package com.example;

import javax.swing.JOptionPane;

public class MostraMensagem  {
    private String[] opcoes;
    private String titulo;

    public String[] getOpcoes() {
        return opcoes;
    }

    MostraMensagem (String[] opcoes, String titulo) {
        this.opcoes = opcoes;
        this.titulo = titulo;
    }

    public String exibir() {
        return (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Conversor de moedas",
                JOptionPane.DEFAULT_OPTION, null, opcoes, opcoes[0]);

    }

}
