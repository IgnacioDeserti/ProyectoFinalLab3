package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PaginaGeneral extends javax.swing.JFrame implements java.awt.event.ActionListener {
        private javax.swing.JMenuBar menuBar;
        private javax.swing.JMenu menu1;
        private javax.swing.JMenu menu2;
        private javax.swing.JMenu menu3;
        private javax.swing.JMenu menu4;
        private javax.swing.JMenuItem menuItem;
        private javax.swing.JMenuItem menuItem2;
        private javax.swing.JMenuItem menuItem3;
        private JMenuItem menuItem4;
        private javax.swing.JButton button;

    public PaginaGeneral()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Opciones");
        menuBar.add(menu1);

        menu2 = new JMenu("Comida");
        menu1.add(menu2);

        menu3 = new JMenu("Bebida");
        menu3.addActionListener(this);
        menu1.add(menu3);

        menu4 = new JMenu("Tecnologia");
        menu4.addActionListener(this);
        menu1.add(menu4);

        menuItem = new JMenuItem("Salchipapa");
        menuItem.addActionListener(this);
        menu2.add(menuItem);

        menuItem2 = new JMenuItem("Coca Cola");
        menuItem2.addActionListener(this);
        menu3.add(menuItem2);

        menuItem3 = new JMenuItem("Televisores");
        menuItem3.addActionListener(this);
        menu4.add(menuItem3);


        button = new JButton("Cerrar");
        button.setBounds(470, 500, 100, 30);
        add(button);
        button.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem)
        {

        }
        if (e.getSource() == menuItem2)
        {

        }else if (e.getSource() == menuItem3)
        {

        }else if (e.getSource() == button) {
            System.exit(0);
        }

    }
}
