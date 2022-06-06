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
        setDefaultCloseOperation(EXIT_ON_CLOSE); //para que el programa no se quede abierto en segundo plano
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
        this.textArea.setText("Derecho de retractación\n" +
                " En los contratos celebrados por medio de este sitio, el Usuario tiene el derecho irrenunciable de revocar su aceptación dentro de los Noventa (90) días computados a partir de la celebración del contrato. Si la aceptación es posterior a la entrega del bien, el plazo debe comenzar a correr desde que ésta última se produce, a menos que en una determinada oferta se contemple expresamente un plazo mayor, a cuyo efecto deberá cumplir con lo establecido en el punto 10 siguiente. Si el plazo vence en día inhábil, se prorroga hasta el primer día hábil siguiente. Las cláusulas, pactos o cualquier modalidad aceptada por el consumidor durante este período que tenga por resultado la imposibilidad de ejercer el derecho de revocación se tienen por no escritos.\n" +
                " \n" +
                "1) General\n" +
                " Estos términos y condiciones (los \"Términos y Condiciones\") regulan el acceso y uso de los servicios ofrecidos por INC S.A., CUIT 30-68731043-4, inscripta en el RPC el 19/09/1996, bajo el nº 9053, L. 119, T. “A” de SS. AA., con sede social en Beruti 2915, CP C1425BBI, CABA (los “Servicios”) dentro del sitio www.carrefour.com.ar (el \"Sitio\") destinados a la adquisición de los productos comercializados en el Sitio (los “Productos”). Cualquier persona que desee acceder y/o usar el Sitio y/o los Servicios podrá hacerlo sujetándose a los presentes Términos y Condiciones. En consecuencia, todas las visitas y cada uno de los contratos y transacciones que se realicen en este Sitio, como asimismo sus efectos jurídicos, quedarán regidos por estas reglas y sometidas a la legislación aplicable en la República Argentina.\n" +
                " Los presentes Términos y Condiciones contenidos se aplicarán y se entenderán como formando parte de cada uno de los actos y contratos que se ejecuten o celebren mediante los sistemas de oferta y comercialización comprendidos en este Sitio entre los usuarios de este Sitio e INC SA.\n" +
                " La utilización del Sitio implica la aceptación expresa, plena y sin reservas del Usuario (conforme más adelante se define) de los presentes Términos y Condiciones en la versión publicada por INC S.A. En consecuencia, el Usuario debe leer atentamente los Términos y Condiciones en cada una de las ocasiones en que se proponga utilizar el Sitio.\n" +
                " En forma previa a cada contratación, el Usuario deberá leer, entender y aceptar todas las condiciones establecidas en los Términos y Condiciones.\n" +
                " INC S.A. se reserva el derecho a modificar unilateralmente, en cualquier momento y sin aviso previo, la presentación y configuración del Sitio, así como de los presentes Términos y Condiciones y/o las condiciones particulares requeridas para utilizar el Sitio.\n" +
                " El Usuario es consciente de y acepta voluntariamente que el uso del Sitio y de los Servicios es bajo su única y exclusiva responsabilidad.\n" +
                " Por cualquier circunstancia derivada del uso del Sitio, de la adquisición y/o utilización de los Productos y/o Servicios, así como de la interpretación de los Términos y Condiciones, el Usuario podrá ponerse en contacto con el servicio de atención al cliente de INC S.A. llamando al 0800-444-8484 o enviando un correo electrónico a atención_clientes@contactocarrefour.com.ar.\n" +
                "\n" +
                " \n" +
                "\n" +
                "2) Registración de los Usuarios\n" +
                " El Sitio y los Servicios sólo están disponibles para personas humanas mayores de 18 años de edad y que tengan capacidad legal para contratar, conforme las leyes de la República Argentina. No podrán utilizar los Servicios ni el Sitio las personas que no tengan esa capacidad o Usuarios de Carrefour.com.ar que hayan sido suspendidos temporalmente o inhabilitados definitivamente. Cuando INC S.A. tenga razones que así lo justifiquen, podrá limitar la cantidad de artículos comprados por persona. Estas restricciones pueden ser aplicables a los pedidos realizados por la misma cuenta o la misma tarjeta de crédito y también a los pedidos que utilizan la misma dirección de facturación y/o de entrega.\n" +
                " Es obligatorio completar el formulario de registración en todos sus campos con datos válidos (el “Usuario”). El Usuario deberá completarlo con su información personal de manera exacta, precisa y verdadera (\"Datos Personales\") y asume el compromiso de actualizar los Datos Personales conforme resulte necesario y/o cuando INC S.A., lo requiera o solicite. INC S.A. podrá utilizar diversos medios para identificar a sus Usuarios, pero INC S.A. no se responsabiliza por la certeza de los Datos Personales provistos por sus Usuarios. Los Usuarios garantizan y responden, en cualquier caso, de la veracidad, exactitud, vigencia y autenticidad de los Datos Personales ingresados.\n" +
                " INC S.A. se reserva el derecho de solicitar algún comprobante y/o dato adicional a efectos de corroborar los Datos Personales, así como de suspender temporal o definitivamente a aquellos Usuarios cuyos datos no hayan podido ser confirmados o alguno de ellos sean falsos o inexactos. En estos casos de inhabilitación, se dará de baja la compra efectuada, sin que ello genere algún derecho a resarcimiento, pudiendo INC S.A. iniciar las pertinentes acciones legales.\n" +
                " El Usuario dispondrá, una vez registrado, de un nombre y contraseña o clave definitiva que le permitirá el acceso personalizado, confidencial y seguro a su cuenta de Usuario (la “Cuenta”). El Usuario tendrá la posibilidad de cambiar la clave de acceso, para lo cual deberá sujetarse al procedimiento establecido en el Sitio. El Usuario se obliga a mantener la confidencialidad de su clave de acceso, asumiendo la responsabilidad por el mantenimiento de la confidencialidad de su clave secreta registrada en este Sitio, la cual le permite efectuar compras, solicitar servicios y obtener información. Dicha clave es de uso personal y su entrega a terceros, no involucra responsabilidad de INC S.A. o de las empresas en caso de mala utilización. En tal sentido, INC S.A. EXCLUYE TODA RESPONSABILIDAD POR LOS DAÑOS Y PERJUICIOS DE TODA NATURALEZA QUE PUDIERAN DEBERSE AL CONOCIMIENTO QUE PUEDAN TENER TERCEROS NO AUTORIZADOS DE LA CLAVE, CONDICIONES, CARACTERÍSTICAS Y CIRCUNSTANCIAS DEL USO QUE LOS USUARIOS HACEN DEL SITIO Y DE LOS SERVICIOS.\n" +
                " El Usuario será responsable por todas las operaciones efectuadas en su y a través de su Cuenta, hayan sido realizadas por sí y/o por terceros, pues el acceso a la misma está restringido al ingreso y uso de su clave secreta, de conocimiento exclusivo del Usuario. El Usuario se compromete a notificar a INC S.A. en forma inmediata y por medio idóneo y fehaciente, cualquier uso no autorizado de su Cuenta, así como el ingreso por terceros no autorizados a la misma. Se aclara que está prohibida la venta, cesión o transferencia de la clave secreta bajo cualquier negocio jurídico.\n" +
                " INC S.A. se reserva el derecho de rechazar cualquier solicitud de registración o de cancelar una registración previamente aceptada, sin que esté obligado a comunicar o exponer las razones de su decisión y sin que ello genere algún derecho a indemnización o resarcimiento a favor del tercero que intentó registrarse en el Sitio.\n" +
                "\n" +
                " \n" +
                "\n" +
                "3) Privacidad de la Información. Uso de los Datos Personales registrados en el Sitio.\n" +
                " Para utilizar los Servicios ofrecidos y el Sitio, los Usuarios deberán facilitar determinados datos de carácter personal (los \"Datos Personales\"). Los Datos Personales serán procesados y almacenados en bases de datos de titularidad de INC S.A., con domicilio en Cuyo 3367, Martínez, Provincia de Buenos Aires, Argentina. Los Datos Personales serán almacenados en bases de datos que\n" +
                " mantienen altos estándares de seguridad y protección tanto física como tecnológica. El Usuario en forma libre, expresa e informada autoriza y consiente que INCSA acceda a, haga uso y/o trate, por sí o por intermedio de terceros, los Datos Personales a los efectos de que cualquiera de ellos pueda: (i) administrar el Sitio y los Servicios Ofrecidos, identificar al Usuario, validar las órdenes, realizar análisis de riesgo, ejecutar las operaciones de compra, mejorar la labor de información y comercialización de los Productos y servicios prestados por INCSA (ii) establecer canales de contacto con los Usuarios; (iii) analizar hábitos de consumo y elaborar perfiles de clientes con fines promocionales, comerciales o publicitarios; (iv) enviar publicidad sobre productos, servicios, ofertas y promociones especiales; y/o (vii) analizar acciones y adoptar medidas tendientes a mejorar la experiencia de compra de los Usuarios. En tal sentido, los Usuarios expresamente autorizan a que los Datos Personales puedan ser compartidos y/o transferidos nacional y/o internacionalmente por INCSA (y/o sucesores y/o cesionarios) a las sociedades accionistas y/o controlantes y/o controladas de INCSA y/o en definitiva a cualquiera de las sociedades del Grupo Carrefour y/o a proveedores contratados por INCSA para su tratamiento a los fines detallados en el párrafo precedente. Los terceros por intermedio de quienes el Organizador y/o el Banco de Servicios Financieros (y/o sucesores y/o cesionarios de ambos) realicen el tratamiento de los Datos Personales para los fines detallados en el párrafo precedente pueden estar ubicados en países que no cuenten con legislación adecuada en materia de protección de Datos Personales, no obstante lo cual se adoptarán los recaudos necesarios para que los Datos Personales se encuentren protegidos en concordancia con la Ley N° 25.326 (\"LPDP\"). El Usuario tiene la facultad de ejercer el derecho de acceso a los Datos Personales en forma gratuita a intervalos no inferiores a seis (6) meses, salvo que se acredite un interés legítimo al efecto, conforme lo establecido en el artículo 14, inciso 3, de la LPDP. Asimismo, los Usuarios podrán en cualquier momento solicitar el retiro o bloqueo, total o parcial, de su nombre del banco de datos así como la actualización, rectificación, supresión y/o trato confidencial de los Datos Personales. A los fines indicados en este párrafo, los Usuarios deberán remitir su solicitud por correo electrónico a atencion_clientes@contactocarrefour.com consignando en el asunto la siguiente leyenda \"REMOCIÓN - EJERCICIO DERECHOS PRIVACIDAD\". La Agencia de Acceso a la Información Pública, en su carácter de Órgano de Control de la LPDP, tiene la atribución de atender las denuncias y/o reclamos que interpongan quienes resulten afectados en sus derechos por incumplimiento de las normas vigentes en materia de protección de Datos Personales. Tal como lo indica el artículo 27 del Anexo I del Decreto 1558/01, en toda comunicación con fines de publicidad que se realice por correo, teléfono, correo electrónico, Internet u otro medio a distancia a conocer, se deberá indicar, en forma expresa y destacada, la posibilidad del titular de los Datos Personales de solicitar el retiro o bloqueo, total o parcial, de su nombre de la base de datos. A pedido del interesado, se deberá informar el nombre del responsable o usuario del banco de datos que proveyó la información.\n" +
                "\n" +
                "4) Contratación en el Sitio\n" +
                " En los contratos ofrecidos por medio de este Sitio, INC S.A. informará, de manera inequívoca y fácilmente accesible, los pasos que deben seguirse para celebrarlos. El sólo hecho de seguir los pasos que para tales efectos se indican en este Sitio para efectuar una compra, implica aceptar que efectivamente INC S.A. ha dado cumplimiento a las condiciones contenidas en estos Términos y Condiciones.\n" +
                "\n" +
                " \n" +
                "\n" +
                "5) Medios de pago que se podrán utilizar en el Sitio\n" +
                " Los Productos adquiridos a través del Sitio, salvo que se señale una forma diferente para casos particulares u ofertas de determinados bienes o servicios, sólo pueden ser pagados con: a) Tarjeta Carrefour emitida por Banco de Servicios Financieros S.A., b) Tarjetas Visa, Mastercard, American Express, Naranja, Cabal, Italcred y Diners, emitidas en la República Argentina exclusivamente y c) a través de la plataforma Todopago. Las tarjetas de crédito o débito emitidas en el extranjero no son aceptadas y no pueden ser utilizadas como medio de pago. Todos los aspectos técnicos y comerciales respecto de las tarjetas bancarias aceptadas en este Sitio, tales como la fecha de emisión; caducidad, cupo, bloqueos, límites, etc., se regirán por el respectivo contrato que el Usuario posea con la entidad emisora de la correspondiente tarjeta, de forma tal que INC. S.A. no tendrá responsabilidad en cualquiera de los aspectos señalados. El Sitio podrá indicar determinadas condiciones de compra según el medio de pago que se utilice por el Usuario.\n" +
                "\n" +
                " \n" +
                "\n" +
                "6) Perfeccionamiento de los contratos celebrados a través de este Sitio\n" +
                " A través de este Sitio, INC S.A. realizará ofertas de Productos, que podrán ser aceptados por el Usuario en forma electrónica utilizando los mecanismos que el mismo Sitio ofrece para ello. Toda aceptación de oferta quedará sujeta a la condición suspensiva de que INC S.A. valide la transacción. En consecuencia, para toda operación que se efectúe en este Sitio, la confirmación y/o validación o verificación por parte de INC S.A será requisito para el perfeccionamiento del contrato. Para validar la transacción INC S.A. deberá verificar: a) Que dispone, en el momento de la aceptación de oferta, de los productos o servicios en stock. b) Que valida y acepta el medio de pago ofrecido por el Usuario. c) Que los datos registrados por el Usuario en el Sitio, coinciden con los proporcionados al efectuar su aceptación de la oferta.\n" +
                " Para informar al Usuario acerca de esta validación, INC S.A. deberá enviar una confirmación escrita a la misma dirección electrónica que haya registrado el Usuario aceptante de la oferta. El contrato se entenderá perfeccionado desde el momento en que se envía esta confirmación al Usuario. Si el Usuario no recibe tal notificación vía correo electrónico deberá contactarse con el Call Center de INC S.A. al 0800-444-8484 a fin de constatar que no hubo errores de registro al ingresar la casilla de correo.\n" +
                " En el caso de entregas a domicilio, se tomará como domicilio de facturación el domicilio de entrega denunciado por el Usuario. Y en el caso de retiro en tienda, se tomará como domicilio de facturación, el de la tienda elegida.\n" +
                " Las compras que contengan productos de las categorías electrodomésticos, colchones, muebles, hogar y/o aire libre deberán realizarse en un carro exclusivo para esos productos, no pudiendo compartir el mismo con otros productos del sitio.");
        this.textArea.setEditable(false);
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
