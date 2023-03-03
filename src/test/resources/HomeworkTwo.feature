Feature: Kullanici sepete bir urun ekler ve anasayfada bulunan sepet simgesindeki sayi degiskligini gorur

  Background:
    Given Kullanici anasayfaya gider

    @homeworkTwo
    Scenario: Kullanici sepete bir urun ekleyince sepet simgesindeki sayi bir artsin
      When Kullanici cookies ile ilgili onayi kabul eder
      And Kullanici ust menu bardan pricing linkine tiklar
      And Kullanici bir paketi buy now butonu ile sepete ekler
      And Kullanici anasayfaya tekrar geri gider
      Then Kullanici sepet simgesi uzerindeki rakami dogrular