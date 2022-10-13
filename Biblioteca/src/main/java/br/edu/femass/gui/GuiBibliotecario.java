package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBibliotecario {
    private JButton btnCadastroLivro;
    private JButton btnCadastrarExemplar;
    private javax.swing.JPanel JPanel;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiBibliotecario() {
        btnCadastroLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                GuiAutor guiAutor = new GuiAutor();
                JFrame frame = new JFrame("Cadastro");
                int result = JOptionPane.showConfirmDialog(frame,
                        "Voce ja cadastrou o autor do livro?", "Cadastro",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    frame.setContentPane(guiLivro.getJPanel());

                } else if (result == JOptionPane.NO_OPTION){
                    frame.setContentPane(guiAutor.getJPanel());
                }
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        btnCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Cadastro Exemplar");
                frame.setContentPane(guiExemplar.getJPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
