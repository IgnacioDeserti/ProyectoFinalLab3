package InterfacesGraficas.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaginaComida extends JFrame implements ActionListener, ItemListener {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JScrollPane jScrollPane = new JScrollPane();
    private JLabel suma;
    private int numero = 0;
    private JButton cerrar, volver, mayor, menor;

    private JTextArea textArea = new JTextArea();
    private JComboBox comboBox;

    public PaginaComida()
    {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano

        /*comboBox = new JComboBox<>();
        comboBox.setBounds(5, 5, 100, 20);
        add(comboBox);
        comboBox.addItem("Milanesa"); //Agrega texto a comboBox
        comboBox.addItem("Salchicha");
        comboBox.addItem("Banana");
        comboBox.addItemListener(this);*/

        /*textField1 = new JTextField();
        textField1.setBounds(20, 5, 150, 20);
        add(textField1);*/

        /*jScrollPane.setBounds(10, 70,500,400);
        add(jScrollPane);*/

        suma = new JLabel(String.valueOf(numero));
        suma.setBounds(275, 125, 25, 15);
        add(suma);

        mayor = new JButton("+");
        mayor.setBounds(305, 120, 45, 25);
        mayor.setFont(new Font("SUB SCRIPT", 1, 15));
        add(mayor);
        mayor.addActionListener(this);

        menor = new JButton("-");
        menor.setBounds(205, 120, 45, 25);
        menor.setFont(new Font("SUB SCRIPT", 1, 15));
        add(menor);
        menor.addActionListener(this);

        cerrar = new JButton("Cerrar");
        cerrar.setBounds(450, 500, 100, 30);
        add(cerrar);
        cerrar.addActionListener(this);

        volver = new JButton("Volver");
        volver.setBounds(50, 500, 100, 30);
        add(volver);
        volver.addActionListener(this); //se le va a agregar un evento, esperando un click
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrar) {
            System.exit(0);
        }
        if (e.getSource() == volver) {
            PaginaDeCompra paginaDeCompra = new PaginaDeCompra();
            paginaDeCompra.setBounds(0, 0, 400, 400);
            paginaDeCompra.setVisible(true); //Si queres que se vea true, si no false.
            paginaDeCompra.setLocationRelativeTo(null); //Al ejecutar se pone en el centro.
            paginaDeCompra.setResizable(false); //Dar permiso a que el usuario pueda modificar el interfaz o no.
            this.setVisible(false);
        }

        if (e.getSource() == menor){
            if(numero > 0){
                numero--;
                suma.setText(String.valueOf(numero));
            }else {
                JOptionPane.showMessageDialog(null, "No puede reducir más la cantidad");
            }
        }
        if (e.getSource() == mayor){
            if(true/*numero < deposito.getStock*/){
                numero++;
                suma.setText(String.valueOf(numero));
            }else {
                JOptionPane.showMessageDialog(null, "No puede aumentar más la cantidad");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == comboBox)
        {
            String seleccion = (String) comboBox.getSelectedItem().toString();
        }
    }

    public int validaInt(String number){
        int result = 0; //Valor default.
        try{
            if(number != null){
                result = Integer.parseInt(number);
            }
        }catch(NumberFormatException nfe){
            //*No es numerico!
        }
        return result;
    }
}
