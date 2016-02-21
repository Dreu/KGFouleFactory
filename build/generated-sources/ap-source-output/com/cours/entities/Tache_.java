package com.cours.entities;

import com.cours.entities.Client;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-20T14:03:08")
@StaticMetamodel(Tache.class)
public class Tache_ { 

    public static volatile SingularAttribute<Tache, String> path;
    public static volatile SingularAttribute<Tache, Integer> prixtache;
    public static volatile SingularAttribute<Tache, String> description;
    public static volatile SingularAttribute<Tache, Date> datecreation;
    public static volatile SingularAttribute<Tache, Date> datefin;
    public static volatile SingularAttribute<Tache, Integer> id;
    public static volatile SingularAttribute<Tache, Client> idclient;
    public static volatile SingularAttribute<Tache, Integer> nbfouleur;
    public static volatile SingularAttribute<Tache, String> etat;

}