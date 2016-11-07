USE LapaniePrzestepcow
GO
BULK INSERT dbo.Osoba FROM 'C:\Users\Przemys³aw\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\person.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Przestepca FROM 'C:\Users\Przemys³aw\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\criminal.bulk' WITH (FIELDTERMINATOR='|');
BULK INSERT dbo.Miejsce FROM 'C:\Users\Przemys³aw\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\place.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zgloszenie FROM 'C:\Users\Przemys³aw\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\report.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zlapanie_Przestepcy FROM 'C:\Users\Przemys³aw\Documents\NetBeansProjects\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\event.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');