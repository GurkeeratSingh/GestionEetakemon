package controlador;

import modelo.MoldeEetakemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Gurkeerat Singh on 15/04/2017.
 */
public class GestorEetakemon implements IGestorEetakemon{
    private int id=0;
    private int CalcularId(){
        return id++;
    }
    private MoldeEetakemon findById(int id){
        for(MoldeEetakemon eetakemon: listaEetakemon)
        {
            if(eetakemon != null && eetakemon.id == id) return eetakemon;
        }
        return null;
    }
    private boolean deleteOfList(MoldeEetakemon borrar){
        if (borrar!=null) {
            listaEetakemon.remove(borrar);
            return true;
        }
        else {
            return false;
        }
    }

    private List<MoldeEetakemon> listaEetakemon = new ArrayList<>();

    @Override
    public void addEtakemon(MoldeEetakemon etakemon) {
        etakemon.id=CalcularId();
        listaEetakemon.add(etakemon);
    }

    @Override
    public boolean deleteEtakemonById(int id) {
        MoldeEetakemon bor;
        bor=findById(id);
        return deleteOfList(bor);
    }

    @Override
    public MoldeEetakemon findEtakemonByName(String name) {
        for(MoldeEetakemon eetakemon: listaEetakemon)
        {
            if((eetakemon != null) && Objects.equals(eetakemon.nombre, name)) return eetakemon;
        }
        return null;

    }

    @Override
    public List<MoldeEetakemon> getAllEtakemons() {
        return listaEetakemon;
    }
}
