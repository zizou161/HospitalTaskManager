/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CubeUI;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author zizou
 */
public class Pharmacie {
    boolean complete;
    HashSet<Medicament> medicament = new HashSet<Medicament>();
    
    public void AjouterDemande(Medicament medicament){
        this.medicament.add(medicament);
    }
   
}
