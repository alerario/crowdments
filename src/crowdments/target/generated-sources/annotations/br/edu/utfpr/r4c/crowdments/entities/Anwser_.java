package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Profile;
import br.edu.utfpr.r4c.crowdments.entities.Question;
import br.edu.utfpr.r4c.crowdments.entities.Tagpattern;
import br.edu.utfpr.r4c.crowdments.entities.Task;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-22T07:47:35")
@StaticMetamodel(Anwser.class)
public class Anwser_ { 

    public static volatile SingularAttribute<Anwser, Integer> score;
    public static volatile CollectionAttribute<Anwser, Task> taskCollection;
    public static volatile SingularAttribute<Anwser, Question> question;
    public static volatile CollectionAttribute<Anwser, Tagpattern> tagpatternCollection;
    public static volatile SingularAttribute<Anwser, Profile> profile;
    public static volatile SingularAttribute<Anwser, Integer> id;
    public static volatile SingularAttribute<Anwser, String> awnser;

}