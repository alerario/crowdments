/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cp.r4c.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "typeprofile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeprofile.findAll", query = "SELECT t FROM Typeprofile t")
    , @NamedQuery(name = "Typeprofile.findById", query = "SELECT t FROM Typeprofile t WHERE t.id = :id")
    , @NamedQuery(name = "Typeprofile.findByName", query = "SELECT t FROM Typeprofile t WHERE t.name = :name")
    , @NamedQuery(name = "Typeprofile.findByActive", query = "SELECT t FROM Typeprofile t WHERE t.active = :active")
    , @NamedQuery(name = "Typeprofile.findByDescription", query = "SELECT t FROM Typeprofile t WHERE t.description = :description")
    , @NamedQuery(name = "Typeprofile.findByLevel", query = "SELECT t FROM Typeprofile t WHERE t.level = :level")})
public class Typeprofile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Column(name = "description")
    private String description;
    @Column(name = "level")
    private Integer level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeprofile")
    private Collection<Profile> profileCollection;

    public Typeprofile() {
    }

    public Typeprofile(Integer id) {
        this.id = id;
    }

    public Typeprofile(Integer id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
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
        if (!(object instanceof Typeprofile)) {
            return false;
        }
        Typeprofile other = (Typeprofile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.cp.r4c.model.Typeprofile[ id=" + id + " ]";
    }
    
}
