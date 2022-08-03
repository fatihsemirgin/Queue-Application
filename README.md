# Queue Application
Java program for a simple version of the Lotto game.
## Two people play this game with:
- cards
- bags
## Description
- Each card consists of 7 numbers. The numbers are ranged from 1 to 17.
- At the beginning of the game, each card (queue) should be randomly filled with distinct values. So, the numbers in one queue
- should be different from each other.
## Example
![Ekran görüntüsü 2022-08-03 164352](https://user-images.githubusercontent.com/109742155/182623433-5577a59c-41fc-44b2-94a2-03fe9018881c.png)
- There is a bag1 (queue) that initially includes all integers from 1 to 17. The program selects a number from this bag randomly and
removes it from bag1. Each player deletes that number from his/her queue. Selected numbers are added to another bag (queue),
named bag2, so the next number is selected from the remaining numbers.
## Example
![Ekran görüntüsü 2022-08-03 164542](https://user-images.githubusercontent.com/109742155/182623751-14705cc0-7df2-478e-9f87-c3243fa5e034.png)
- When a player deletes 4 numbers, he/she gets the award $10. (“birinci çinko”)
- When a player deletes all numbers from his/her queue, he/she wins the game and gets $30.
- If both players delete their last numbers at the same time, the game is over without any winner (tie) and they share the money.
- The program must display all steps until the game is over.
- At the end of the game, the winner(s) should be displayed.
- The money that each player gets should also be printed.
- No input is received!
## Sample Output
![Ekran görüntüsü 2022-08-03 164718](https://user-images.githubusercontent.com/109742155/182624151-f6fed134-5a82-4031-8912-f2919b48fb9f.png)
