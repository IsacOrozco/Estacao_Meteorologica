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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author rever
 */
@Entity
@Table(name = "Clima")
@XmlRootElement
public class Dados implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "temperatura")
    private String temperatura;
    @Column(name = "umidade")
    private String umidade;
    @Basic(optional = false)
    @Column(name = "chuva")
    private String chuva;
    @Basic(optional = false)
    @Column(name = "data_afericao")
    private LocalDateTime data_afericao;
    
    public Dados()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(String temperatura)
    {
        this.temperatura = temperatura;
    }

    public String getUmidade()
    {
        return umidade;
    }

    public void setUmidade(String umidade)
    {
        this.umidade = umidade;
    }

    public String getChuva()
    {
        return chuva;
    }

    public void setChuva(String chuva)
    {
        this.chuva = chuva;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dados))
        {
            return false;
        }
        Dados other = (Dados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Modelo.Dados[ id=" + id + " ]";
    }

    public LocalDateTime getData_afericao()
    {
        return data_afericao;
    }

    public void setData_afericao(LocalDateTime data_afericao)
    {
        this.data_afericao = data_afericao;
    }
}
