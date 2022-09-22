package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAutor {
    private JTextField txtNome;
    private JFormattedTextField txtSobrenome;
    private JFormattedTextField txtNacionalidade;
    private JButton btnRegistrar;
    private javax.swing.JPanel JPanel;
    private JList lstAutor;

    public GuiAutor() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(txtNome.getText(), txtSobrenome.getText(), txtNacionalidade.getText());
                    new DaoAutor().save(autor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiAutor guiAutor = new GuiAutor();
        JFrame frame = new JFrame("Aula");
        frame.setContentPane(guiAutor.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //MaskFormatter mascara = new MaskFormatter()

        try {
            List<Autor> autores = new DaoAutor().getAll();
            guiAutor.lstAutor.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.pack();

        frame.setVisible(true);
    }
}
