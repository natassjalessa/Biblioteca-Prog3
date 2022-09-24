package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiProfessor {
    private JFormattedTextField txtNomeProfessor;
    private javax.swing.JPanel JPanel;
    private JFormattedTextField txtEnderecoProfessor;
    private JFormattedTextField txtTelefoneProfessor;
    private JFormattedTextField txtDisciplinaProfessor;
    private JButton btnRegistrarProfessor;
    private JList lstProfessor;

    public JPanel getJPanel() {
        return JPanel;
    }

    public GuiProfessor() {
        btnRegistrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Professor professor = new Professor(txtNomeProfessor.getText(), txtEnderecoProfessor.getText(),
                            txtTelefoneProfessor.getText(), txtDisciplinaProfessor.getText());
                    new DaoProfessor().save(professor);
                    updateList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        lstProfessor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) lstProfessor.getSelectedValue();
                if (professor==null) return;
                txtNomeProfessor.setText(professor.getNome());
                txtEnderecoProfessor.setText(professor.getEndereco());
                txtTelefoneProfessor.setText(professor.getTelefone());
                txtDisciplinaProfessor.setText(professor.getDisciplina());
            }
        });
    }

    private void updateList() {
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            lstProfessor.setListData(professores.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
