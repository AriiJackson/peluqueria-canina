package Logica;

import Persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();
    
    //Funcion con la que paso los datos a la db
    public void altaDatos (int numCliente, String nombrePerro, String raza, 
            String color, String alergico, String atencionEspecial, String nombreDuenio, 
            String celularDuenio, String observaciones) {
        //Creo un objeto de tipo DatosMascota
        DatosMascota datos = new DatosMascota();
        //Paso los datos
        datos.setNumCliente(numCliente);
        datos.setNombrePerro(nombrePerro);
        datos.setRaza(raza);
        datos.setColor(color);
        datos.setAlergico(alergico);
        datos.setAtencionEspecial(atencionEspecial);
        datos.setNombreDuenio(nombreDuenio);
        datos.setCelularDuenio(celularDuenio);
        datos.setObservaciones(observaciones);
        
        controlPersistencia.altaDatos(datos);
    }
}
