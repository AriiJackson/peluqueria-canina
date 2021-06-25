package Persistencia;

import Logica.DatosMascota;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    DatosMascotaJpaController jpaDatos = new DatosMascotaJpaController();
    
    public void altaDatos( DatosMascota datos ) {
        try {
            jpaDatos.create(datos);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
