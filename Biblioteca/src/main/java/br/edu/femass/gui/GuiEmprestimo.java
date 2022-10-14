package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
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
    private javax.swing.JPanel JPanel;
    private JButton btnCadastroAluno;
    private JButton btnCadastroProfesor;
    public JComboBox comboAluno;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiEmprestimo() {

        updateCombo();

        btnCadastroAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Emprestimo emprestimo = new Emprestimo((Leitor) comboAluno.getSelectedItem(),
                            (Exemplar) cboExemplarEmprestimo.getSelectedItem());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

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
