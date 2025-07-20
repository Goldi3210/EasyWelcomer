# EasyWelcomer

![EasyWelcomer Banner](https://img.shields.io/badge/Minecraft-EasyWelcomer-brightgreen)

## Opis

**EasyWelcomer** to lekki i prosty plugin do Minecraft, który pozwala na spersonalizowane powitania nowych i powracających graczy na serwerze.  
Wszystko konfigurowalne w jednym pliku `config.yml` zawiera wiadomości na czacie, tytuły, dźwięki, particle, actionbar i więcej!

---

## Funkcje

- Wyświetlanie wiadomości powitalnej na czacie  
- Konfigurowalne tytuły i podtytuły (title & subtitle)  
- Odtwarzanie dźwięków przy dołączeniu gracza  
- Pokazywanie efektów particle wokół gracza  
- Wysyłanie tekstu na actionbar  
- Obsługa PlaceholderAPI (opcjonalna)  
- Możliwość wyłączenia poszczególnych efektów w configu  
- Starter items (opcjonalnie)  

---

## Instalacja

1. Pobierz najnowszą wersję pluginu z [Releases](https://github.com/Goldi3210/EasyWelcomer/releases)  
2. Umieść plik `.jar` w folderze `plugins` na swoim serwerze Minecraft  
3. Uruchom serwer a plugin automatycznie stworzy folder `EasyWelcomer` z `config.yml`  
4. Dostosuj `config.yml` według własnych potrzeb  
5. Restartuj lub przeładuj serwer

---

## Konfiguracja (`config.yml`)

```
enableMessage: true
message: "&aWitaj &6%player%&a na serwerze!"

enableTitle: true
title: "&bWitamy!"
subtitle: "&7Miłej gry!"

enableSound: true
sound: "ENTITY_PLAYER_LEVELUP"

enableParticle: true
particle: "VILLAGER_HAPPY"

enableActionbar: true
actionbar: "&eDobrej zabawy, %player%!"

onlyFirstJoin: false

starterItems:
  enabled: false
  items:
    - "DIAMOND_SWORD:1"
    - "GOLDEN_APPLE:3"
