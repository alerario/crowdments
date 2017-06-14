package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Anwser;
import br.edu.utfpr.r4c.crowdments.entities.Project;
import br.edu.utfpr.r4c.crowdments.entities.Statues;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-12T20:25:19")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, Statues> statues;
    public static volatile SingularAttribute<Task, Date> duedate;
    public static volatile SingularAttribute<Task, String> description;
    public static volatile SingularAttribute<Task, Project> project;
    public static volatile SingularAttribute<Task, Integer> id;
    public static volatile SingularAttribute<Task, Anwser> awnser;

}