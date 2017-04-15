package controlador;

import modelo.MoldeEetakemon;

import java.util.List;

/**
 * Created by Gurkeerat Singh on 15/04/2017.
 */
public interface IGestorEetakemon {
    void addEtakemon(MoldeEetakemon etakemon);
    boolean deleteEtakemonById (int id);
    MoldeEetakemon findEtakemonByName (String name);
    List<MoldeEetakemon> getAllEtakemons();

}
