/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "tagpattern")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tagpattern.findAll", query = "SELECT t FROM Tagpattern t")
    , @NamedQuery(name = "Tagpattern.findById", query = "SELECT t FROM Tagpattern t WHERE t.id = :id")
    , @NamedQuery(name = "Tagpattern.findByDescription", query = "SELECT t FROM Tagpattern t WHERE t.description = :description")})
public class Tagpattern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tagpattern")
    private Collection<AnwserHasTagpattern> anwserHasTagpatternCollection;

    public Tagpattern() {
    }

    public Tagpattern(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<AnwserHasTagpattern> getAnwserHasTagpatternCollection() {
        return anwserHasTagpatternCollection;
    }

    public void setAnwserHasTagpatternCollection(Collection<AnwserHasTagpattern> anwserHasTagpatternCollection) {
        this.anwserHasTagpatternCollection = anwserHasTagpatternCollection;
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
        if (!(object instanceof Tagpattern)) {
            return false;
        }
        Tagpattern other = (Tagpattern) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.r4c.crowdments.entities.Tagpattern[ id=" + id + " ]";
    }
    
}
