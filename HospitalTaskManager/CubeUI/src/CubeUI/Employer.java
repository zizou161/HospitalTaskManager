/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CubeUI;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author zizou
 */
@Entity
public class Employer implements Serializable {
        
    private String NSS;
    private String Nom;
    private String Prenom;
    private String NumTel;
    private String AdresseEmail;
    private String DateDeNaissance;
    
    public Employer(String NSS,String Nom,String Prenom,String NumTel,String AdresseEmail,String DateDeNaissance){
        NSS=this.NSS;
        Nom=this.Nom;
        Prenom=this.Prenom;
        NumTel=this.NumTel;
        AdresseEmail = this.AdresseEmail;
        DateDeNaissance = this.DateDeNaissance;
    }
    public Employer(String NSS,String Nom,String Prenom,String NumTel,String DateDeNaissance){
        NSS=this.NSS;
        Nom=this.Nom;
        Prenom=this.Prenom;
        NumTel=this.NumTel;
        DateDeNaissance = this.DateDeNaissance;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CubeUI.Employer[ id=" + id + " ]";
    }
    
}
