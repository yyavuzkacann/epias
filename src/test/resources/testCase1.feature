Feature: Sayfa ve menu kontrolu
  Scenario: Seffaflık sayfasına gidilir ve kontroller yapılır
    Given anasayfaya gidilir
    When seffaflik menusu tiklanir
    And title kontrol edilir
    And sayfa maximize edilir
    And menuler kontrol edilir
    Then sayfanin eksiksiz yuklendigi gorulur