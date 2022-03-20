Feature: Duyuruları Listele
  Scenario: Belirlenen tarih araliginin listelendigi gorulur
    Given anasayfaya yonlenir
    When duyurular aranir
    And linke tiklanir
    And filtre acilir
    And tarih araligi girilir
    Then dogru tarihin listelendigi gorulur