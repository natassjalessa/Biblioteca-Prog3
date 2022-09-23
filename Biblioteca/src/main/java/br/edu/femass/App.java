package br.edu.femass;

import br.edu.femass.gui.guiPrincipal;


import javax.swing.*;

public class App {

    public static void main(String[] args) {
        guiPrincipal guiPrincipal = new guiPrincipal();
        JFrame frame = new JFrame("Tela Principal");
        frame.setContentPane(guiPrincipal.getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
