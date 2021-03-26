Feature: Search a hotel in Adactin Hotel Page

@Reg
  Scenario Outline: Search a hotel by selecting all the fields
    Given UserA is on Adactin page
    When UserA should enter "<userName>", "<password>" and click the login button 
    And UserA should navigate to search hotel page
    And UserA should select a "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    Then UserA should navigate to the select hotel page

    Examples: 
      | userName  | password    | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 25/03/2021  | 26/03/2021   | 2 - Two       | 4 - Four        |
      
   
 @Smoke     
  Scenario Outline: Search a hotel by selecting only mandatory fields
    Given UserB is on Adactin page
    When UserB should enter "<userName>", "<password>" and click the login button 
    And UserB should navigate to search hotel page
    And UserB should select a mandatory fields "<location>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>"
    Then UserB should navigate to the select hotel page

    Examples: 
      | userName  | password    | location | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Karthi007 | Karthi@1989 | Sydney   | 1 - One       | 25/03/2021  | 26/03/2021   | 2 - Two       |
      
 @Smoke   
  Scenario Outline: Checking the date credentials
    Given UserC is on Adactin page
    When UserC should enter "<userName>", "<password>" and click the login button 
    And UserC should navigate to search hotel page
    And UserC should select a "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    Then UserC should select the search button and verify the error messages


    Examples: 
      | userName  | password    | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Karthi007 | Karthi@1989 | Sydney   | Hotel Creek | Standard | 1 - One       | 25/03/2021  | 23/03/2021   | 2 - Two       | 4 - Four        |
      
 @Smoke @Reg    
  Scenario Outline: Search a hotel without entering any fields  
    Given UserD is on Adactin page
    When UserD should enter "<userName>" and "<password>"
    And UserD should click login button and navigated to search hotel page
    Then UserD should select the search button and verify the error message
    
    Examples:
    | userName  | password    |
    | Karthi007 | Karthi@1989 |