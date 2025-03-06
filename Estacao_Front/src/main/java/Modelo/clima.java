/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author isaco
 */
@Entity (name = "clima")
@Table(name = "clima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clima.findAll", query = "SELECT c FROM clima c"),
    @NamedQuery(name = "Clima.findById", query = "SELECT c FROM clima c WHERE c.id = :id"),
    @NamedQuery(name = "Clima.findByTemperatura", query = "SELECT c FROM clima c WHERE c.temperatura = :temperatura"),
    @NamedQuery(name = "Clima.findByUmidade", query = "SELECT c FROM clima c WHERE c.umidade = :umidade"),
    @NamedQuery(name = "Clima.findByChuva", query = "SELECT c FROM clima c WHERE c.chuva = :chuva")})
public class clima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "temperatura")
    private String temperatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "umidade")
    private String umidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "chuva")
    private String chuva;

    public clima() {
    }

    public clima(Integer id) {
        this.id = id;
    }

    public clima(Integer id, String temperatura, String umidade, String chuva) {
        this.id = id;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.chuva = chuva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getChuva() {
        return chuva;
    }

    public void setChuva(String chuva) {
        this.chuva = chuva;
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
        if (!(object instanceof clima)) {
            return false;
        }
        clima other = (clima) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.clima[ id=" + id + " ]";
    }
    
}
