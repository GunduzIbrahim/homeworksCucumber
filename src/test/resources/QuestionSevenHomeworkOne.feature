Feature: Kullanici belirtilen sitede iki kelime aratir ve olup olmadigini kontrol eder

  @questionSeven

    Scenario Outline: Kullanici ilgili sitede iki kelimeyi arar ve varliklarini kontrol eder
  Given  Kullanici belirtilen siteye gider
    And  Kullanici cookie seceneklerinden accept and close a tiklar
    And  Kullanici ust menu bardaki arama simgesine tiklar
    And  Kuulanici search box kutusuna "<aranacak_kelime>" aranacak kelime yazar
    And  Kullanici arama butonuna tiklar
    Then  Kullanici cikan ilk secenegin "<aranacak_kelime>" aranan kelimeleri icerdigini kontrol eder
    And Kullanici close page

    Examples:
      |aranacak_kelime|
      |keyword test|
      |data testing|
