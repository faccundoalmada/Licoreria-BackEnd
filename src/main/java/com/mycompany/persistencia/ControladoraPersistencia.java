
package com.mycompany.persistencia;

import com.mycompany.logica.Licoreria;
import com.mycompany.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {


    LicoreriaJpaController licoreriaJpa = new LicoreriaJpaController();
    
    public void cargarLicores(Licoreria licor) {
        
        licoreriaJpa.create(licor);
    }

    public List<Licoreria> traerLicores() {
        
        return licoreriaJpa.findLicoreriaEntities();
    }

    public void borrarCargado(int idLicores) {
        
        try {
            licoreriaJpa.destroy(idLicores);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Licoreria moficarLicor(int idLicorModf) {
        return licoreriaJpa.findLicoreria(idLicorModf);
        
    }

    public void modificarLicor(Licoreria licor) {
        
        try {
            licoreriaJpa.edit(licor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


 
   
    
}
