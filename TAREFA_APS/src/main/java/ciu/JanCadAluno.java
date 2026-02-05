package ciu;

import cci.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

public class JanCadAluno extends javax.swing.JFrame implements ActionListener {

    private JPanel panel;
    private JTextField field, field1, field2;
    private JButton button;
    private ControladorPrincipal controlador;

    public JanCadAluno(ControladorPrincipal c) {
        controlador = c;
        panel = new JPanel();
        field = new JTextField();
        field.setPreferredSize(new Dimension(150, 30));
        field.setText("Nome do Aluno");
        field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                field.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        field2 = new JTextField();
        field2.setPreferredSize(new Dimension(150, 30));
        field2.setText("CPF do Aluno");
        field2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                field2.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        field1 = new JTextField();
        field1.setPreferredSize(new Dimension(350, 30));
        field1.setText("Data de Nascimento do aluno (escreva na forma AAAA-(M)M-(D)D)");
        field1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                field1.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        button = new JButton("Cadastrar Aluno");
        button.addActionListener(this);

        panel.add(field);
        panel.add(field1);
        panel.add(field2);
        panel.add(button);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            controlador.cadastrarAluno(
                        this.field1.getText(),
                        Date.valueOf(this.field1.getText()),
                        Long.parseLong(this.field2.getText()));
        }
    }
}


