Feature: US01 – Bejelentkezés érvényes adatokkal
  A regisztrált ügyfél sikeresen be tud lépni a rendszerbe érvényes hitelesítő adatokkal.

  Rule: R1 – A login oldalon rendelkezésre állnak a hitelesítéshez szükséges mezők és vezérlők.
  - Felhasználónév mező
  - Jelszó mező
  - "Emlékezzen rám" jelölőnégyzet
  - BELÉPÉS gomb
    Rule: R2 – Érvényes felhasználónév + jelszó páros esetén a rendszer a főoldalra irányít.
    Rule: R3 – A főoldalon megjelenik a személyre szabott üdvözlő üzenet.
    Rule: R4 – A bal oldali menü elemei a bejelentkezést követően elérhetővé válnak.

    Scenario Outline: Sikeres bejelentkezés érvényes hitelesítő adatokkal
      Given the login page is displayed
      And the username field, password field, remember-me checkbox and login button are visible
      When I sign in using "<username>" and "<password>"
      Then I am redirected to the home page
      And the welcome message is displayed
      And the menu items are available

      Examples:
        | username | password |
        | jsmith2  | Demo123! |
