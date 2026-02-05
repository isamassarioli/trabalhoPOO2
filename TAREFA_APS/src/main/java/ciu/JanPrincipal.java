package ciu;

import javax.swing.*;
import cci.ControladorPrincipal;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class JanPrincipal extends javax.swing.JFrame implements ActionListener {

    private ControladorPrincipal controlador;
    private JButton botao1, botao2, botao3, botao4;
    private JPanel panel;

    public JanPrincipal(ControladorPrincipal c) {

        super("Cadastro de Curso");

        controlador = c;
        panel = new JPanel();
        panel.setBackground(Color.red);

        this.setContentPane(panel);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        botao1 = new JButton("Cadastrar Curso");
        botao1.setVisible(true);
        botao1.setBackground(Color.white);
        botao1.setEnabled(true);
        botao1.setMnemonic(KeyEvent.VK_B);
        botao1.setText("CADASTRAR CURSO");
        botao1.setForeground(Color.black);
        botao1.setToolTipText("Clique aqui para cadastrar um curso");
        botao1.setHorizontalTextPosition(AbstractButton.RIGHT);
        botao1.addActionListener(this);
        botao1.setFont(new Font("Script", Font.ITALIC, 20));

        botao2 = new JButton("Cadastrar Aluno");
        botao2.setVisible(true);
        botao2.setBackground(Color.white);
        botao2.setEnabled(true);
        botao2.setMnemonic(KeyEvent.VK_B);
        botao2.setText("CADASTRAR ALUNO");
        botao2.setForeground(Color.black);
        botao2.setToolTipText("Clique aqui para cadastrar um aluno");
        botao2.setHorizontalTextPosition(AbstractButton.RIGHT);
        botao2.addActionListener(this);
        botao2.setFont(new Font("Script", Font.ITALIC, 20));

        botao3 = new JButton("Cadastrar Professor");
        botao3.setVisible(true);
        botao3.setBackground(Color.white);
        botao3.setEnabled(true);
        botao3.setMnemonic(KeyEvent.VK_B);
        botao3.setText("CADASTRAR PROFESSOR");
        botao3.setForeground(Color.black);
        botao3.setToolTipText("Clique aqui para cadastrar um professor");
        botao3.setHorizontalTextPosition(AbstractButton.RIGHT);
        botao3.addActionListener(this);
        botao3.setFont(new Font("Script", Font.ITALIC, 20));

        botao4 = new JButton("Cadastrar Turma");
        botao4.setVisible(true);
        botao4.setBackground(Color.white);
        botao4.setEnabled(true);
        botao4.setMnemonic(KeyEvent.VK_B);
        botao4.setText("CADASTRAR TURMA");
        botao4.setForeground(Color.black);
        botao4.setToolTipText("Clique aqui para cadastrar uma turma");
        botao4.setHorizontalTextPosition(AbstractButton.RIGHT);
        botao4.addActionListener(this);
        botao4.setFont(new Font("Script", Font.ITALIC, 20));


        panel.add(botao1);
        this.setSize(600,200);
        this.setLocation(50,50);
        this.setTitle("CADASTRO DE CURSO");

        panel.add(botao2);
        this.setSize(600,200);
        this.setLocation(50,50);
        this.setTitle("CADASTRO DE ALUNO");

        panel.add(botao3);
        this.setSize(600,200);
        this.setLocation(50,50);
        this.setTitle("CADASTRO DE PROFESSOR");

        panel.add(botao4);
        this.setSize(600,200);
        this.setLocation(50,50);
        this.setTitle("CADASTRO DE TURMA");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao1) {
            controlador.exibirJanCadCurso();

        }

        if (e.getSource() == botao2) {
            controlador.exibirJanCadAluno();

        }

        if (e.getSource() == botao3) {
            controlador.exibirJanCadProfessor();

        }

        if (e.getSource() == botao4) {
            controlador.exibirJanCadTurma();

        }
    }
}