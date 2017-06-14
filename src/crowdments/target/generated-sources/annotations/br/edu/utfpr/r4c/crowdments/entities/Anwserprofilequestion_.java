package br.edu.utfpr.r4c.crowdments.entities;

import br.edu.utfpr.r4c.crowdments.entities.Anwser;
import br.edu.utfpr.r4c.crowdments.entities.Profile;
import br.edu.utfpr.r4c.crowdments.entities.Question;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-12T20:25:19")
@StaticMetamodel(Anwserprofilequestion.class)
public class Anwserprofilequestion_ { 

    public static volatile SingularAttribute<Anwserprofilequestion, Question> question;
    public static volatile SingularAttribute<Anwserprofilequestion, Profile> profile;
    public static volatile SingularAttribute<Anwserprofilequestion, Anwser> anwser;
    public static volatile SingularAttribute<Anwserprofilequestion, Integer> id;

}