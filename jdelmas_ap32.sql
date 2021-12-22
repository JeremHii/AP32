-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Client :  localhost:3306
-- Généré le :  Ven 17 Décembre 2021 à 17:00
-- Version du serveur :  10.1.26-MariaDB-0+deb9u1
-- Version de PHP :  7.0.19-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jdelmas_ap32`
--

-- --------------------------------------------------------

--
-- Structure de la table `Admin`
--

CREATE TABLE `Admin` (
  `LOGIN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Admin`
--

INSERT INTO `Admin` (`LOGIN`) VALUES
('jeremy');

-- --------------------------------------------------------

--
-- Structure de la table `Commercial`
--

CREATE TABLE `Commercial` (
  `LOGIN` varchar(50) NOT NULL,
  `NOM` char(32) DEFAULT NULL,
  `PRENOM` char(32) DEFAULT NULL,
  `ADRESSE` char(32) DEFAULT NULL,
  `TELEPHONE` char(32) DEFAULT NULL,
  `MAIL` char(32) DEFAULT NULL,
  `POURCENTINTERESSEMENT` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Commercial`
--

INSERT INTO `Commercial` (`LOGIN`, `NOM`, `PRENOM`, `ADRESSE`, `TELEPHONE`, `MAIL`, `POURCENTINTERESSEMENT`) VALUES
('erwan', 'Nera', 'Erwan', 'la bas', '069', 'erwan@gmail.com', '10'),
('victor', 'Durocher', 'Victor', 'jensaisrienwsh', '069', 'victor.durocher@gmail.ch', '25');

-- --------------------------------------------------------

--
-- Structure de la table `Contacter`
--

CREATE TABLE `Contacter` (
  `LOGIN` varchar(50) NOT NULL,
  `DATE` date NOT NULL,
  `IDENT` char(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Contacter`
--

INSERT INTO `Contacter` (`LOGIN`, `DATE`, `IDENT`) VALUES
('erwan', '2021-12-16', '1');

-- --------------------------------------------------------

--
-- Structure de la table `Duree`
--

CREATE TABLE `Duree` (
  `CODEDUREE` varchar(50) NOT NULL,
  `LIBELLEDUREE` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Entreprise`
--

CREATE TABLE `Entreprise` (
  `IDENT` char(32) NOT NULL,
  `NUMVILLE` char(32) NOT NULL,
  `NOMENT` char(32) DEFAULT NULL,
  `ADRESSEENT` varchar(50) DEFAULT NULL,
  `TELENT` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Entreprise`
--

INSERT INTO `Entreprise` (`IDENT`, `NUMVILLE`, `NOMENT`, `ADRESSEENT`, `TELENT`, `EMAIL`) VALUES
('1', '30', 'Euhouais', '16 rue de la joie', '0707070707', 'lemail@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `Lieu`
--

CREATE TABLE `Lieu` (
  `IDLIEU` varchar(50) NOT NULL,
  `NUMVILLE` char(32) NOT NULL,
  `IDENT` char(32) NOT NULL,
  `LIBELLELIEU` varchar(50) DEFAULT NULL,
  `ADRESSELIEU` varchar(50) DEFAULT NULL,
  `COORDX` varchar(50) DEFAULT NULL,
  `COORDY` varchar(50) DEFAULT NULL,
  `ANNULATIONGRATUITE` tinyint(1) DEFAULT NULL,
  `NBETOILES` varchar(2) DEFAULT NULL,
  `DESCRIPTIF` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Lieu`
--

INSERT INTO `Lieu` (`IDLIEU`, `NUMVILLE`, `IDENT`, `LIBELLELIEU`, `ADRESSELIEU`, `COORDX`, `COORDY`, `ANNULATIONGRATUITE`, `NBETOILES`, `DESCRIPTIF`) VALUES
('1A', '30', '1', 'lelieu', '16 rue de charles', '10', '10', 0, '3', 'c\'est bien.');

-- --------------------------------------------------------

--
-- Structure de la table `Loueur`
--

CREATE TABLE `Loueur` (
  `IDENT` char(32) NOT NULL,
  `LOGIN` varchar(50) NOT NULL,
  `NOM` varchar(50) DEFAULT NULL,
  `PRENOM` varchar(50) DEFAULT NULL,
  `CONTACTEO_N` varchar(50) DEFAULT NULL,
  `TELEPHONECONTACT` char(32) DEFAULT NULL,
  `MAILCONTACT` char(32) DEFAULT NULL,
  `TYPEINSCRIPTION` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Loueur`
--

INSERT INTO `Loueur` (`IDENT`, `LOGIN`, `NOM`, `PRENOM`, `CONTACTEO_N`, `TELEPHONECONTACT`, `MAILCONTACT`, `TYPEINSCRIPTION`) VALUES
('1', 'victor', 'DUROCHER', 'Victor', 'oui', '0556787942', 'mailcontact@gmail.com', 'oui');

-- --------------------------------------------------------

--
-- Structure de la table `Pays`
--

CREATE TABLE `Pays` (
  `IDPAYS` char(32) NOT NULL,
  `NOMPAYS` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Pays`
--

INSERT INTO `Pays` (`IDPAYS`, `NOMPAYS`) VALUES
('BEL', 'Belgique'),
('FRA', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `Photo`
--

CREATE TABLE `Photo` (
  `NUMPHOTO` char(32) NOT NULL,
  `IDSALLE` varchar(50) NOT NULL,
  `URL` char(32) DEFAULT NULL,
  `PHOTOPRINCIPALE` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Reservant`
--

CREATE TABLE `Reservant` (
  `IDENT` char(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
  `NUMRESA` varchar(50) NOT NULL,
  `IDSALLE` varchar(50) NOT NULL,
  `CODEDUREE` varchar(50) NOT NULL,
  `IDENT` char(32) NOT NULL,
  `NBPERSONNES` int(2) DEFAULT NULL,
  `DATERESA` date DEFAULT NULL,
  `DATEDEBUT` date DEFAULT NULL,
  `MONTANT` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Responsable`
--

CREATE TABLE `Responsable` (
  `LOGIN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Salle`
--

CREATE TABLE `Salle` (
  `IDSALLE` varchar(50) NOT NULL,
  `IDLIEU` varchar(50) NOT NULL,
  `NOMSALLE` varchar(50) DEFAULT NULL,
  `LARGEUR` varchar(50) DEFAULT NULL,
  `LONGUEUR` varchar(50) DEFAULT NULL,
  `SURFACE` varchar(50) DEFAULT NULL,
  `HAUTEUR` varchar(50) DEFAULT NULL,
  `CAPACITE` int(2) DEFAULT NULL,
  `TARIFDEMIEJOURNEE` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `LOGIN` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`LOGIN`, `PASSWORD`) VALUES
('erwan', '123'),
('jeremy', '1234'),
('victor', '123');

-- --------------------------------------------------------

--
-- Structure de la table `Ville`
--

CREATE TABLE `Ville` (
  `NUMVILLE` char(32) NOT NULL,
  `IDPAYS` char(32) NOT NULL,
  `CP` char(32) DEFAULT NULL,
  `NOMVILLE` char(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `Ville`
--

INSERT INTO `Ville` (`NUMVILLE`, `IDPAYS`, `CP`, `NOMVILLE`) VALUES
('30', 'FRA', '30000', 'Bordeaux'),
('33', 'FRA', '33880', 'Laville');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`LOGIN`);

--
-- Index pour la table `Commercial`
--
ALTER TABLE `Commercial`
  ADD PRIMARY KEY (`LOGIN`);

--
-- Index pour la table `Contacter`
--
ALTER TABLE `Contacter`
  ADD PRIMARY KEY (`LOGIN`,`DATE`,`IDENT`),
  ADD KEY `I_FK_CONTACTER_COMMERCIAL` (`LOGIN`),
  ADD KEY `I_FK_CONTACTER_DATE` (`DATE`),
  ADD KEY `I_FK_CONTACTER_LOUEUR` (`IDENT`);

--
-- Index pour la table `Duree`
--
ALTER TABLE `Duree`
  ADD PRIMARY KEY (`CODEDUREE`);

--
-- Index pour la table `Entreprise`
--
ALTER TABLE `Entreprise`
  ADD PRIMARY KEY (`IDENT`),
  ADD KEY `I_FK_ENTREPRISE_VILLE` (`NUMVILLE`);

--
-- Index pour la table `Lieu`
--
ALTER TABLE `Lieu`
  ADD PRIMARY KEY (`IDLIEU`),
  ADD KEY `I_FK_LIEU_LOUEUR` (`IDENT`),
  ADD KEY `I_FK_LIEU_VILLE` (`NUMVILLE`);

--
-- Index pour la table `Loueur`
--
ALTER TABLE `Loueur`
  ADD PRIMARY KEY (`IDENT`),
  ADD KEY `I_FK_LOUEUR_COMMERCIAL` (`LOGIN`);

--
-- Index pour la table `Pays`
--
ALTER TABLE `Pays`
  ADD PRIMARY KEY (`IDPAYS`);

--
-- Index pour la table `Photo`
--
ALTER TABLE `Photo`
  ADD PRIMARY KEY (`NUMPHOTO`),
  ADD KEY `I_FK_PHOTO_SALLE` (`IDSALLE`);

--
-- Index pour la table `Reservant`
--
ALTER TABLE `Reservant`
  ADD PRIMARY KEY (`IDENT`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`NUMRESA`),
  ADD KEY `I_FK_RESERVATION_SALLE` (`IDSALLE`),
  ADD KEY `I_FK_RESERVATION_RESERVANT` (`IDENT`),
  ADD KEY `I_FK_RESERVATION_ENT_248` (`CODEDUREE`);

--
-- Index pour la table `Responsable`
--
ALTER TABLE `Responsable`
  ADD PRIMARY KEY (`LOGIN`);

--
-- Index pour la table `Salle`
--
ALTER TABLE `Salle`
  ADD PRIMARY KEY (`IDSALLE`),
  ADD KEY `I_FK_SALLE_LIEU` (`IDLIEU`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`LOGIN`);

--
-- Index pour la table `Ville`
--
ALTER TABLE `Ville`
  ADD PRIMARY KEY (`NUMVILLE`),
  ADD KEY `I_FK_VILLE_PAYS` (`IDPAYS`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Admin`
--
ALTER TABLE `Admin`
  ADD CONSTRAINT `FK_ADMIN_UTILISATEUR` FOREIGN KEY (`LOGIN`) REFERENCES `Utilisateur` (`LOGIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Commercial`
--
ALTER TABLE `Commercial`
  ADD CONSTRAINT `FK_COMMERCIAL_UTILISATEUR` FOREIGN KEY (`LOGIN`) REFERENCES `Utilisateur` (`LOGIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Contacter`
--
ALTER TABLE `Contacter`
  ADD CONSTRAINT `FK_CONTACTER_COMMERCIAL` FOREIGN KEY (`LOGIN`) REFERENCES `Commercial` (`LOGIN`),
  ADD CONSTRAINT `FK_CONTACTER_LOUEUR` FOREIGN KEY (`IDENT`) REFERENCES `Loueur` (`IDENT`);

--
-- Contraintes pour la table `Entreprise`
--
ALTER TABLE `Entreprise`
  ADD CONSTRAINT `FK_ENTREPRISE_VILLE` FOREIGN KEY (`NUMVILLE`) REFERENCES `Ville` (`NUMVILLE`);

--
-- Contraintes pour la table `Lieu`
--
ALTER TABLE `Lieu`
  ADD CONSTRAINT `FK_LIEU_LOUEUR` FOREIGN KEY (`IDENT`) REFERENCES `Loueur` (`IDENT`),
  ADD CONSTRAINT `FK_LIEU_VILLE` FOREIGN KEY (`NUMVILLE`) REFERENCES `Ville` (`NUMVILLE`);

--
-- Contraintes pour la table `Loueur`
--
ALTER TABLE `Loueur`
  ADD CONSTRAINT `FK_LOUEUR_COMMERCIAL` FOREIGN KEY (`LOGIN`) REFERENCES `Commercial` (`LOGIN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_LOUEUR_ENTREPRISE` FOREIGN KEY (`IDENT`) REFERENCES `Entreprise` (`IDENT`);

--
-- Contraintes pour la table `Photo`
--
ALTER TABLE `Photo`
  ADD CONSTRAINT `FK_PHOTO_SALLE` FOREIGN KEY (`IDSALLE`) REFERENCES `Salle` (`IDSALLE`);

--
-- Contraintes pour la table `Reservant`
--
ALTER TABLE `Reservant`
  ADD CONSTRAINT `FK_RESERVANT_ENTREPRISE` FOREIGN KEY (`IDENT`) REFERENCES `Entreprise` (`IDENT`);

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `FK_RESERVATION_ENT_248` FOREIGN KEY (`CODEDUREE`) REFERENCES `Duree` (`CODEDUREE`),
  ADD CONSTRAINT `FK_RESERVATION_RESERVANT` FOREIGN KEY (`IDENT`) REFERENCES `Reservant` (`IDENT`),
  ADD CONSTRAINT `FK_RESERVATION_SALLE` FOREIGN KEY (`IDSALLE`) REFERENCES `Salle` (`IDSALLE`);

--
-- Contraintes pour la table `Responsable`
--
ALTER TABLE `Responsable`
  ADD CONSTRAINT `FK_RESPONSABLE_UTILISATEUR` FOREIGN KEY (`LOGIN`) REFERENCES `Utilisateur` (`LOGIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Salle`
--
ALTER TABLE `Salle`
  ADD CONSTRAINT `FK_SALLE_LIEU` FOREIGN KEY (`IDLIEU`) REFERENCES `Lieu` (`IDLIEU`);

--
-- Contraintes pour la table `Ville`
--
ALTER TABLE `Ville`
  ADD CONSTRAINT `FK_VILLE_PAYS` FOREIGN KEY (`IDPAYS`) REFERENCES `Pays` (`IDPAYS`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
