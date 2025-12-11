Feature: US01 – Bejelentkezés érvényes adatokkal
  A regisztrált ügyfél sikeresen be tud lépni.

  Background:
    Given the login page is displayed

  Rule: R1 – A login oldalon rendelkezésre állnak a mezők.
    Rule: R2 – Érvényes felhasználónév + jelszó sikeres belépést eredményez.
  Rule: R3 – A főoldalon megjelenik a Dashboard cím.

    Scenario Outline: Sikeres bejelentkezés

      When I sign in using "<username>" and "<password>"
      Then I am redirected to the home page

      Examples:
        | username | password |
        | jsmith2  | Demo123! |
