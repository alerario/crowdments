package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Questionary;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-12T20:25:19")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Date> ends;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, Boolean> active;
    public static volatile SingularAttribute<Project, Integer> id;
    public static volatile SingularAttribute<Project, Questionary> questionary;
    public static volatile SingularAttribute<Project, Date> starts;
    public static volatile SingularAttribute<Project, String> briefing;

}