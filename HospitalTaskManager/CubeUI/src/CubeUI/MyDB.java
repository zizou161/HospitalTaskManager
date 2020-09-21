/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CubeUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zizou
 */
public class MyDB {
    Connection connection =null;
    Statement statement =null;
    Statement statement1 =null;
    Statement statement2=null;
    Statement statement3 = null;
    ResultSet resultset =null;
    ResultSet resultset1 =null;
    ResultSet resultset3=null;
    
    PreparedStatement preparedstatement=null;
    PreparedStatement preparedstatement1=null;
    PreparedStatement preparedstatement2=null;
    PreparedStatement preparedstatement3=null;
    PreparedStatement preparedstatement4=null;
    PreparedStatement preparedstatement5=null;
    PreparedStatement preparedstatement6=null;
    PreparedStatement preparedstatement7=null;
    public void AjouterEmployer (String NSS,String Nom,String Prenom,String NumTel,String AdresseEmail,
            String DateDeNaissance,String Poste) throws SQLException{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
         String query = "insert into EMPLOYER (NSS,NOM,PRENOM,NUMTEL,ADRESSEEMAIL,DATEDENAISSANCE,POSTE)"+
                 "values(?,?,?,?,?,?,?)";
         this.preparedstatement = connection.prepareStatement(query);
         this.preparedstatement.setString(1,NSS);
         this.preparedstatement.setString(2,Nom);
         this.preparedstatement.setString(3,Prenom);
         this.preparedstatement.setString(4,NumTel);
         this.preparedstatement.setString(5,AdresseEmail);
         this.preparedstatement.setString(6,DateDeNaissance);
         this.preparedstatement.setString(7,Poste);
        preparedstatement.execute();
        
    }
    public void AjouterDemandeMedicament (String Code,String Nom,int Quantite,String Type,String Observation) throws SQLException{
         connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
         String query = "insert into DEMANDEMEDICAMENT(CODE,NOM,TYPE,QUANTITE,OBSERVATION)"+"values(?,?,?,?,?)";
         this.preparedstatement1 = connection.prepareStatement(query);
         this.preparedstatement1.setString(1, Code);
         this.preparedstatement1.setString(2, Nom);
         this.preparedstatement1.setString(3, Type);
         this.preparedstatement1.setInt(4, Quantite);
         this.preparedstatement1.setString(5, Observation);
         this.preparedstatement1.execute();
         
         }
    public void AjouterDemandeScan (String patient,String Code,String Date,String Notes) throws SQLException{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
            String query = "insert into DEMANDESCAN(PATIENT,CODE,DATE,NOTES)"+"values(?,?,?,?)";
            this.preparedstatement2 = connection.prepareStatement(query);
            this.preparedstatement2.setString(1,patient);
            this.preparedstatement2.setString(2,Code);
            this.preparedstatement2.setString(3,Date);
            this.preparedstatement2.setString(4,Notes);
            this.preparedstatement2.execute();
            
            }
    public void AjouterDemandeLab(String patient,String Type,String Code,String Notes) throws SQLException {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        String query = "insert into DEMANDETEST(PATIENT,TYPE,CODE,NOTES)"+"values(?,?,?,?)";
        this.preparedstatement3 = connection.prepareStatement(query);
        this.preparedstatement3.setString(1,patient);
        this.preparedstatement3.setString(2,Type);
        this.preparedstatement3.setString(3,Code);
        this.preparedstatement3.setString(4,Notes);
   
        this.preparedstatement3.execute();
        connection.close();
        
    }
    public ResultSet AfficherDemandeTest(String assigne_a,boolean complete) throws SQLException{
        
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        statement = connection.createStatement();
        
        
        if (assigne_a.length()==0){
            if (complete==false){
            String query = "SELECT * FROM DEMANDETEST WHERE complété=false";
            resultset = statement.executeQuery(query);
            }
            else {
            String query = "SELECT * FROM DEMANDETEST WHERE complété=true";
            resultset = statement.executeQuery(query);    
            }
            
        }
        else {
            if (complete==false){
                String query = "SELECT * FROM DEMANDETEST WHERE complété=false AND assigné_a='"+assigne_a+"'";
                resultset = statement.executeQuery(query);
            }
            else{
                 String query = "SELECT * FROM DEMANDETEST WHERE complété=true AND assigné_a='"+assigne_a+"'";
                 resultset = statement.executeQuery(query);
            }
            
        }
       
       return resultset;
    }
    public ResultSet AfficherEmployer(String Poste) throws SQLException{
    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
    statement1 = connection.createStatement();
    String query = "SELECT * FROM EMPLOYER WHERE POSTE='"+Poste+"'";
    resultset1 = statement1.executeQuery(query);
    
    
    

        return resultset1;
    }
    public void Assigne_a (String CODE,String NSS) throws SQLException{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        String query ="UPDATE DEMANDETEST SET assigné_a=? where CODE=?";
        this.preparedstatement4 = connection.prepareStatement(query);
        this.preparedstatement4.setString(1, NSS);
        this.preparedstatement4.setString(2, CODE);
        this.preparedstatement4.executeUpdate();
        
    }
        public void Assigne_aScan (String CODE,String NSS) throws SQLException{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        String query ="UPDATE DEMANDESCAN SET assigné_a=? where CODE=?";
        this.preparedstatement4 = connection.prepareStatement(query);
        this.preparedstatement4.setString(1, NSS);
        this.preparedstatement4.setString(2, CODE);
        this.preparedstatement4.executeUpdate();
        
    }
                public void Assigne_aMedicament (String CODE,String NSS) throws SQLException{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        String query ="UPDATE DEMANDEMEDICAMENT SET assigné_a=? where CODE=?";
        this.preparedstatement4 = connection.prepareStatement(query);
        this.preparedstatement4.setString(1, NSS);
        this.preparedstatement4.setString(2, CODE);
        this.preparedstatement4.executeUpdate();
        
    }
    
    public ResultSet AfficherDemandeScan(String assigne_a,boolean complete) throws SQLException{
       connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        Statement statement2 = connection.createStatement();
        ResultSet resultset2 =null;
        if (assigne_a.length()==0){
            if (complete ==false){
                String query = "SELECT * FROM DEMANDESCAN WHERE complété=false";
                resultset2 = statement2.executeQuery(query);
            }
            else {
                String query = "SELECT * FROM DEMANDESCAN WHERE complété=true";
                resultset2 = statement2.executeQuery(query);                
            }
        }
        else {
            if (complete == false){
                String query = "SELECT * FROM DEMANDESCAN WHERE complété=false AND assigné_a='"+assigne_a+"'";
                resultset2 = statement2.executeQuery(query);                
                
            }
            else{
                String query = "SELECT * FROM DEMANDESCAN WHERE complété=true AND assigné_a='"+assigne_a+"'";
                resultset2 = statement2.executeQuery(query);                   
            }
            
        }
        return resultset2;
    }
    public ResultSet AfficherDemandeMedicament(String assigne_a,boolean complete) throws SQLException{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
        statement3 = connection.createStatement();
        
        if (assigne_a.length()==0){
            if (complete ==false){
                String query = "SELECT * FROM DEMANDEMEDICAMENT WHERE complété=false";
                resultset3 = statement3.executeQuery(query);
            }
            else{
                String query ="SELECT * FROM DEMANDEMEDICAMENT WHERE complété=true";
                resultset3 = statement3.executeQuery(query);
            }
        }
        else{
            if (complete==false){
              String query = "SELECT * FROM DEMANDEMEDICAMENT WHERE complété=false AND assigné_a='"+assigne_a+"'";
                resultset3 = statement3.executeQuery(query);
            }
            else {
            String query = "SELECT * FROM DEMANDEMEDICAMENT WHERE complété=true AND assigné_a='"+assigne_a+"'";
                 resultset3 = statement3.executeQuery(query);  
            }
        }
        return resultset3;
    }
    public void CompleterDemandeMedicament(String Code) throws SQLException{
     connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
     String query ="UPDATE DEMANDEMEDICAMENT SET complété=? where CODE=?";
        this.preparedstatement5 = connection.prepareStatement(query);
        this.preparedstatement5.setBoolean(1, true);
        this.preparedstatement5.setString(2, Code);
        this.preparedstatement5.executeUpdate();
    }
       public void CompleterDemandeScan(String Code) throws SQLException{
     connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
     String query ="UPDATE DEMANDESCAN SET complété=? where CODE=?";
        this.preparedstatement6 = connection.prepareStatement(query);
        this.preparedstatement6.setBoolean(1, true);
        this.preparedstatement6.setString(2, Code);
        this.preparedstatement6.executeUpdate();
    }
          public void CompleterDemandeTest(String Code) throws SQLException{
     connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HospitalManagerDB","Guendouz","123");
     String query ="UPDATE DEMANDETEST SET complété=? where CODE=?";
        this.preparedstatement7 = connection.prepareStatement(query);
        this.preparedstatement7.setBoolean(1, true);
        this.preparedstatement7.setString(2, Code);
        this.preparedstatement7.executeUpdate();
    }
    
}

