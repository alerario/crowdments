package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-22T07:47:35")
@StaticMetamodel(Statues.class)
public class Statues_ { 

    public static volatile CollectionAttribute<Statues, Task> taskCollection;
    public static volatile SingularAttribute<Statues, Integer> id;
    public static volatile SingularAttribute<Statues, String> state;

}