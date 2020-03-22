# Simple Calc
## Description
--------
Simple calculator that have some basic function and made with 
Java and Kotlin as Language, JavaFX and  TornadoFX as GUI Framework, and also Gradle App Builder.

## Feature
----
1. Basic Operation (+, - , x, /)
2. Sqrt and power operation (sqrt, ^)
3. Logarithm function (log)
4. Trigonometric function (sin, cos, tan)
5. Memory functionality (MR, MC, Ans)
6. Deleting functionality (<-, CE, AC)

## Prequisites
---------
To run this project, you must have at least:
1. [JDK](https://www.oracle.com/java/technologies/javase-downloads.html), here I use JDK 14, but it should be safe as long you use JDK version newer than 11.
2. [Kotlin](https://kotlinlang.org), I used version 1.3.70
3. [IntelliJ IDEA 2019](https://www.jetbrains.com/idea/?gclid=Cj0KCQjwmdzzBRC7ARIsANdqRRlc5RSa7NIzgSmMytqGQUJAkUYnoe1xcd-v8rwb7sEq9YknABX4Pl8aAgaOEALw_wcB) as IDE, I've used another IDE as VSC, but it fail.
4. [Gradle](https://gradle.org/), use version 6.2.2, as I use this version. 

## How to Prepare the App
--------
1. Run IntelliJ IDEA, then open the project
2. Wait for a while, it should installing some dependencies, as JavaFX and TornadoFX, it might be installing gradle, too.
3. After finish installing dependencies, on IntelliJ embedded terminal, try execute

        gradle clean build
       
    after finish building, then execute
    
        gradle run
        
    to run the program
4. Wait, and the calculator screen should've appeared

## How to use the App
------
This calculator is so simple
1. Press the button to make equation you want to solve 
2. Press _=_ to calculate
3. To use memory feature you can press _MC_ button to save the value, and _MR_ button to use it. Remember this is using _Queue_ DS.
4. If you make mistake, you always can press _<-_ button to delete the last char you typed, or press _AC_ one to return teh calculator to it's initial state as it's first condition

## Notes
---------
### Feature
1. This is actually support input by keyboard, but still beta-testing, so not recommended as some key might leading to crash
2. This only support a operation at once, one unary operator or one binary operator

### Bugs
1.
2.

## Credits
-----
1. Naufal Prima Yoriko - Github : [primayoriko](https://github.com/primayoriko)
2. Lionarta Savirandy - Github : [Lionnarta](https://github.com/Lionnarta)
3. Michelle Theresia - Github : [michellethr](https://github.com/michellethr)
