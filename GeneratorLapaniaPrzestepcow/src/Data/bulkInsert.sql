BULK INSERT dbo.Przestepca FROM 'C:\Users\Admin\Desktop\criminals.bulk' WITH (FIELDTERMINATOR='|');
BULK INSERT dbo.Zgloszenie FROM 'C:\Users\Admin\Desktop\report.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');
BULK INSERT dbo.Zlapanie_Przestepcy FROM 'C:\Users\Admin\Desktop\event.bulk' WITH (FIELDTERMINATOR='|', ROWTERMINATOR='0x0a');

INSERT INTO Zgloszenie(Data,FK_Zglaszajacy) VALUES('2014-12-3', 32454);0