/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cp.r4c.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "questionary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionary.findAll", query = "SELECT q FROM Questionary q")
    , @NamedQuery(name = "Questionary.findById", query = "SELECT q FROM Questionary q WHERE q.id = :id")
    , @NamedQuery(name = "Questionary.findByName", query = "SELECT q FROM Questionary q WHERE q.name = :name")
    , @NamedQuery(name = "Questionary.findByStart", query = "SELECT q FROM Questionary q WHERE q.start = :start")
    , @NamedQuery(name = "Questionary.findByEnds", query = "SELECT q FROM Questionary q WHERE q.ends = :ends")
    , @NamedQuery(name = "Questionary.findByBriefing", query = "SELECT q FROM Questionary q WHERE q.briefing = :briefing")
    , @NamedQuery(name = "Questionary.findBySlug", query = "SELECT q FROM Questionary q WHERE q.slug = :slug")
    , @NamedQuery(name = "Questionary.findByActive", query = "SELECT q FROM Questionary q WHERE q.active = :active")})
public class Questionary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "ends")
    @Temporal(TemporalType.DATE)
    private Date ends;
    @Column(name = "briefing")
    private String briefing;
    @Column(name = "slug")
    private String slug;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionary")
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionary")
    private Collection<Project> projectCollection;

    public Questionary() {
    }

    public Questionary(Integer id) {
        this.id = id;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
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
        if (!(object instanceof Questionary)) {
            return false;
        }
        Questionary other = (Questionary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.cp.r4c.model.Questionary[ id=" + id + " ]";
    }
    
}
