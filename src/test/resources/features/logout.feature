Feature: US05 – Biztonságos kijelentkezés
  A bejelentkezett ügyfél biztonságosan kijelentkezik a rendszerből,
  hogy a banki felület zárolt állapotban maradjon a munkamenet befejezése után.

  Background:
    Given I opened the DBank
    And I accepted the cookies

  Scenario Outline: Sikeres kijelentkezés a profil avatárról
    When I sign in using "<username>" and "<password>"
    And I log out
    Then I am redirected to the login page
    And a success message is displayed with "Logout completed."
    And the browser is closed

    Examples:
      | username | password |
      | jsmith2  | Demo123! |
