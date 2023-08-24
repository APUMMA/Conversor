package iguConverter;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<CREANDO LA INTERFAZ GRAFICA>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
public class MarcoPrincipal extends JFrame {

  // Declaración de variables  de la IGU.
  private JTabbedPane contenedorPestanias;
  private JPanel pestania1, pestania2;
  private JLabel lblImporte, lbl_De, lbl_a, lblImporte2, lblResultado, lblMonedaBase, lblMonedaFinal;
  private JTextField txtImporte;
  private JComboBox<?> cmbMonedaBase, cmbMonedaFinal;
  private JButton btnConvertir, btnLimpiar;
 

  // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<METODO CONSTRUCTOR>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  public MarcoPrincipal() {
    super.setTitle("Conversor");
    // Icono de smashingstocks: "https://www.flaticon.es/iconos-gratis/cambio-de-divisas".
    Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconoDivisas.png"));
    this.setIconImage(icono);
    
    Container container = getContentPane();

    // Configuraciones de la Interfaz de Usuario.
    congigurarMarcoPrincipal(container);
    configurarComponentesFormulario(container);
    configurarEventosFormulario();

  }

  // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<MARCO-PRINCIPAL DEL FORMULARIO>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  private void congigurarMarcoPrincipal(Container container) {
    setSize(800, 450);
    setVisible(true);
    setLocationRelativeTo(null); //Centra la aplicación en la pantalla.
    setResizable(false); //Evita maximizar o redimencionar el marco o ventana de la App.

  }

  // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<COMPONENTES DEL FORMULARIO>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  private void configurarComponentesFormulario(Container container) {

     // -------------------------------------- <Contenedor de Pestanias> -------------------------------------
    contenedorPestanias = new JTabbedPane();
 
    // -------------------------------------------- <Pestanias> ---------------------------------------------
    pestania1 = new JPanel(null);
    pestania2 = new JPanel(null);

    pestania1.setBackground(Color.CYAN);
    pestania2.setBackground(Color.ORANGE);

    // --------------------------------------------- <Labels> -----------------------------------------------
    lblImporte = new JLabel("Importe:");
    lbl_De = new JLabel("De:");
    lbl_a = new JLabel("a:");
    // TODO
    lblImporte2 = new JLabel("250");
    lblResultado = new JLabel("250");
    lblMonedaBase = new JLabel("250");
    lblMonedaFinal = new JLabel("250");

    lblImporte.setBounds(20, 20, 80, 40);
    lbl_De.setBounds(270, 20, 80, 40);
    lbl_a.setBounds(520, 20, 80, 40);
    lblImporte2.setBounds(20, 120, 80, 40);
    lblResultado.setBounds(20, 160, 230, 50);
    lblMonedaBase.setBounds(20, 210, 230, 40);
    lblMonedaFinal.setBounds(20, 240, 230, 40);

    lblImporte.setForeground(Color.BLACK);
    lbl_De.setForeground(Color.BLACK);
    lbl_a.setForeground(Color.BLACK);
    // lblImporte2.setForeground(Color.BLACK);
    lblResultado.setForeground(Color.BLUE);
    lblResultado.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    lblResultado.setFont(new Font("Tahoma", 2, 42));

    // -------------------------------------------- <Text Field> --------------------------------------------
    txtImporte = new JTextField(null);

    txtImporte.setBounds(20, 55, 230, 30);

    // --------------------------------------------- <ComboBox> ---------------------------------------------
    cmbMonedaBase = new JComboBox<String>(new String[] { "USD - Dólar estadounidense", "COP - Peso colombiano",
                                                          "EUR - Euro", "GBP - Libra esterlína",
                                                          "JPY - Yen japonés", "BRL - Real brasilero" });
    cmbMonedaFinal = new JComboBox<String>(new String[] { "EUR - Euro", "USD - Dólar estadounidense", 
                                                          "COP - Peso colombiano", "GBP - Libra esterlína", 
                                                          "JPY - Yen japonés", "BRL - Real brasilero" });

    cmbMonedaBase.setBounds(270, 55, 230, 30);
    cmbMonedaFinal.setBounds(520, 55, 230, 30);

    // --------------------------------------------- <Botones> ----------------------------------------------
    btnConvertir = new JButton("Convertir");
    btnLimpiar = new JButton("Limpiar");

    btnConvertir.setBounds(110, 300, 230, 50);
    btnLimpiar.setBounds(440, 300, 230, 50);

    // ------------------------------- <Adision de elementos a contenedores> --------------------------------
    container.add(contenedorPestanias);
    contenedorPestanias.add("Conversor de Divisas", pestania1);
    contenedorPestanias.add("Conversor 2", pestania2);
    pestania1.add(lblImporte);
    pestania1.add(lbl_De);
    pestania1.add(lbl_a);
    pestania1.add(lblImporte2);
    pestania1.add(txtImporte);
    pestania1.add(cmbMonedaBase);
    pestania1.add(cmbMonedaFinal);
    pestania1.add(lblResultado);
    pestania1.add(lblMonedaBase);
    pestania1.add(lblMonedaFinal);
    pestania1.add(btnConvertir);
    pestania1.add(btnLimpiar);

  }  

    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<EVENTOS DEL FORMULARIO>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    double resultado = 0;
    String de = "EUR";
    String a = "USD";
  
    private void configurarEventosFormulario() {
  
      cmbMonedaBase .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          de = cmbMonedaBase.getSelectedItem().toString();
          
        }
      });
  
      cmbMonedaFinal .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          a = cmbMonedaFinal.getSelectedItem().toString();
          
        }
      });
  
      btnLimpiar .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          limpiarFormulario();
        }
      });
  
      btnConvertir .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          convertir();
        }
      });
  
    }
  
    // --------------------------------- <<<<<Metodo limpiar formulario>>>>> ----------------------------------
    private void limpiarFormulario() {
      txtImporte.setText("");
      cmbMonedaBase.setSelectedIndex(0);
      cmbMonedaFinal.setSelectedIndex(0);
      lblImporte2.setText(" ");
      lblResultado.setText(" ");
      lblMonedaBase.setText(" ");
      lblMonedaFinal.setText(" ");
  
    }
  
    // -------------------------------------- <<<<<Metodo convertir>>>>> --------------------------------------
    int importe;
  
    private void convertir() {
      // Validando los datos ingresados en el JTextField.
      if (txtImporte.getText().isBlank() || !validarNumero(txtImporte.getText().trim())) {
  
        JOptionPane.showMessageDialog(this, "El campo importe debe ser numérico");
  
      }else{
        importe = Integer.parseInt(txtImporte.getText());
        lblImporte2.setText(" " + importe +" =");
        // TODO
        lblResultado.setText(" " + importe);
        lblMonedaBase.setText(" " + importe +" ="); 
        lblMonedaFinal.setText(" " + importe +" =");
  
        JOptionPane.showMessageDialog(this, "Conversión realizada");
  
      }
      
    }
  
    // ---------------------------- <<<<<Metodo validar números del text Field>>>>> ---------------------------
    public static boolean validarNumero(String valNumeros) {
      // Validamos los números con una expresión regular.
      // El asterisco indica que podemos ingresar x cantidad de números.
      // Expresión para validar "[a-zA-Z]" texto.
      // Expresión para limitar el número de carácteres {1,5}, en este caso serían 5.
      return valNumeros.matches("[0-9]*");
  
    }
  
    public String aMoneda(double importe){
      return null;
    }
  
}
