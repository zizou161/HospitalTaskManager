/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CubeUI;

import java.util.HashSet;

/**
 *
 * @author zizou
 */
public class Scanneur {
    HashSet<Scan> scan = new HashSet<Scan>();
    
    public void AjouterDemande(Scan scan){
        this.scan.add(scan);
    }
}
