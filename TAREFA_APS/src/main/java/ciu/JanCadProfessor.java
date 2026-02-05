package ciu;

import cci.ControladorPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

public class JanCadProfessor extends JFrame implements ActionListener {
    private JPanel panel2;
    private JTextField field, field1, field2, field3;
    private JButton button;
    private ControladorPrincipal controlador;

    public JanCadProfessor(ControladorPrincipal c) {
        controlador = c;
        panel2 = new JPanel();
        field = new JTextField();
        field.setPreferredSize(new Dimension(150, 30));
        field.setText("Nome do Professor");
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
        field2.setText("CPF do Professor");
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

        field3 = new JTextField();
        field3.setPreferredSize(new Dimension(150, 30));
        field3.setText("Título do Professor");
        field3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                field3.setText("");
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
        field1.setText("Data de Nascimento do professor (escreva na forma AAAA-(M)M-(D)D)");
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
        button = new JButton("Cadastrar Professor");
        button.addActionListener(this);

        panel2.add(field);
        panel2.add(field1);
        panel2.add(field2);
        panel2.add(button);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel2);
        this.setSize(500, 500);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            controlador.cadastrarProfessor(this.field.getText(),
                    Date.valueOf(this.field1.getText()),
                    Long.parseLong(this.field2.getText()),
                    this.field3.getText());
        }
    }
}
