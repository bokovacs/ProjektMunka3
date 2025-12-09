Feature: US03 – Új folyószámla létrehozása

  A regisztrált ügyfél új folyószámlát hoz létre, hogy bizonyos pénzügyi műveleteket külön számlán kezelhessen.

  Rule: R1 – A rendszer megjeleníti az új folyószámla létrehozásához szükséges mezőket.
  - Számla neve mező
  - Számla kategória mező / legördülő lista
  - Mentés gomb
    Rule: R2 – A rendszer validálja a megadott adatokat és jelzi az esetleges hibákat.
  Rule: R3 – Érvényes adatok esetén a rendszer létrehozza az új folyószámlát.
    Rule: R4 – A sikeresen létrehozott folyószámla megjelenik a bankszámlák listájában.

    Scenario Outline: Új folyószámla létrehozása érvényes adatokkal
      Given the "New Current Account" page is displayed
      And the account name field, account type selector and save button are visible
      When I create a new account with "<accountName>" and "<accountType>"
      Then the new account is created successfully
      And the new account appears in the account list

      Examples:
        | accountName     | accountType |
        | Folyószámla2    | Standard    |
        | Folyószámla_Üz  | Business    |

    Scenario Outline: Hibás adatok megadása új folyószámla létrehozásakor
      Given the "New Current Account" page is displayed
      And the account name field, account type selector and save button are visible
      When I create a new account with "<accountName>" and "<accountType>"
      Then an error message is displayed with "<errormessage>"
      And I stay on the account creation page

      Examples:
        | accountName | accountType | errormessage                       |
        |             | Standard    | Account name is required           |  # hiányzó név
        | Invalid!@#  | Standard    | Invalid characters in account name |  # tiltott karakterek
