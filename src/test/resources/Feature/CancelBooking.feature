Feature: Cancelling a booked hotel

@Reg
  Scenario Outline: Cancelling a booked hotel after generating order id
    Given UserG is on Adactin page
    When UserG should enter "<userName>" and "<password>"
    And UserG should click login button and navigated to search hotel page
    And UserG should select a "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    And UserG should click search button and user is on select hotel page, click that radio button and user should click continue button
    And UserG should enter "<firstName>", "<lastName>", "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | CVVNumber |
      | 1234567891234567 | American Express | January     |       2022 |       123 |
      | 1234567891234567 | VISA             | February    |       2021 |       456 |
      | 1234567891234567 | Master Card      | March       |       2020 |       789 |
      | 1234567891234567 | Other            | April       |       2019 |       012 |
    And UserG should select the Booked Itinerary
    Then UserG should select the cancel id button and verify the message

    Examples: 
      | userName  | password    | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 18/03/2021  | 19/03/2021   | 2 - Two       | 4 - Four        | GGG       | MMM      | XXX,YY,Z       |

@Reg
   Scenario Outline: Cancelling a booked hotel for existing order id
    Given UserH is on Adactin page
    When UserH should enter "<userName>" and "<password>"
    And UserH should click login button and navigated to search hotel page
    And UserH should select the Booked Itinerary
    Then UserH should select the cancel id button and verify the message
    
    Examples:
    | userName  | password    |
    | Karthi007 | Karthi@1989 |
    
    
  