Feature: US02 – Visszajelzés hibás vagy hiányzó hitelesítési adatokra
  A bejelentkezni kívánó felhasználó tiszta és egyértelmű visszajelzést kap
  minden hibás vagy hiányzó hitelesítési adatra, hogy azonnal javíthassa azokat.

  Rule: R1 – Sikertelen bejelentkezési kísérlet esetén a rendszer hibaüzenetet jelenít meg.
    Rule: R2 – A rendszer hibaüzenetet ad, ha bármely hitelesítési adat hiányzik.
  Rule: R3 – A rendszer hibaüzenetet ad, ha a felhasználónév és jelszó nem egyezik a nyilvántartott adatokkal.
    Rule: R4 – Sikertelen belépés után a felhasználó a bejelentkezési oldalon marad.

    Scenario Outline: Sikertelen belépési kísérletek hibás vagy hiányzó adatokkal
      Given the login page is displayed
      And the username field, password field and login button are visible
      When I sign in using "<username>" and "<password>"
      Then an error message is displayed with "<errormessage>"
      And I stay on the login page

      Examples:
        | username | password  | errormessage                          |
        | jsmith2  | Demo123!! | Invalid credentials                   |  # hibás jelszó
        |          | Demo123!  | Username is required                  |  # hiányzó felhasználónév
        | jsmith2  |           | Password is required                  |  # hiányzó jelszó

