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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "anwser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anwser.findAll", query = "SELECT a FROM Anwser a")
    , @NamedQuery(name = "Anwser.findById", query = "SELECT a FROM Anwser a WHERE a.id = :id")
    , @NamedQuery(name = "Anwser.findByAwnser", query = "SELECT a FROM Anwser a WHERE a.awnser = :awnser")
    , @NamedQuery(name = "Anwser.findByScore", query = "SELECT a FROM Anwser a WHERE a.score = :score")})
public class Anwser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "awnser")
    private String awnser;
    @Column(name = "score")
    private Integer score;
    @JoinTable(name = "anwser_has_tagpattern", joinColumns = {
        @JoinColumn(name = "anwser", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagpattern", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Tagpattern> tagpatternCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "awnser")
    private Collection<Task> taskCollection;
    @JoinColumn(name = "profile", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profile profile;
    @JoinColumn(name = "question", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Question question;

    public Anwser() {
    }

    public Anwser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAwnser() {
        return awnser;
    }

    public void setAwnser(String awnser) {
        this.awnser = awnser;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @XmlTransient
    public Collection<Tagpattern> getTagpatternCollection() {
        return tagpatternCollection;
    }

    public void setTagpatternCollection(Collection<Tagpattern> tagpatternCollection) {
        this.tagpatternCollection = tagpatternCollection;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        if (!(object instanceof Anwser)) {
            return false;
        }
        Anwser other = (Anwser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.r4c.crowdments.entities.Anwser[ id=" + id + " ]";
    }
    
}
