
--Client                                                                                                                                               
Insert into  Client(nom,prenom,dead,id)
    values ('Monnerville','Jean-Edouard',FALSE,1);

Insert into Client(nom,prenom,dead,id)
    values ('Toulon','Sara',FALSE,2);

--Comptes
Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id) 
    values ('CompteInstagram','monnervilleje@hotmail.fr','ASMR','fwi_angel',1);

Insert into  Compte(dtype,adresse_mail,token,pseudo,proprietaire_id) 
    values ('CompteInstagram','angel@hotmail.fr','ASMRE','angel',2);

Insert into  Compte(dtype,adresse_mail,token,id_Linkedin,proprietaire_id)
    values ('CompteLinkedIN','jemonnerville@hotmail.fr','LGBT','2555',1);

Insert into Compte(dtype,adresse_mail,token,id_Linkedin,proprietaire_id)
    values ('CompteLinkedIN','SaraToulon@gmail.fr','Herbalife','1234',2);







