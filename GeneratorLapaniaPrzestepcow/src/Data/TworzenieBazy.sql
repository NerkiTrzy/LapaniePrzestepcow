CREATE DATABASE LapaniePrzestepcow
go

USE LapaniePrzestepcow
GO

CREATE TABLE Kolor_Skory
(
    ID_Kolor_Skory INTEGER IDENTITY(1,1) PRIMARY KEY, /* Generuje klucz rozpoczynaj�c o 1 i zwi�ksza go za ka�dym razem o 1*/
	Kolor VARCHAR(20) NOT NULL, 
)
GO

CREATE TABLE Plec
(
	ID_Plec INTEGER IDENTITY(1,1) PRIMARY KEY,
	Nazwa VARCHAR(20) NOT NULL,
)
GO

CREATE TABLE Osoba
(
	ID_Osoba INTEGER IDENTITY(1,1) PRIMARY KEY,
	Pesel VARCHAR(11) NOT NULL,
	Imie VARCHAR(20) NOT NULL,
	Nazwisko VARCHAR(40) NOT NULL,
	FK_Plec INTEGER FOREIGN KEY REFERENCES Plec NOT NULL,
)
GO

CREATE TABLE Zgloszenie
(
	ID_Zgloszenie INTEGER IDENTITY(1,1) PRIMARY KEY,
	Data DATETIME NOT NULL,
	FK_Zglaszajacy INTEGER FOREIGN KEY REFERENCES Osoba NOT NULL,
)
GO

CREATE TABLE Przestepca
(
	ID_Przestepca INTEGER IDENTITY(1,1) PRIMARY KEY,
	FK_Osoba INTEGER FOREIGN KEY REFERENCES Osoba NOT NULL,
	FK_KolorSkory INTEGER FOREIGN KEY REFERENCES Kolor_Skory,
	CzyWczesniejLamalPrawo BIT,
)
GO

CREATE TABLE Ocena
(
	ID_Ocena INTEGER IDENTITY(1,1) PRIMARY KEY,
	PoziomZadowolenia INTEGER NOT NULL,
)
GO

CREATE TABLE Dzielnica
(
	ID_Dzielnica INTEGER IDENTITY(1,1) PRIMARY KEY,
	Nazwa VARCHAR(20) NOT NULL,
)
GO



CREATE TABLE Miejsce
(
	ID_Miejsce INTEGER IDENTITY(1,1) PRIMARY KEY,
	FK_Dzielnica INTEGER FOREIGN KEY REFERENCES Dzielnica NOT NULL,
	Nazwa_Ulicy VARCHAR(100) NOT NULL,
	Numer VARCHAR(20),
)
GO

CREATE TABLE Rodzaj_Przestepstwa
(
	ID_Rodzaj_Przestepstwa INTEGER IDENTITY(1,1) PRIMARY KEY,
	Rodzaj VARCHAR(60),
)
GO

CREATE TABLE Zlapanie_Przestepcy
(
	ID_Zlapania INTEGER IDENTITY(1,1) PRIMARY KEY,
	FK_Zgloszenie INTEGER FOREIGN KEY REFERENCES Zgloszenie NOT NULL,
	FK_Policjant INTEGER FOREIGN KEY REFERENCES Osoba NOT NULL,
	FK_Miejsce INTEGER FOREIGN KEY REFERENCES Miejsce NOT NULL,
	FK_Ocena INTEGER FOREIGN KEY REFERENCES Ocena NOT NULL,
	FK_Przestepca INTEGER FOREIGN KEY REFERENCES Przestepca NOT NULL,
	FK_RodzajPrzestepstwa INTEGER FOREIGN KEY REFERENCES Rodzaj_Przestepstwa NOT NULL,
)
GO