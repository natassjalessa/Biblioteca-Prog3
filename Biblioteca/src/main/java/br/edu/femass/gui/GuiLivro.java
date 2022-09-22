package br.edu.femass.gui;

import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class GuiLivro {
    private JFormattedTextField txtCodigoLivro;
    private javax.swing.JPanel JPanel;
    private JFormattedTextField txtTituloLivro;
    private JButton btnRegistrarLivro;
    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiLivro() {
        btnRegistrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtCodigoLivro.getText(), txtTituloLivro.getText());
                    new DaoLivro().save(livro);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiLivro guiLivro = new GuiLivro();
        JFrame frame = new JFrame("Livro");
        frame.setContentPane(guiLivro.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            List<Livro> livros = new DaoLivro().getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.pack();

        frame.setVisible(true);
    }
}
