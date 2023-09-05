package iguConverter;

import java.awt.Container;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<CREANDO LA INTERFAZ GRAFICA>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
public class MarcoPrincipal extends JFrame {

  private IguConvertMonedas iguConvertMonedas = new IguConvertMonedas();

  // -------------------------------------- <Constructor de la clase> ---------------------------------------
  public MarcoPrincipal() {
    super.setTitle("Conversor");
    // Icono de smashingstocks: "https://www.flaticon.es/iconos-gratis/cambio-de-divisas".
    Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconoDivisas.png"));
    this.setIconImage(icono);
    
    Container container = getContentPane();

    // Configuraciones de la Interfaz de Usuario.
    congigurarMarcoPrincipal(container);
    // configurarComponentesFormulario(container);
    // iguConvertMonedas.conversorMonedas(container);

  }

  // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% <<<<<MARCO-PRINCIPAL DEL FORMULARIO>>>>> %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
  private void congigurarMarcoPrincipal(Container container) {
    setSize(800, 450);
    setVisible(true);
    setLocationRelativeTo(null); //Centra la aplicación en la pantalla.
    setResizable(false); //Evita maximizar o redimencionar el marco o ventana de la App.

    // Llamado a la IGU del Conversor de Monedas.
    iguConvertMonedas.conversorMonedas(container);

  }

}