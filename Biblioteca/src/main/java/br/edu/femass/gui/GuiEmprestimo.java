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
    private JButton btnCadastroAluno;
    private JButton btnCadastroProfesor;
    private JList lstEmprestimoExemplar;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiEmprestimo() {

        updateCombo();
        //updateList();

        cboExemplarEmprestimo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                    Exemplar exemplar = (Exemplar) cboExemplarEmprestimo.getSelectedItem();
                    if (exemplar==null) return;
            }
        });
        /*lstEmprestimoExemplar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                Exemplar exemplar = (Exemplar) lstEmprestimoExemplar.getSelectedValue();
                if (exemplar==null) return;

            }
        });*/
    }

    /*private void updateList() {
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            lstEmprestimoExemplar.setListData(exemplares.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    private void updateCombo() {
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            for (Exemplar exemplar: exemplares) {
                cboExemplarEmprestimo.addItem(exemplar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
