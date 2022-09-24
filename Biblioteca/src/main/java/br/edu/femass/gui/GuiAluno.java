package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiAluno {
    private JFormattedTextField txtNomeAluno;
    private JFormattedTextField txtEnderecoAluno;
    private JFormattedTextField txtTelefoneAluno;
    private javax.swing.JPanel JPanel;
    private JFormattedTextField txtMatriculaAluno;
    private JButton btnRegistrarAluno;
    private JList lstAluno;

    public JPanel getJPanel() { return JPanel; }

    public GuiAluno() {

        try {
            MaskFormatter mascara = new MaskFormatter("(##) #####-####");
            mascara.install(txtTelefoneAluno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        btnRegistrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(txtNomeAluno.getText(), txtEnderecoAluno.getText(),
                            txtTelefoneAluno.getText(), txtMatriculaAluno.getText());
                    new DaoAluno().save(aluno);
                    updateList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        lstAluno.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAluno.getSelectedValue();
                if (aluno==null) return;
                txtNomeAluno.setText(aluno.getNome());
                txtEnderecoAluno.setText(aluno.getEndereco());
                txtTelefoneAluno.setText(aluno.getTelefone());
                txtMatriculaAluno.setText(aluno.getMatricula());
            }
        });
    }

    private void updateList() {
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            lstAluno.setListData(alunos.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
