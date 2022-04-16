package br.com.ferias.jdbc;

import javax.swing.JOptionPane;

public class TestConnection {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: \n" +e);
        }
    }
}