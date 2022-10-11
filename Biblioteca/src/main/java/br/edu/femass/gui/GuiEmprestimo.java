package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GuiEmprestimo {
    private JComboBox cboExemplarEmprestimo;
    private JButton btnConfirmarEmprestimo;
    private javax.swing.JPanel JPanel;
    private JList lstEmprestimoExemplar;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiEmprestimo() {

        updateCombo();

        btnConfirmarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        cboExemplarEmprestimo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Livro livro = (Livro) cboExemplarEmprestimo.getSelectedItem();
                if (livro==null) return;
            }
        });
        lstEmprestimoExemplar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstEmprestimoExemplar.getSelectedValue();

            }
        });
    }

    private void updateCombo() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro livro: livros) {
                cboExemplarEmprestimo.addItem(livro);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
