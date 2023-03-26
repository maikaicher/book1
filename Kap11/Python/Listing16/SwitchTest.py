def printWeekday(day):
  match day:
    case (1):
      print("Montag")
    case (2):
      print("Dienstag")
    case (3):
      print("Mittwoch")
    case (4):
      print("Donnerstag")
    case (5):
      print("Freitag")
    case _:
      print("Wochenende")


printWeekday(2)