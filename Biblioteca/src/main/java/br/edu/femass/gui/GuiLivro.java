package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GuiLivro {
    private javax.swing.JPanel JPanel;
    private JFormattedTextField txtTituloLivro;
    private JButton btnRegistrarLivro;
    private JList lstAutorLivro;


    public JPanel getJPanel() {
        return JPanel;
    }



    public GuiLivro() {

        updateList();
        btnRegistrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = (Autor) lstAutorLivro.getSelectedValue();
                    Livro livro = new Livro(txtTituloLivro.getText(), autor);
                    livro.atualizarCodigo();
                    new DaoLivro().save(livro);
                    JOptionPane.showMessageDialog(null, "Cadastro do livro realizado");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        lstAutorLivro.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ListSelectionEvent) {
                try {
                    Autor autor = (Autor) lstAutorLivro.getSelectedValue();
                    if(autor==null) return;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    private void updateList() {
        try {
            List<Autor> autores = new DaoAutor().getAll();
            lstAutorLivro.setListData(autores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
