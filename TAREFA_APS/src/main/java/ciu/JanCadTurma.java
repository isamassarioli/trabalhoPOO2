package ciu;

import cci.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

public class JanCadTurma extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField field, field1, field2, field3;
    private JButton button;
    private ControladorPrincipal controlador;
    private JComboBox comboBox;

    public JanCadTurma(ControladorPrincipal c) {
        controlador = c;

        panel = new JPanel();
        field = new JTextField();
        field.setPreferredSize(new Dimension(150, 30));
        field.setText("Horário da turma (Escreva Matutino, Vespertino ou Noturno)");
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
        field2.setText("Data de Início(AAAA-MM-DD)");
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
        field1.setPreferredSize(new Dimension(150, 30));
        field1.setText("Data do fim(AAAA-MM-DD)");
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
        field3 = new JTextField();
        field3.setPreferredSize(new Dimension(150, 30));
        field3.setText("Limite de Alunos");
        field3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                field3.setText("40");
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

        button = new JButton("Cadastrar Turma");
        button.addActionListener(this);

        String [] opção = {"fechada", "aberta"};
        comboBox = new JComboBox(opção);

        panel.add(field);
        panel.add(field1);
        panel.add(field2);
        panel.add(field3);
        panel.add(button);
        panel.add(comboBox);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            controlador.cadastrarTurma(
                    this.field.getText(),
                    Integer.parseInt(this.field3.getText()),
                    Boolean.valueOf(this.comboBox.toString()),
                    Date.valueOf(this.field2.getText()),
                    Date.valueOf(this.field1.getText()));
        }
    }
}
