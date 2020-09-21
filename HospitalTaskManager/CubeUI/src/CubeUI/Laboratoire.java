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
public class Laboratoire {
    HashSet <Test> test = new HashSet<Test>();

    public void ajouterDemande (Test test){
        this.test.add(test);
    }
}
