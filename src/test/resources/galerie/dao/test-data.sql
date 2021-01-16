-- Initialisation spécifiques pour un jeu de test
--Jeu de Test pour Galerie
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'Kings Road Londres');

--Jeu de Test pour Personne
INSERT INTO Personne(nom,adresse,id,dtype) VALUES ('Bastide','Castres',1,'Artiste');

--Jeu de Test pour Exposition
INSERT INTO Exposition(date_expo,duree,intitule,organisateur_ID,id) VALUES (to_date('12/12/2010','DD/MM/YYYY'),30,' Lart Brut ',1,1);

--Jeu de Test pour Tableau
INSERT INTO Tableau (hauteur,largeur,support,titre,auteur_ID,id) Values (2,2,'rien','Guernica',null,1);
INSERT INTO Tableau (hauteur,largeur,support,titre,auteur_ID,id) Values (2,2,'rien','Guernica 2',null,2);

--Jeu de Test Pour Transaction
INSERT INTO Transaction (PRIX_VENTE, Vendu_Le,Client_ID,Lieu_De_vente_ID,Oeuvre_ID,id) Values (20,to_date('12/12/2010','DD/MM/YYYY'),1,1,1,1);
INSERT INTO Transaction (PRIX_VENTE, Vendu_Le,Client_ID,Lieu_De_vente_ID,Oeuvre_ID,id) Values (20,to_date('12/12/2010','DD/MM/YYYY'),1,1,2,2);
