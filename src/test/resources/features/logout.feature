Feature: US05 – Biztonságos kijelentkezés
  A bejelentkezett ügyfél biztonságosan kijelentkezik a rendszerből,
  hogy a banki felület zárolt és védett állapotban maradjon a munkamenet befejezése után.

  Background:
    Given the profile avatar is visible in the header

  Rule: R1 – A felhasználói menü tartalmazza a kijelentkezés funkciót.
    Rule: R2 – Kijelentkezés után a rendszer visszairányít a login oldalra.
  Rule: R3 – A login felületen megjelenik a „Logout completed felirat.”


    Scenario: Sikeres kijelentkezés a profil avatárról

      When I open the profile menu from the avatar
      And I click the logout option
      Then I am redirected to the login page
      And a success message is displayed with "Logout completed."
