Feature: Bejelentkezés érvényes adatokkal
  Mint regisztrált ügyfél, azt szeretném, hogy a felhasználónevemmel és jelszavammal be tudjak lépni
  a Digital Bank tesztfelületre.

  Background:
    Given a böngésző megnyitotta a Digital Bank tesztfelület bejelentkezési oldalt

  @valid-login
  Scenario: Sikeres bejelentkezés demó felhasználóval
    When beírom a felhasználónevet "jsmith2"
    And beírom a jelszót "Demo123!"
    And rákattintok a "BELÉPÉS" gombra
    Then a Kezdőlap / Áttekintés oldal jelenik meg
    And megjelenik az üzenet "Üdvözöljük, J"
    And a bal oldali menü elemei aktívak
