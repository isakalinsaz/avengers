## Building the Application
Under _application_ directory, Avengers Application can be built using following gradle tasks:
```
  gradlew clean build (windows os)
./gradlew clean build (X-based os)
```

## Checkstyle and Jacoco static code analysis

```
  gradlew clean jacocoTestReport jacocoTestCoverageVerification
  gradlew clean checkstyleMain checkstyleTest
```

## Running the Application
After building the application, gradle must produce the application jar file under target/libs

```
 java -jar target/libs/avengers-1.0-SNAPSHOT.jar
 
```

## How to play
Note: Application constains game sound, please be make sure your pc volume is on before running application.
First of all, You should create a player. Use cli instructions to create player using by options.
```
 Welcome to The Avengers Infinity War Game!
 
 1- HUMAN
 2- AWOKEN
 3- EXO
 Select your character race (1, 2 or 3) :1
 
 1- MALE
 2- FEMALE
 Select your character gender (1 or 2) :1
 
 Enter your character name :SUPERMAN

```

After creating player, you will be able to play game and will see summary of attribute of your player

```
 Avenger, SUPERMAN (HUMAN/MALE)
 
 healingPower=8, defeatAmount=0
 
 Attribute: health=100.0, strength=4, dexterity=3, intelligence=3, constitution=3, precision(%)=0.7

```

System will create warriors according to number of enemy constant value.

```
Character{  race=EXO, name='MARALYN', gender=FEMALE, attribute=Attribute: health=100.0, strength=5, dexterity=2, intelligence=1, constitution=1, precision(%)=0.9, location=Location: 26,14}
Character{  race=AWOKEN, name='TOLVIR', gender=MALE, attribute=Attribute: health=100.0, strength=5, dexterity=1, intelligence=2, constitution=3, precision(%)=0.5, location=Location: 16,8}
Character{  race=AWOKEN, name='TOLVIR', gender=MALE, attribute=Attribute: health=100.0, strength=5, dexterity=1, intelligence=2, constitution=3, precision(%)=0.5, location=Location: 16,12}

```

After players are created, player will walk on the explorable maps and if player want to fight with warrior, just use directions and go ahead warrior location.

```
Enter direction (w:north, a:west, s:south, d:east) or press 'q' for quite game : w

...

There is a Warrior, What would you like to do?
1- Fight
2- Run
Chose your option (1 or 2) : 1

```

Here is a sample fight between your player and warrior. 

```
SUPERMAN        VS      TAUREN
1 ->2 ->3 -> Fight!!!
You will start the first attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
You hit 12.0 point but You missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
TAUREN hit 12.0 point but TAUREN missed the Attack!!!
Enemy (TAUREN) is down!!!  Your Health remained 84.0
Location: 6,2 - Level: 1 -  Defeat: 1 - Health: 84.0

```

If you want to quit and continue game later, you can save the game.

```
Enter direction (w:north, a:west, s:south, d:east) or press 'q' for quite game : q

Would you like to save the game? Please press 'y' to save the game?
y

Avengers game engine has been stopped.

```

After restarting the application, you will see following options

```
Welcome to The Avengers Infinity War Game!
1- NEW GAME
2- LOAD GAME
Chose your option (1 or 2) :
2
```

Resumed application map
```
#  #  #  #  #  .  .  .  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  .  .  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  X  .  .  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  #  #  #  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  .  .  #  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  .  .  .  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  .  .  .  .  .  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  .  .  .  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  .  .  .  #  #  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  W  .  .  .  .  .  .  #  #  #  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  .  .  .  .  .  A  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  .  .  .  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  .  .  .  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  .  .  .  .  .  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  #  .  .  W  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  
#  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  # 
```
