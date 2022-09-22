package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiPrincipal {
    private javax.swing.JPanel JPanel;
    private JButton btnBibliotecario;
    private JButton btnAtendente;

    public guiPrincipal() {
        btnBibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Cliquei");
                GuiLeitor guiLeitor = new GuiLeitor();
                JFrame frame = new JFrame("Segunda tela");
                frame.setContentPane(guiLeitor.getJPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnAtendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                JFrame frame = new JFrame("Segunda tela");
                frame.setContentPane(guiLivro.getJPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        guiPrincipal guiPrincipal = new guiPrincipal();
        JFrame frame = new JFrame("Tela Principal");
        frame.setContentPane(guiPrincipal.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
