package br.edu.femass.gui;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;

import javax.swing.*;
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
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiProfessor guiProfessor = new GuiProfessor();
        JFrame frame = new JFrame();
        frame.setContentPane(guiProfessor.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            List<Professor> professores = new DaoProfessor().getAll();
            guiProfessor.lstProfessor.setListData(professores.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        frame.pack();
        frame.setVisible(true);
    }
}
