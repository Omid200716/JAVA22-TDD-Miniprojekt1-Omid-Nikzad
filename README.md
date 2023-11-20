# JAVA22-TDD-Miniprojekt1-Omid-Nikzad
TriangleTest
Min huvuduppgift var att säkerställa en täckning på minst 80 % utan att ändra något i den ursprungliga Triangle-klassen. Jag använde JUnit 5 för mina tester, vilket gav mig en bra mix av flexibilitet och funktionalitet.

Utmaningar och Lösningar:

Komplexitet i att Testa Användarinput:
En av de större utmaningarna var att testa getUserInput()-metoden i Triangle-klassen. Denna metod krävde användarinteraktion, vilket är svårt att återskapa i en enhetstestmiljö. För att lösa detta använde jag en teknik för att simulera användarinput genom att ersätta System.in med en ByteArrayInputStream som innehåller fördefinierad input. Detta tillät mig att utföra tester utan faktisk användarinteraktion.

Hantera Exception och Felaktig Input:
Jag stötte på en annan utmaning när jag skulle testa hur klassen hanterar ogiltig eller felaktig input. Jag skapade specifika testfall för att testa dessa situationer, inklusive situationer med negativa tal och ogiltiga sidlängder. Dessa tester hjälpte till att säkerställa att klassen uppför sig som förväntat även under felaktiga förhållanden.

Boundary Testing:
Att identifiera och testa gränsvärden var en annan viktig aspekt. Jag inkluderade testfall för "nästan ogiltiga" trianglar och extremt stora trianglar för att se till att klassen korrekt hanterade dessa gränsvärden.

Förbättring av Testläsbarhet med @DisplayName:
För att göra mina tester mer lättförståeliga och beskrivande, använde jag @DisplayName-annotationen i JUnit. Detta var speciellt användbart när jag ville förklara syftet med varje testfall på ett klart och tydligt sätt.

Säkerställa Testtäckning:
Ett kontinuerligt fokus låg på att säkerställa att alla relevanta delar av koden täcktes av testerna. Jag använde IDE:ns inbyggda testtäckningsverktyg för att identifiera vilka delar av koden som inte testades och justerade mina tester därefter.

Detta projekt gav mig insikter i vikten av enhetstester och hur de kan användas för att säkerställa att en kodbas är robust och felfri. Jag lärde mig också vikten av att skriva klara och beskrivande tester samt att tänka igenom alla möjliga scenarier som en metod kan stöta på. Trots utmaningarna, kände jag att jag lyckades uppnå mina mål och fick värdefulla erfarenheter inom mjukvarutestning.
