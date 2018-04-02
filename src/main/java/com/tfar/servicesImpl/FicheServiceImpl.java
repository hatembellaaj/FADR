/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfar.servicesImpl;

/**
 *
 * @author hatem
 */

    
import com.tfar.dao.FicheDao;
import com.tfar.entity.Fiche;
import com.tfar.services.FicheService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

public class FicheServiceImpl implements FicheService{
    
    @Autowired
    private FicheDao ficheDao;
    
    
    public FicheDao getFicheDao() {
        return ficheDao;
    }


    @Override
    public void add(Fiche newfiche) {
        
        ficheDao.add(newfiche);
    }

    @Override
    public void update(Fiche fiche) {
        
        ficheDao.update(fiche);
    }

    @Override
    public Fiche getFicheParnDossier(String nDossier){
        
        return ficheDao.getFicheParnDossier(nDossier);
    }

    @Override
    public List<Fiche> getAllFiche() {
        
        return ficheDao.getAllFiche();
    }
     
        
    @Override
    public List <Fiche> getFicheParnService(int nService){
        return ficheDao.getFicheParnService(nService);
    }
    @Override
    public void delete(Fiche fiche) {
        
        ficheDao.delete(fiche);
    }
     
    @Override
    public Map <String,Number> getFicheParCritere(String critere)
    {
        return ficheDao.getFicheParCritere( critere);
    }
    @Override
    public Map <String,String> getKM()
    {
        return ficheDao.getKM();
    }
    
}
