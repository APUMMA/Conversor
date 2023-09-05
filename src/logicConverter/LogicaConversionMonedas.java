package logicConverter;

public class LogicaConversionMonedas {

  // Declaraciòn e inicializaciòn de variable.
  private double resultado = 0;

  public void cambiarMonedas(double importe, String de, int a) {

    switch (de) {
      case "USD - Dólar estadounidense":
        if (a == 0) {
          resultado = (importe * 0.92);
        } else if (a == 1) {
          resultado = (importe * 1);
        } else if (a == 2) {
          resultado = (importe * 4098.53);
        } else if (a == 3) {
          resultado = (importe * 0.79);
        } else if (a == 4) {
          resultado = (importe * 145.93);
        } else if (a == 5) {
          resultado = (importe * 4.89);
        }
        break;
      case "COP - Peso colombiano":
        if (a == 0) {
          resultado = (importe * 0.00022);
        } else if (a == 1) {
          resultado = (importe * 0.00025);
        } else if (a == 2) {
          resultado = (importe * 1);
        } else if (a == 3) {
          resultado = (importe * 0.00019);
        } else if (a == 4) {
          resultado = (importe * 0.036);
        } else if (a == 5) {
          resultado = (importe * 0.0012);
        }
        break;
      case "EUR - Euro":
        if (a == 0) {
          resultado = (importe * 1);
        } else if (a == 1) {
          resultado = (importe * 1.09);
        } else if (a == 2) {
          resultado = (importe * 4479.32);
        } else if (a == 3) {
          resultado = (importe * 0.86);
        } else if (a == 4) {
          resultado = (importe * 159.65);
        } else if (a == 5) {
          resultado = (importe * 5.34);
        }
        break;
      case "GBP - Libra esterlína":
        if (a == 0) {
          resultado = (importe * 1.16);
        } else if (a == 1) {
          resultado = (importe * 1.27);
        } else if (a == 2) {
          resultado = (importe * 5210.26);
        } else if (a == 3) {
          resultado = (importe * 1);
        } else if (a == 4) {
          resultado = (importe * 185.80);
        } else if (a == 5) {
          resultado = (importe * 6.22);
        }
        break;
      case "JPY - Yen japonés":
        if (a == 0) {
          resultado = (importe * 0.0063);
        } else if (a == 1) {
          resultado = (importe * 0.0068);
        } else if (a == 2) {
          resultado = (importe * 28.05);
        } else if (a == 3) {
          resultado = (importe * 0.0054);
        } else if (a == 4) {
          resultado = (importe * 1);
        } else if (a == 5) {
          resultado = (importe * 0.033);
        }
        break;
      case "BRL - Real brasilero":
        if (a == 0) {
          resultado = (importe * 0.19);
        } else if (a == 1) {
          resultado = (importe * 0.20);
        } else if (a == 2) {
          resultado = (importe * 838.15);
        } else if (a == 3) {
          resultado = (importe * 0.16);
        } else if (a == 4) {
          resultado = (importe * 29.87);
        } else if (a == 5) {
          resultado = (importe * 1);
        }
        break;

    }

  }

  // --------------------------------- <<<<<Getter>>>>> ----------------------------------
  public double getResultado() {
    return resultado;
  }

}