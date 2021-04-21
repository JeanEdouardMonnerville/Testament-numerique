
--Client                                                                                                                                               
Insert into  Client(nom,prenom,dead,id)
    values ('MondeVille','Jean-Pierre',FALSE,4);

Insert into Client(nom,prenom,dead,id)
    values ('Toupilon','Sarash',FALSE,5);

--Comptes
Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id,id) 
    values ('CompteInstagram','monnervilleje@hotmail.fr','ASMR','fwi_angel',1,2);

Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id,id) 
    values ('CompteInstagram','angel@hotmail.fr','ASMRE','angel',2,3);

Insert into  Compte(dtype,adresse_mail,token,id_Linkedin,proprietaire_id,id)
    values ('CompteLinkedIN','jemonnerville@hotmail.fr','LGBT','2555',1,4);

Insert into Compte(dtype,adresse_mail,token,id_Linkedin,proprietaire_id,id)
    values ('CompteLinkedIN','SaraToulon@gmail.fr','Herbalife','1234',2,5);

--Actions

Insert into Action_LinkedIn(dtype,contenu,visibilite,id,compte_id)
    values ('PosterMessage','Petit Bonjour',True,1,4);

Insert into Action_LinkedIn(dtype,contenu,visibilite,id,compte_id)
    values ('PosterMessage','Petit comment ça va',True,2,5);

Insert into Action_LinkedIn(dtype,contenu,visibilite,id,compte_id)
    values ('PosterMessage','Petit moi ça va',True,3,5);

Insert into Action_LinkedIn(dtype,contenu,visibilite,id,compte_id)
    values ('PosterMessage','Petit bon bein au revoir',True,4,5);








