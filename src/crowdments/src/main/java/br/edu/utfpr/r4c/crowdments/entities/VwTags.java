/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.r4c.crowdments.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricar
 */
@Entity
@Table(name = "vw_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTags.findAll", query = "SELECT v FROM VwTags v")
    , @NamedQuery(name = "VwTags.findByTagpattern", query = "SELECT v FROM VwTags v WHERE v.tagpattern = :tagpattern")
    , @NamedQuery(name = "VwTags.findByDescription", query = "SELECT v FROM VwTags v WHERE v.description = :description")
    , @NamedQuery(name = "VwTags.findByCount", query = "SELECT v FROM VwTags v WHERE v.count = :count")})
public class VwTags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "tagpattern")
    private Integer tagpattern;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private BigInteger count;

    public VwTags() {
    }

    public Integer getTagpattern() {
        return tagpattern;
    }

    public void setTagpattern(Integer tagpattern) {
        this.tagpattern = tagpattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }
    
}
