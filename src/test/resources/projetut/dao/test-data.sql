--Angel
Insert into  Personne(dtype,id)
    values('Personne',2);

--Client                                                                                                                                               
Insert into  Personne(dtype,nom,prenom,dead,my_angel_id,id)
    values ('Client','Monnerville','Jean-Edouard',FALSE,2,1);

Insert into Personne(dtype,nom,prenom,dead,my_angel_id,id)
    values ('Client','Toulon','Sara',FALSE,2,3);

--Comptes
Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id) 
    values ('CompteInstagram','monnervilleje@hotmail.fr','ASMR','fwi_angel',1);

Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id) 
    values ('CompteInstagram','angel@hotmail.fr','ASMRE','angel',2);

Insert into  Compte(dtype,adresse_mail,token,proprietaire_id)
    values ('CB ompteLinkedIN','jemonnerville@hotmail.fr','LGBT',1);







