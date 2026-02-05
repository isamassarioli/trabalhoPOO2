package ciu;

import cci.ControladorPrincipal;
import cdp.Curso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class JanCadCurso extends javax.swing.JFrame implements ActionListener {
    private JPanel panel;
    private JTextField field, field1, field2;
    private JButton button;
    private ControladorPrincipal controlador;

    public JanCadCurso(ControladorPrincipal c) {
        controlador = c;
        panel = new JPanel();
        field = new JTextField();
        field.setPreferredSize(new Dimension(150, 30));
        field.setText("Nome do Curso");
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
        field2.setText("Carga Horária do Curso");
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
        field1.setText("ID do Curso");
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
        button = new JButton("Cadastrar Curso");
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
            controlador.cadastrarCurso(
                    Integer.parseInt(this.field1.getText()),
                    this.field.getText(),
                    Integer.parseInt(this.field2.getText()));
        }
    }
}



