BULK INSERT dbo.Osoba FROM 'C:\Users\Admin\Desktop\lapaniegit\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\person.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Przestepca FROM 'C:\Users\Admin\Desktop\lapaniegit\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\criminal.bulk' WITH (FIELDTERMINATOR='|');
BULK INSERT dbo.Miejsce FROM 'C:\Users\Admin\Desktop\lapaniegit\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\place.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zgloszenie FROM 'C:\Users\Admin\Desktop\lapaniegit\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\report.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zlapanie_Przestepcy FROM 'C:\Users\Admin\Desktop\lapaniegit\LapaniePrzestepcow\GeneratorLapaniaPrzestepcow\src\Data\event.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
