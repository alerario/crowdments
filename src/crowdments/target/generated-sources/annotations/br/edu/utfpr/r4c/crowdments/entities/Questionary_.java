package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Project;
import br.edu.utfpr.r4c.crowdments.entities.Question;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-12T20:25:19")
@StaticMetamodel(Questionary.class)
public class Questionary_ { 

    public static volatile CollectionAttribute<Questionary, Question> questionCollection;
    public static volatile SingularAttribute<Questionary, Date> ends;
    public static volatile SingularAttribute<Questionary, String> name;
    public static volatile SingularAttribute<Questionary, Date> start;
    public static volatile SingularAttribute<Questionary, Boolean> active;
    public static volatile SingularAttribute<Questionary, Integer> id;
    public static volatile CollectionAttribute<Questionary, Project> projectCollection;
    public static volatile SingularAttribute<Questionary, String> briefing;
    public static volatile SingularAttribute<Questionary, String> slug;

}