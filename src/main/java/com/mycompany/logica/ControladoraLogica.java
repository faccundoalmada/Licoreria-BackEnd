
package com.mycompany.logica;

import com.mycompany.persistencia.ControladoraPersistencia;
import java.util.List;


public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //En la logica armo el objeto que va a recibir todo (no en interfaz ya que ese no es su laburovich).
    Licoreria licor = new Licoreria();

    public void cargarLicores(String tipo, String marca, int cantidad, int gondola) {
        
        //Armo un objeto para poder ponerle los datos tomados de la interfaz, que fueron encapsulado anteriormente para luego armar acá el objeto y mandarlo a la persistencia.       
        licor.setTipo(tipo);
        licor.setMarca(marca);
        licor.setCantidad(cantidad);
        licor.setGondola(gondola);
        
        controlPersis.cargarLicores(licor);
    }



    public List<Licoreria> traerLicores() {
        return controlPersis.traerLicores();
    }

    public void borrarCargado(int idLicores) {
        
        controlPersis.borrarCargado(idLicores);
    }

    public Licoreria modificarLicores(int idLicorModf) {
        
        return controlPersis.moficarLicor(idLicorModf);
 
    }

    public void modificar(Licoreria licor, String tipo, String marca, int cantidad, int gondola) {
       //Modifico en la logica.
        
        licor.setCantidad(cantidad);
        licor.setGondola(gondola);
        licor.setTipo(tipo);
        licor.setMarca(marca);
        
        controlPersis.modificarLicor(licor);
        
    }



    

    
    
}
