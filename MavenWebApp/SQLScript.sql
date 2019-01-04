CREATE DATABASE PROJET;
use PROJET;
CREATE TABLE userAccounts ( 
	userName VARCHAR(20) NOT NULL , 
	password VARCHAR(20) NOT NULL , 
	PRIMARY KEY (userName)
);
	
CREATE TABLE employees ( 
	name VARCHAR(20) NOT NULL , 
	firstName VARCHAR(20) NOT NULL , 
	homePhone VARCHAR(20) NOT NULL , 
	mobilePhone VARCHAR(20) NOT NULL , 
	workPhone VARCHAR(20) NOT NULL , 
	address VARCHAR(30) NOT NULL , 
	postalCode INT NOT NULL , 
	city VARCHAR(20) NOT NULL , 
	email VARCHAR(30) NOT NULL , 
	PRIMARY KEY (email)
);

INSERT INTO employees (name, firstName, homePhone, mobilePhone, workPhone, address, postalCode, city, email) 
VALUES ('Fontaine', 'Louis', '0144402599', '0613704582', '0123456789', '77 Boulevard de Courcelles', 75008, 'Paris', 'louis.fontaine@efrei.net'), 
('Telford', 'Chartré', '0280712820', '0698456325', '0845263596', '99 Rue Cazade', 28100, 'Dreux', 'telfordchartre@armyspy.com'),
('Jérémie', 'Uzan', '0142583219', '0615423689', '0953641235', '160 Rue des Poissonniers', 75018, 'Paris', 'jeremie.uzan@efrei.net'),
('Audric', 'Larocque', '0320492864', '0615423689', '0457469735', '24 Rue de Oise', 93287, 'Saint-Denis', 'audric.larocque@yahoo.fr'),
('Franck', 'Tchen', '0184965632', '0745262236', '0846798555', '2bis Avenue de la République', 15703, 'Villeneuve', 'franckt@laposte.net'),
('Annie', 'Dalgo', '0482334104', '0674859987', '0541632566', '1 Rue de la Loir', 78980, 'Chatillon', 'annehid@gmail.com'),
('François', 'Mouri', '0421378247', '0665992359', '0974865329', '27 Impasse des sapins', 56480, 'Le Mans', 'francois.mmm@hotmail.fr'),
('Georges', 'Abitbol', '0538720605', '0633064015', '0251965539', '18 Rue du four', 39450, 'Rouen', 'georgeavecs@gmail.com'),
('Christine', 'Dufres', '0110816179', '0601520069', '0746985669', '6 Rue Gramme', 94200 , 'Reuil-Malmaison', 'dufres.c@orange.fr'),
('Emma', 'Carot', '0320094509', '0615423689', '0536980145', '93 Rue de la Bourse', 92200, 'Neuilly Sur Seine', 'emma.carot@gmail.com');
	
INSERT INTO userAccounts (userName, password) VALUES ('admin', 'admin');