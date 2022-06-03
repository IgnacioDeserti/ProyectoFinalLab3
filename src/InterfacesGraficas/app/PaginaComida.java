package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.event.*;

public class PaginaComida extends JFrame implements ActionListener, ItemListener {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JScrollPane jScrollPane = new JScrollPane();
    private JButton button, button2;
    private JTextArea textArea = new JTextArea();
    private JComboBox comboBox;

    public PaginaComida()
    {
        setLayout(null);
        comboBox = new JComboBox<>();
        comboBox.setBounds(5, 5, 100, 20);
        add(comboBox);
        comboBox.addItem("Milanesa"); //Agrega texto a comboBox
        comboBox.addItem("Salchicha");
        comboBox.addItem("Banana");
        comboBox.addItemListener(this);

        /*textField1 = new JTextField();
        textField1.setBounds(20, 5, 150, 20);
        add(textField1);*/

        textArea = new JTextArea();
        jScrollPane = new JScrollPane(textArea);

        jScrollPane.setBounds(10, 70,500,400);
        add(jScrollPane);

        button = new JButton("Cerrar");
        button.setBounds(450, 500, 100, 30);
        add(button);
        button.addActionListener(this);

        button2 = new JButton("Buscar");
        button2.setBounds(25, 30, 80, 20);
        add(button2);
        button2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.exit(0);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == comboBox)
        {
            String seleccion = (String) comboBox.getSelectedItem().toString();
        }
    }
}
