USE LapaniePrzestepcow
GO
--TABLE : Plec
INSERT INTO Plec(Nazwa) VALUES('Mężczyzna');
INSERT INTO Plec(Nazwa) VALUES('Kobieta');
go
--TABLE : Ocena
INSERT INTO Ocena(PoziomZadowolenia) VALUES(1);
INSERT INTO Ocena(PoziomZadowolenia) VALUES(2);
INSERT INTO Ocena(PoziomZadowolenia) VALUES(3);
go
--TABLE : Rodzaj_Przestepstwa
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Kradzież');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Zabójstwo');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Narkotyki');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Pobicie');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Alkohol w miejscu publicznym');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Sprzedaż chipsów w podstawówce');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Inne');
go
--TABLE : Dzielnica
INSERT INTO Dzielnica(Nazwa) VALUES('Aniołki');
INSERT INTO Dzielnica(Nazwa) VALUES('Brętowo');
INSERT INTO Dzielnica(Nazwa) VALUES('Brzeźno');
INSERT INTO Dzielnica(Nazwa) VALUES('Chełm');
INSERT INTO Dzielnica(Nazwa) VALUES('Jasień');
INSERT INTO Dzielnica(Nazwa) VALUES('Kokoszki');
INSERT INTO Dzielnica(Nazwa) VALUES('Letnica');
INSERT INTO Dzielnica(Nazwa) VALUES('Matarnia');
INSERT INTO Dzielnica(Nazwa) VALUES('Młyniska');
INSERT INTO Dzielnica(Nazwa) VALUES('Nowy');
INSERT INTO Dzielnica(Nazwa) VALUES('Oliwa');
INSERT INTO Dzielnica(Nazwa) VALUES('Olszynka');
INSERT INTO Dzielnica(Nazwa) VALUES('Osowa');
INSERT INTO Dzielnica(Nazwa) VALUES('Piecki-Migowo');
INSERT INTO Dzielnica(Nazwa) VALUES('Przeróbka');
INSERT INTO Dzielnica(Nazwa) VALUES('Przymorze');
INSERT INTO Dzielnica(Nazwa) VALUES('Przymorze');
INSERT INTO Dzielnica(Nazwa) VALUES('Rudniki');
INSERT INTO Dzielnica(Nazwa) VALUES('Siedlce');
INSERT INTO Dzielnica(Nazwa) VALUES('Stogi');
INSERT INTO Dzielnica(Nazwa) VALUES('Strzyża');
INSERT INTO Dzielnica(Nazwa) VALUES('Suchanino');
INSERT INTO Dzielnica(Nazwa) VALUES('Śródmieście');
INSERT INTO Dzielnica(Nazwa) VALUES('Ujeścisko-Łostowice');
INSERT INTO Dzielnica(Nazwa) VALUES('Wrzeszcz');
INSERT INTO Dzielnica(Nazwa) VALUES('Wrzeszcz');
INSERT INTO Dzielnica(Nazwa) VALUES('Wyspa');
INSERT INTO Dzielnica(Nazwa) VALUES('Wzgórze');
INSERT INTO Dzielnica(Nazwa) VALUES('Zaspa-Młyniec');
INSERT INTO Dzielnica(Nazwa) VALUES('Zaspa-Rozstaje');
INSERT INTO Dzielnica(Nazwa) VALUES('Żabianka');
go
--TABLE : Rodzaj_Przestepstwa
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Kradzież');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Zabójstwo');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Narkotyki');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Pobicie');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Alkohol w miejscu publicznym');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Sprzedaż chipsów w podstawówce');
INSERT INTO Rodzaj_Przestepstwa(Rodzaj) VALUES('Inne');
go
--TABLE : Kolor_Skory
INSERT INTO Kolor_Skory(Kolor) VALUES('Biały');
INSERT INTO Kolor_Skory(Kolor) VALUES('Czarny');
INSERT INTO Kolor_Skory(Kolor) VALUES('Żólty');
go
BULK INSERT dbo.Osoba FROM 'C:\Users\Przemysław\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\person.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Przestepca FROM 'C:\Users\Przemysław\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\criminal.bulk' WITH (FIELDTERMINATOR='|');
BULK INSERT dbo.Miejsce FROM 'C:\Users\Przemysław\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\place.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zgloszenie FROM 'C:\Users\Przemysław\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\report.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zlapanie_Przestepcy FROM 'C:\Users\Przemysław\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\event.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
