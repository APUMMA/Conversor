package iguConverter;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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

  // Declaración de variables  de la Interfaz Gráfica de Usuario (IGU).
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
   
    lblImporte2 = new JLabel("000000");
    lblResultado = new JLabel("00000");
    lblMonedaBase = new JLabel("00000");
    lblMonedaFinal = new JLabel("00000");

    lblImporte.setBounds(20, 20, 80, 40);
    lbl_De.setBounds(270, 20, 80, 40);
    lbl_a.setBounds(520, 20, 80, 40);
    lblImporte2.setBounds(20, 120, 280, 40);
    lblResultado.setBounds(20, 160, 430, 50);
    lblMonedaBase.setBounds(20, 210, 230, 40);
    lblMonedaFinal.setBounds(20, 240, 230, 40);

    lblImporte.setForeground(Color.BLACK);
    lbl_De.setForeground(Color.BLACK);
    lbl_a.setForeground(Color.BLACK);
    // lblImporte2.setForeground(Color.BLACK);
    lblMonedaBase.setForeground(Color .GRAY);
    lblMonedaFinal.setForeground(Color .GRAY);
    lblResultado.setForeground(Color.BLUE);
    lblResultado.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
    lblResultado.setFont(new Font("Tahoma", 2, 42));

    // -------------------------------------------- <Text Field> --------------------------------------------
    txtImporte = new JTextField(null);

    txtImporte.setBounds(20, 55, 230, 30);

    // --------------------------------------------- <ComboBox> ---------------------------------------------
    cmbMonedaBase = new JComboBox<>(new String[] { "USD - Dólar estadounidense", "COP - Peso colombiano",
                                                          "EUR - Euro", "GBP - Libra esterlína",
                                                          "JPY - Yen japonés", "BRL - Real brasilero" });
    cmbMonedaFinal = new JComboBox<>(new String[] { "EUR - Euro", "USD - Dólar estadounidense", 
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
    
    // Declaraciòn de variables de eventos.
    double importe = 0;
    double resultado = 0;
    int a = 0;
    String de = "USD - Dólar estadounidense";

    private void configurarEventosFormulario() {

      txtImporte .addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent event) {

          convertir();

        }
      });
  
      cmbMonedaBase .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          de = (String) cmbMonedaBase.getSelectedItem();
          // monedaBase = cmbMonedaBase.getSelectedItem().toString();
          convertir();
        }
      });
  
      cmbMonedaFinal .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          a = cmbMonedaFinal.getSelectedIndex();
          convertir();
        }
      });
  
      btnConvertir .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

          convertir();
          
        }
      });

      btnLimpiar .addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          limpiarFormulario();
        }
      });
  
    }
  
    // -------------------------------------- <<<<<Metodo convertir>>>>> --------------------------------------
    private void convertir() {
      // Validando los datos ingresados en el JTextField.
      if (txtImporte.getText().isBlank() || !validarNumero(txtImporte.getText().trim())) {
  
        JOptionPane.showMessageDialog(this, "El campo importe debe ser numérico");
        }
        // Declaración de variables.
        importe = Double.parseDouble(txtImporte.getText());
        String de2 = de.substring(5);
        
        switch (de) {
          case "USD - Dólar estadounidense":
              if (a == 0) {
                resultado = (importe * 0.92);
              }else if (a == 1) {
                resultado = (importe * 1);
              }else if (a == 2) {
                resultado = (importe * 4098.53);
              }else if (a == 3) {
                resultado = (importe * 0.79);
              }else if (a == 4) {
                resultado = (importe * 145.93);
              }else if (a == 5) {
                resultado = (importe * 4.89);
              }
              break;
          case "COP - Peso colombiano":
              if (a == 0) {
                resultado = (importe * 0.00022);
              }else if (a == 1) {
                resultado = (importe * 0.00025);
              }else if (a == 2) {
                resultado = (importe * 1);
              }else if (a == 3) {
                resultado = (importe * 0.00019);
              }else if (a == 4) {
                resultado = (importe * 0.036);
              }else if (a == 5) {
                resultado = (importe * 0.0012);
              }
              break;
          case "EUR - Euro":
              if (a == 0) {
                resultado = (importe * 1);
              }else if (a == 1) {
                resultado = (importe * 1.09);
              }else if (a == 2) {
                resultado = (importe * 4479.32);
              }else if (a == 3) {
                resultado = (importe * 0.86);
              }else if (a == 4) {
                resultado = (importe * 159.65);
              }else if (a == 5) {
                resultado = (importe * 5.34);
              }
              break;
          case "GBP - Libra esterlína":
              if (a == 0) {
                resultado = (importe * 1.16);
              }else if (a == 1) {
                resultado = (importe * 1.27);
              }else if (a == 2) {
                resultado = (importe * 5210.26);
              }else if (a == 3) {
                resultado = (importe *1);
              }else if (a == 4) {
                resultado = (importe * 185.80);
              }else if (a == 5) {
                resultado = (importe * 6.22);
              }
              break;
          case "JPY - Yen japonés":
              if (a == 0) {
                resultado = (importe * 0.0063);
              }else if (a == 1) {
                resultado = (importe * 0.0068);
              }else if (a == 2) {
                resultado = (importe * 28.05);
              }else if (a == 3) {
                resultado = (importe * 0.0054);
              }else if (a == 4) {
                resultado = (importe * 1);
              }else if (a == 5) {
                resultado = (importe * 0.033);
              }
              break;
          case "BRL - Real brasilero":
              if (a == 0) {
                resultado = (importe * 0.19);
              }else if (a == 1) {
                resultado = (importe * 0.20);
              }else if (a == 2) {
                resultado = (importe * 838.15);
              }else if (a == 3) {
                resultado = (importe * 0.16);
              }else if (a == 4) {
                resultado = (importe * 29.87);
              }else if (a == 5) {
                resultado = (importe * 1);
              }
              break;
        }

        DecimalFormat formatter = new DecimalFormat("#.#####");

        String a2 = "EUR - Euro"; // Declaración de variable a2.
        for (int a = 0; a < 5; a++) {
          a2 = (String) cmbMonedaFinal.getSelectedItem();
        }
        lblImporte2.setText(txtImporte.getText() + " " + de2 + " ="); 
        lblResultado.setText(String.valueOf(formatter.format(resultado)) + " " + a2.substring(0, 4));

        lblMonedaBase.setText("1 " + de.substring(0, 4) + " ="); 
        lblMonedaFinal.setText("1 " + a2.substring(0, 4) + " =");
           
      
    }
  
    // ---------------------------- <<<<<Metodo validar números del text Field>>>>> ---------------------------
    public static boolean validarNumero(String valNumeros) {
      // Validamos los números con una expresión regular.
      // El asterisco indica que podemos ingresar x cantidad de números.
      // Expresión para validar "[a-zA-Z]" texto.
      // Expresión para limitar el número de carácteres {1,5}, en este caso serían 5.
      return valNumeros.matches("[0-9]*");
  
    }
  
    // --------------------------------- <<<<<Metodo limpiar formulario>>>>> ----------------------------------
    private void limpiarFormulario() {
      txtImporte.setText(" ");
      lblImporte2.setText(" ");
      lblResultado.setText(" ");
      lblMonedaBase.setText(" ");
      lblMonedaFinal.setText(" ");
  
    }

}
