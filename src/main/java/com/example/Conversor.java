package com.example;

import javax.swing.JOptionPane;

public class Conversor {
    private static void converteMoeda(String currencyCode, double valorInserido) {
        try {
            double Quote = HgBrasilApi.getCurrencyQuote(currencyCode);
            double converte = valorInserido / Quote;
            JOptionPane.showMessageDialog(null, "O valor da conversão é " + converte);

        } catch (Exception e) {
            System.err.println("Erro ao obter a cotação: " + e.getMessage());
        }
    }

    private static void reverteMoeda(String currencyCode, double valorInserido) {
        try {
            double Quote = HgBrasilApi.getCurrencyQuote(currencyCode);
            double converte = valorInserido * Quote;
            JOptionPane.showMessageDialog(null, "O valor da conversão é " + converte);

        } catch (Exception e) {
            System.err.println("Erro ao obter a cotação: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        boolean continua = true;
        while (continua) {
            String[] opcoes = { "Conversor de moedas" };
            MostraMensagem opcao = new MostraMensagem(opcoes, "Conversor de moedas");
            String opcaoSelecionada = opcao.exibir();

            Valor valor = new Valor(0, "Input");
            valor.MostraValor();
            double valorInserido = valor.getValor();

            String[] moedas = { "De Reais a Dólares", "De Reais a Euros", "De Reais a Libras", "De Reais a Yenes",
                    "De Reais a Yuan", "De Dólares a Reais", "De Euros a Reais", "De Libras a Reais",
                    "De Yenes a Reais", "De Yuan a Reais" };
            MostraMensagem moeda = new MostraMensagem(moedas, "Moedas");
            String moedaSelecionada = moeda.exibir();

            String currencyCode;
            switch (moedaSelecionada) {
                case "De Reais a Dólares":
                    currencyCode = "USD";
                    converteMoeda(currencyCode, valorInserido);
                    break;
                case "De Reais a Euros":
                    currencyCode = "EUR";
                    converteMoeda(currencyCode, valorInserido);

                    break;
                case "De Reais a Libras":
                    currencyCode = "GBP";
                    converteMoeda(currencyCode, valorInserido);

                    break;
                case "De Reais a Yenes":
                    currencyCode = "JPY";
                    converteMoeda(currencyCode, valorInserido);

                    break;
                case "De Reais a Yuan":
                    currencyCode = "CNY";
                    converteMoeda(currencyCode, valorInserido);
                    break;
                case "De Dólares a Reais":
                    currencyCode = "USD";
                    reverteMoeda(currencyCode, valorInserido);
                    break;
                case "De Euros a Reais":
                    currencyCode = "EUR";
                    reverteMoeda(currencyCode, valorInserido);
                    break;
                case "De Libras a Reais":
                    currencyCode = "GBP";
                    reverteMoeda(currencyCode, valorInserido);
                    break;
                case "De Yenes a Reais":
                    currencyCode = "JPY";
                    reverteMoeda(currencyCode, valorInserido);
                    break;
                case "De Yuan a Reais":
                    currencyCode = "CNY";
                    reverteMoeda(currencyCode, valorInserido);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Moeda inválida.");
                    break;
            }

            int confirma = JOptionPane.showConfirmDialog(null, "Deseja Continuar ?");

            if (confirma == JOptionPane.YES_OPTION) {
                continua = true;
            } else if(confirma == JOptionPane.NO_OPTION) {
                continua = false;
                JOptionPane.showMessageDialog(null, "Programa finalizado");
            } else if(confirma == JOptionPane.CANCEL_OPTION)  {
                JOptionPane.showMessageDialog(null, "Programa concluido");

            }

        }
    }
}
