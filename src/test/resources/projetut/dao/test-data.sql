--On crée un jeu de test pour le client--
INSERT INTO Personne(dType,Nom,prenom,mail,tel,dead,date_naiss,adresse,mdp,prive,my_angel_id) values
('client','Monnerville','Jean-Edouard','jemonnerville@hotmail.fr','0690924758',false,to_date('06/10/2000','DD/MM/YYYY'),
'4 avenue Georges alquier', 'pomme',False,1);

INSERT INTO Personne(dType,code_dacces,nom,prenom,mail,tel) values
('angel','1234','Ducoss','Katrine','katrine@hotmail.fr','0620202020');

INSERT INTO Visiteur(mail,tel) values ('gogo@gmail.com','0690909129');


