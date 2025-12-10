Feature: US01 – Bejelentkezés érvényes adatokkal
  A regisztrált ügyfél sikeresen be tud lépni.

  Background:
    Given the login page is displayed

  Rule: R1 – A login oldalon rendelkezésre állnak.
    Rule: R2 – Érvényes felhasználónév + jelszó.
  Rule: R3 – A főoldalon megjelenik.
    Rule: R4 – A bal oldali menü.

    Scenario Outline: Sikeres bejelentkezés.
      When I sign in using "<username>" and "<password>"
      Then I am redirected to the home page
      And the welcome message is displayed
      And the menu items are available

      Examples:
        | username | password |
        | jsmith2  | Demo123! |
