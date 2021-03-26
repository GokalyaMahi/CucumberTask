Feature: Booking a hotel and Generate Order ID in Adactin Hotel Page

@Reg
  Scenario Outline: Booking a Hotel with valid credentials
    Given UserE is on Adactin page
    When UserE should enter "<userName>" and "<password>"
    And UserE should click login button and navigated to search hotel page
    And UserE should select a "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    And UserE should click search button and user is on select hotel page, click that radio button and user should click continue button
    And UserE should enter "<firstName>", "<lastName>", "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | CVVNumber |
      | 1234567891234567 | American Express | January     |       2022 |       123 |
      | 1234567891234567 | VISA             | February    |       2021 |       456 |
      | 1234567891234567 | Master Card      | March       |       2020 |       789 |
      | 1234567891234567 | Other            | April       |       2019 |       012 |
    Then UserE should verify success message

    Examples: 
      | userName  | password    | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 18/03/2021  | 19/03/2021   | 2 - Two       | 4 - Four        | GGG       | MMM      | XXX,YY,Z       |

@Reg @Smoke
  Scenario Outline: Booking a Hotel without entering any fields in select hotel page
    Given UserF is on Adactin page
    When UserF should enter "<userName>" and "<password>"
    And UserF should click login button and navigated to search hotel page
    And UserF should select a "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    And UserF should click search button and user is on select hotel page
    And UserF should click the radio button and click continue button
    And UserF should not enter any credentials and click book now button
    Then UserF should verify the error messages 


    Examples: 
      | userName  | password    | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 18/03/2021  | 19/03/2021   | 2 - Two       | 4 - Four        |
    