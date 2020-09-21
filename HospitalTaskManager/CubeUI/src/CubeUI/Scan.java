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
class Scan {
    String patient,DateDuScan,CodeScan,Notes;
    public Scan (String patient,String DateDuScan,String CodeScan,String Notes){
        this.patient = patient;
        this.DateDuScan = DateDuScan;
        this.CodeScan = CodeScan;
        this.Notes = Notes;
    }
}
