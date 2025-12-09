Feature: US05 – Biztonságos kijelentkezés
  A bejelentkezett ügyfél biztonságosan kijelentkezik a rendszerből,
  hogy a banki felület zárolt és védett állapotban maradjon a munkamenet befejezése után.

  Rule: R1 – A felhasználói menü tartalmazza a kijelentkezés funkciót.
    Rule: R2 – Kijelentkezés után a rendszer visszairányít a bejelentkezési oldalra.
  Rule: R3 – A bejelentkezési oldalon megjelenik a „Sikeres kilépés.” sikerüzenet.
    Rule: R4 – Kijelentkezés után az oldal frissítése ismét bejelentkezést igényel.

    Scenario: Sikeres kijelentkezés a felhasználói menüből
      Given I am logged in as a registered customer
      And the user menu is visible in the top right corner
      When I open the user menu
      And I click the logout option
      Then I am redirected to the login page
      And a success message is displayed with "Sikeres kilépés."
      And refreshing the page requires login again

