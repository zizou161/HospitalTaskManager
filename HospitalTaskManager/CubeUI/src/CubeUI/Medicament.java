/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CubeUI;

/**
 *
 * @author zizou
 */
class Medicament {
    String Code,Nom,Type,Observation;
    int Quantite;
    
    Medicament(String Code,String Nom,String Type,String Observation,int Quantite){
        this.Code = Code;
        this.Nom = Nom;
        this.Type=Type;
        this.Observation = Observation;
        this.Quantite = Quantite;
    }
}
