package br.edu.femass.gui;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuiDevolucao {
    private JList lstDevolucaoEmprestimo;
    private javax.swing.JPanel JPanel;
    private JButton devoluçãoButton;
    private JComboBox cboAtraso;

    public GuiDevolucao() {

        updateList();
        updateCombo();
        lstDevolucaoEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Emprestimo emprestimo = (Emprestimo) lstDevolucaoEmprestimo.getSelectedValue();
                if (emprestimo==null) return;
            }
        });
        cboAtraso.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Emprestimo emprestimo = (Emprestimo) cboAtraso.getSelectedItem();
                if (emprestimo==null) return;
            }
        });
    }

    private void updateList() {
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            lstDevolucaoEmprestimo.setListData(emprestimos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCombo() {
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            for (Emprestimo emprestimo: emprestimos) {
                if (emprestimo.getDataPrevistaDevolucao().isBefore(LocalDate.now())) {
                    List<Object> atrasados = new ArrayList<>();
                    atrasados.add(emprestimo);
                    cboAtraso.addItem(atrasados);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JPanel getJPanel() {
        return JPanel;
    }
}
