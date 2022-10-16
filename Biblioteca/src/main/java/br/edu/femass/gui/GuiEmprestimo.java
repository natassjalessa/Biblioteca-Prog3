package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private javax.swing.JPanel JPanel;
    private JList lstEmprestimo;
    private JList lstLeitorEmprestimo;
    private JButton btnRegistarEmprestimo;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiEmprestimo() {

        updateList();

        btnRegistarEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = (Exemplar) lstEmprestimo.getSelectedValue();
                    Leitor leitor = (Leitor) lstLeitorEmprestimo.getSelectedValue();
                    Emprestimo emprestimo = new Emprestimo(exemplar, leitor);
                    new DaoEmprestimo().save(emprestimo);
                    JOptionPane.showMessageDialog(null, "Emprestimo feito");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        lstEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Exemplar exemplar = (Exemplar) lstEmprestimo.getSelectedValue();
                if (exemplar==null) return;
            }
        });
        lstLeitorEmprestimo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Leitor leitor = (Leitor) lstLeitorEmprestimo.getSelectedValue();
                if (leitor==null) return;
            }
        });
    }

    private void updateList() {
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            List<Aluno> alunos = new DaoAluno().getAll();
            List<Professor> professores = new DaoProfessor().getAll();
            List<Leitor> leitores = new ArrayList<>();
            leitores.addAll(alunos);
            leitores.addAll(professores);
            this.lstEmprestimo.setListData(exemplares.toArray());
            this.lstLeitorEmprestimo.setListData(leitores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
