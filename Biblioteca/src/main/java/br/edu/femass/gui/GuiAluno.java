package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
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
        btnRegistrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno(txtNomeAluno.getText(), txtEnderecoAluno.getText(),
                            txtTelefoneAluno.getText(), txtMatriculaAluno.getText());
                    new DaoAluno().save(aluno);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiAluno guiAluno = new GuiAluno();
        JFrame frame = new JFrame();
        frame.setContentPane(guiAluno.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            List<Aluno> alunos = new DaoAluno().getAll();
            guiAluno.lstAluno.setListData(alunos.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.pack();

        frame.setVisible(true);

    }
}
