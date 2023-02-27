Feature: Kullanici ebay.de sitesinde aranan bilgisayar urununun windows 10 ozelligini barindirdigini kontrol eder

  @questionSix
      # Asagidaki sekilde kullanıcının davranışlarını tanımlayan geliştirmeye BDD yani Behavior Driven Development denir.
  Scenario: Kullanici ebay.de sitesinde arama butonuna computer yazarak cikan seceneklerde windows 10 ozelligini kontrol eder
    When Kullanici belirtilen sayfaya gider
    And Kullainci cookies secenegini accept all seçenegi ile kabul eder
    And Kullanici serarchbox kutusuna computer kelimesini yazar
    And Kullanici arama butonuna basar
    And Kullanici filtre bolumunden windows ten secenegine tiklar
    Then Cikan seceneklerin en usttekinin windows ten ozeligini barindirdigi dogrulanir
    And Kullanici sayfayi kapatir

