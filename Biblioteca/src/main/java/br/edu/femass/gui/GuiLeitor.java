package br.edu.femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLeitor {
    private javax.swing.JPanel JPanel;
    private JButton btnCadastroProfessor;
    private JButton btnCadastroAluno;
    private JButton btnEmprestimo;
    private JButton btnDevolucao;

    public JPanel getjPanel() {
        return JPanel;
    }

    public GuiLeitor() {
        btnCadastroProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiProfessor guiProfessor = new GuiProfessor();
                JFrame frame = new JFrame("Professor");
                frame.setContentPane(guiProfessor.getJPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnCadastroAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAluno guiAluno = new GuiAluno();
                JFrame frame = new JFrame("Aluno");
                frame.setContentPane(guiAluno.getJPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Emprestimo");
                frame.setContentPane(guiEmprestimo.getJPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        btnDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ActionEvent) {
                GuiDevolucao guiDevolucao = new GuiDevolucao();
                JFrame frame = new JFrame("Devolucao");
                frame.setContentPane(guiDevolucao.getJPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }


    public JPanel getJPanel() {
        return JPanel;
    }
}
