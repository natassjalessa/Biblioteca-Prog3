package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GuiLivro {
    private JFormattedTextField txtCodigoLivro;
    private javax.swing.JPanel JPanel;
    private JFormattedTextField txtTituloLivro;
    private JButton btnRegistrarLivro;
    private JComboBox cboAutorLivro;

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
                    updateCombo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        cboAutorLivro.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    List<Autor> autores = new DaoAutor().getAll();
                    if (autores==null) return;
                    GuiAutor guiAutor = new GuiAutor();
                    guiAutor.getLstAutor().getSelectedValue();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void updateCombo() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            for (Autor autor: autores) {
                cboAutorLivro.addItem(autor);
            }
        } catch (Exception c) {
            throw new RuntimeException(c);
        }
    }
}
