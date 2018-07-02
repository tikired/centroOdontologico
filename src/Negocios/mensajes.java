package Negocios;

import javax.swing.JOptionPane;


public class mensajes {
    public void infoMessage(String message, String tittle) {
        JOptionPane.showMessageDialog(null, message, tittle, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeError(){
        infoMessage("Error al ingresar los datos", "Alert");
    }
    
    public void mensajeCampoVacio(){
        infoMessage("No pueden quedar campos vacios", "Alert");
    }
    
    public void mensajeLogrado(){
        infoMessage("Agrege produtos para continuar", "Alert");
    }
    
    public void mensajeModificado(){
        infoMessage("Orden de compra modificada correctamente", "Recepcionar productos");
    }
    
    public void mensajeEstado(){
        infoMessage("Debe seleccionar un estado", "Atención");
    }
    
    public void mensajeFecha(){
        infoMessage("Debe seleccionar una fecha", "Atención");
    }
    
    public void mensajeEmpleado(){
        infoMessage("Debe seleccionar un empleado", "Atención");
    }
}
