Feature: US04 – Folyószámla részleteinek és tranzakcióinak megtekintése
  A regisztrált ügyfél kiválaszt egy folyószámlát, és áttekinti annak részleteit és tranzakcióit,
  hogy nyomon kövesse az egyenleg változását és a számlán történt műveleteket.

  Rule: R1 – A rendszer lehetővé teszi egy adott folyószámla kiválasztását részletes megtekintésre.
    Rule: R2 – A részletező oldalon megjelenik: számlanév, típus, tulajdonjog, számlaszám, kamatláb, aktuális egyenleg.
  Rule: R3 – A részletező oldalon megjelenik a számla státusza (aktív vagy inaktív).
    Rule: R4 – A részletező oldalon tranzakciólista jelenik meg: dátum, kategória, leírás, összeg, egyenleg oszlopokkal.
  Rule: R5 – A tranzakciólista lapozható, és alapértelmezetten a legutóbbi tranzakciók láthatók.
    Rule: R6 – Tranzakciók hiányában egy egyértelmű üzenet jelzi, hogy nincs megjeleníthető tétel.

    Scenario Outline: Egyéni vagy közös folyószámla részleteinek megtekintése
      Given I am logged in as a registered customer
      And I navigate to the "Current Accounts" page
      And the account list is displayed
      When I select the "<accountName>" account from the list
      Then the account details are displayed for "<accountName>"
      And the ownership type is shown as "<ownershipType>"
      And the account number, interest rate and current balance are displayed
      And the account status is displayed as "Active"
      And the transaction list is displayed with columns "Date", "Category", "Description", "Amount" and "Balance"
      And the most recent transactions are visible by default

      Examples:
        | accountName         | ownershipType |
        | Folyószámla1        | Individual    |
        | Folyószámla_Közös   | Joint         |

    Scenario: Folyószámla tranzakciók nélkül
      Given I am logged in as a registered customer
      And I navigate to the "Current Accounts" page
      And the account list is displayed
      When I select an account without transactions
      Then a message is displayed indicating that no transactions are available
      And the account details are still displayed
      And the transaction list area is visible but empty
