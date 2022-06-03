package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PaginaGeneral extends javax.swing.JFrame implements java.awt.event.ActionListener {
        private javax.swing.JMenuBar menuBar;
        private javax.swing.JMenu menu1;
        private javax.swing.JMenuItem menuItem;
        private javax.swing.JMenuItem menuItem2;
        private javax.swing.JMenuItem menuItem3;
        private javax.swing.JButton button;

    public PaginaGeneral()
    {
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Opciones");
        menuBar.add(menu1);

        menuItem = new JMenuItem("Comida");
        menuItem.addActionListener(this);
        menu1.add(menuItem);

        menuItem2 = new JMenuItem("Bebida");
        menuItem2.addActionListener(this);
        menu1.add(menuItem2);

        menuItem3 = new JMenuItem("Tecnologia");
        menuItem3.addActionListener(this);
        menu1.add(menuItem3);

        button = new JButton("Cerrar");
        button.setBounds(470, 500, 100, 30);
        add(button);
        button.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem)
        {

        }else if (e.getSource() == menuItem2)
        {

        }else if (e.getSource() == menuItem3)
        {

        }else if (e.getSource() == button) {
            System.exit(0);
        }
    }
}
