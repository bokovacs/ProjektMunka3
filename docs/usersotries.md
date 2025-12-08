US01 – Bejelentkezés érvényes adatokkal

Mint regisztrált ügyfél  szeretném, hogy a felhasználónevemmel és jelszavammal
beléphessek a  Digital Bank felületére, hogy kényelmesen elérjem számlaegyenlegemet 
és pénzügyeim áttekintését.


Elfogadási kritériumok

1. A bejelentkezési oldalon megjelenik a Felhasználónév és Jelszó mező, az
„Emlékezzen rám” jelölőnégyzet és a BELÉPÉS gomb.
2. Érvényes felhasználónév–jelszó páros megadása után a rendszer a főoldalra 
(Kezdőlap - Áttekintés) irányít.
3. A főoldalon látható az „Üdvözöljük, (saját nevünk)” üzenet.
4. A bal oldali menü (Kezdőlap, Bankszámlák, Tranzakciók / Átutalások stb.) 
aktívvá válik.


US02 – Visszajelzés eltérő vagy hiányzó hitelesítési adatokra

Mint bejelentkezni kívánó felhasználó szeretném, hogy a rendszer egyértelmű
üzenetben jelezze az eltérő vagy hiányzó adatokat, hogy azonnal javíthassam őket
és folytathassam a belépést.


Elfogadási kritériumok

1. Amikor üresen marad bármelyik mező a BELÉPÉS gomb megnyomása után, figyelmeztető
   hibaüzenet jelenik meg (piros textbox).
2. Amikor a megadott felhasználónév–jelszó páros eltér a rendszerben tárolt adatoktól,
   a rendszer hibaüzenetet ad (piros textbox).
3. A felhasználó a bejelentkezési oldalra kerül.


US03 – Számla egyenleg áttekintése a főoldalon 

Mint ügyfél szeretném, hogy a bejelentkezés utáni kezdőoldal (Áttekintés)
grafikonokon jelenítse meg számlaegyenlegem és tranzakcióim összegzését,  
hogy egy pillantással átlássam pénzügyi helyzetemet.


Elfogadási kritériumok 

1. A főoldalon látható a „Számla Egyenleg Összegzése” grafikon.
2. A főoldalon megjelenik a „Befizetés vs. Kifizetés (Utolsó 3 hónap)” grafikon
a megfelelő jelmagyarázattal.
3. A „Kifizetések kategóriánként (Utolsó 3 hónap)” és „Befizetések kategóriánként 
(Utolsó 3 hónap)” szekciók megjelennek, és adatok esetén a kategóriák szerinti 
bontást mutatják.
4. A grafikonok a háttérben tárolt tranzakciós adatokkal összhangban jelennek meg.


US04 – User Story – A Folyószámla menü használata

Felhasználóként szeretném, hogy a bal oldali navigációs sávban található 
„Folyószámla” menü egyértelműen áttekinthető és könnyen kezelhető legyen,
hogy gyorsan elérhessem a meglévő folyószámláimat, illetve új számlát 
hozhassak létre.

Elfogadási kritériumok
1. A menü lenyitható és összezárható
A „Folyószámla” főmenüpontra kattintva a rendszer lenyitja vagy összecsukja az
alatta található almenüpontokat. A felhasználó látja, hogy a menü nyitott vagy
zárt állapotban van.
2. A „Folyószámla megtekintése” almenüpont működése
Amikor a felhasználó erre az opcióra kattint, a rendszer megjeleníti az összes
meglévő folyószámlát. A felhasználó vissza tud navigálni más menüpontokra a bal 
oldali menüből.
3. Az „Új folyószámla” almenüpont működése
A menüpontra kattintva a rendszer az új folyószámla létrehozási űrlapra navigál.
Az űrlap minden szükséges mezőt és választási lehetőséget tartalmaz.
A felhasználó innen visszatérhet a folyószámlák listájához.

US05 – User Story – Új folyószámla létrehozása

Felhasználóként szeretném, hogy az „Új folyószámla” oldalon egyszerűen és
érthetően adhassam meg a szükséges adatokat egy új számla megnyitásához,
hogy gyorsan elindíthassam egy új folyószámla használatát a banki rendszerben.

Elfogadási kritériumok
1. Számlatípus kiválasztása
Az oldal két számlatípust jelenít meg:

Normál folyószámla
Kamatos folyószámla

A felhasználó egyértelműen ki tudja választani a számára megfelelőt.

2. Tulajdonosi típus megadása
A felhasználó kiválaszthatja, hogy a számla:

Egyéni
Közös

A rendszer a választást rögzíti és a további lépésekben figyelembe veszi.
3. Számla nevének megadása
A „Számla neve” mező kitölthető, és egy rövid leírást kér az azonosításhoz.
A mező üresen nem kerülhet beküldésre; kötelező adatnak számít.
4. Kezdő befizetés összegének rögzítése
A felület lehetőséget ad a kezdő befizetés összegének megadására.
Csak érvényes numerikus összeg fogadható el.
A példaszöveg jelzi a minimálisan szükséges befizetést.
5. Beküldés és visszaállítás működése
A „Beküldés” gombra kattintva a rendszer ellenőrzi az űrlap helyes kitöltését, 
majd létrehozza az új számlát. A sikeres számlanyitást a rendszer megerősítő
üzenettel jelzi. A „Visszaállítás” gomb törli a kitöltött mezőket és visszaállítja
az űrlapot alapállapotba.
6. Sikeres létrehozás utáni viselkedés
Az új folyószámla megjelenik a folyószámla-listában.
A felhasználó átnavigálhat a számlák áttekintő oldalára, ahol ellenőrizheti az
újonnan létrehozott számlát.

US6 – A létrehozott folyószámla adatainak megjelenítése

Felhasználóként  szeretném, hogy egy új folyószámla sikeres létrehozása után a
rendszer azonnal megjelenítse a számla részletes adatait és a hozzá tartozó 
tranzakciós listát, hogy rögtön ellenőrizhessem a számlanyitás eredményét és 
az induló egyenleget.

Elfogadási kritériumok

1. Sikeres létrehozás visszajelzése
A folyamat befejezése után a rendszer egy zöld színű megerősítő üzenetet jelenít
meg, amely tartalmazza:

a. hogy a számla létrejött,
b. milyen típusú számla jött létre,
c. és milyen névvel került rögzítésre.

2. A létrehozott folyószámla adatainak megjelenítése
A felületen azonnal látható a számla részletes információs panelje, amely tartalmazza:

a. a számla nevét,
b. a számla típusát,
c. a tulajdonosi kategóriát,
d. a számlaszámot,
e. a kamatlábat,
f. az aktuális egyenleget.

A számlához tartozó státusz (pl. aktív) is jól láthatóan jelölve van.

3. Tranzakciók megjelenítése
A rendszer listázza a számlához tartozó tranzakciókat egy táblázatban.
A táblázat az alábbi adatokat jeleníti meg:

a. dátum,
b. kategória (pl. bevétel),
c. leírás,
d. összeg,
e. egyenleg.

A tranzakciólista lapozható, a „Previous” és „Next” gombok működnek.
A keresőmező segítségével a felhasználó szűrhet a megjelenített sorokra.

4. Induló befizetés megjelenése
A számlanyitáskor megadott kezdő befizetés azonnal tranzakcióként megjelenik a listában.
Az egyenleg mező tükrözi a befizetett összeget.

5. Oldal konzisztens működése
A felhasználó a bal oldali menüből bármikor továbbléphet más funkciókra.
A számlaadatok mindig a létrehozott számla aktuális állapotát mutatják.

US07 – Biztonságos kijelentkezés

Mint biztonságra figyelő ügyfél szeretném, hogy a profilomból egy kattintással
kijelentkezhessek,  hogy a banki felületem lezárt állapotban maradjon, amikor
befejezem a munkát.


Elfogadási kritériumok

1. A bejelentkezett állapotban a jobb felső sarokban elérhető a felhasználói menü,
   ahol választható a kijelentkezés.
2. Kijelentkezés után a rendszer visszairányít a bejelentkezési oldalra.
3. A kijelentkezési oldalon zöld sikerüzenet jelenik meg: „Sikeres kilépés.”
4. Kijelentkezés után friss oldalbetöltéskor a rendszer újra bejelentkezést kér.