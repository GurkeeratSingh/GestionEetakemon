package vista;
import controlador.GestorEetakemon;
import modelo.MoldeEetakemon;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Gurkeerat Singh on 15/04/2017.
 */
public class UserView {
    private static MoldeEetakemon eetakemon = new MoldeEetakemon();
    private static GestorEetakemon gestor = new GestorEetakemon();

    public static void main(String [ ] args){
        System.out.println("Select one of the following options");
        boolean menu = true;
        while (menu){
            System.out.println("1. Add a new Eetakemon");
            System.out.println("2. Remove a Eetakemon by Id");
            System.out.println("3. Find a Eetakemon by Name");
            System.out.println("4. Print all Eetakemons");
            System.out.println("0. Exit");
            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
            switch (opt){
                case 0:
                    System.out.println("Good Bye!");
                    menu = false;
                    break;

                case 1:
                    System.out.println("Name: ");
                    String name = sc.next();
                    System.out.println("Level: ");
                    int nivel = sc.nextInt();
                    eetakemon=new MoldeEetakemon(name,nivel);
                    gestor.addEtakemon(eetakemon);
                    break;

                case 2:
                    System.out.println("Id number: ");
                    int id = sc.nextInt();
                    boolean resultado=gestor.deleteEtakemonById(id);
                    if (!resultado)
                            System.out.println("Eetakemon not found");
                    else
                            System.out.println("Deleted");
                    break;

                case 3:
                    System.out.println("Name: ");
                    eetakemon=gestor.findEtakemonByName(sc.next());
                    if(eetakemon != null)
                        System.out.println("Name: "+eetakemon.nombre+" Level: "+eetakemon.nivel+" Id: "+eetakemon.id);
                    else
                        System.out.println("Eetakemon not found");

                case 4:
                    List<MoldeEetakemon> listaEetakemon = gestor.getAllEtakemons();
                    if (listaEetakemon.size() != 0) {
                        System.out.println("Eetakemon Registered:");
                        for (MoldeEetakemon Etac : listaEetakemon) {
                            System.out.println("Name: "+Etac.nombre+" Level: "+Etac.nivel+" Id: "+Etac.id);
                        }
                    } else
                        System.out.println("Empty");
                    break;
            }
        }
    }
}
