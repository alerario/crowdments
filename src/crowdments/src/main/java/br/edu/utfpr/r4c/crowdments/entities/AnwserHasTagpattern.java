/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "anwser_has_tagpattern")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnwserHasTagpattern.findAll", query = "SELECT a FROM AnwserHasTagpattern a")
    , @NamedQuery(name = "AnwserHasTagpattern.findById", query = "SELECT a FROM AnwserHasTagpattern a WHERE a.id = :id")
, @NamedQuery(name = "AnwserHasTagpattern.findByTagPattern", query = "SELECT a FROM AnwserHasTagpattern a WHERE a.tagpattern.id = :id")})
public class AnwserHasTagpattern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "anwser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Anwser anwser;
    @JoinColumn(name = "tagpattern", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tagpattern tagpattern;

    public AnwserHasTagpattern() {
    }

    public AnwserHasTagpattern(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Anwser getAnwser() {
        return anwser;
    }

    public void setAnwser(Anwser anwser) {
        this.anwser = anwser;
    }

    public Tagpattern getTagpattern() {
        return tagpattern;
    }

    public void setTagpattern(Tagpattern tagpattern) {
        this.tagpattern = tagpattern;
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
        if (!(object instanceof AnwserHasTagpattern)) {
            return false;
        }
        AnwserHasTagpattern other = (AnwserHasTagpattern) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.r4c.crowdments.entities.AnwserHasTagpattern[ id=" + id + " ]";
    }
    
}
