package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.model.Exemplar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class GuiEmprestimo {
    private JComboBox cboExemplarEmprestimo;
    private JButton btnConfirmarEmprestimo;
    private javax.swing.JPanel JPanel;
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
                Exemplar exemplar = (Exemplar) cboExemplarEmprestimo.getSelectedItem();
                if (exemplar==null) return;
            }
        });
    }

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
