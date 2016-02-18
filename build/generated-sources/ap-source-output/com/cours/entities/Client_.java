package com.cours.entities;

import com.cours.entities.Tache;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-18T16:39:16")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> montant;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, Integer> codepostal;
    public static volatile SingularAttribute<Client, String> genre;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile ListAttribute<Client, Tache> tacheList;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> vile;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, Date> datenaiss;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, Integer> numpiece;

}