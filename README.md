==RockPaperScissors==

==Description== 
  This is a very simple rock paper scissors game. As the user, you can pick between the three moves and play against a random move selected by the 
program. To the left, the user can see a scoreboard that will show the number of games played as well as the result of the game. There are also 
the appropriate buttons to start the match and quit the program. 

==Technologies used==
Program used: IntelliJ IDEA
SDK: 11 Oracle OpenJDK version 11.0.12
Language: Java

==Possible improvments==
  While building the program, as it was my first major project, I found it difficult to visualize the classes, and how they would work with one another. 
Hopefully with more experience, I'll be able to make a more efficient program. Another challenge I faced was trying to figure out a way to display the 
game log. In the end, I just created a new label for every new game which in itself could be improved on. Overall, the program runs but I can see multiple
things I could work on in the future. For instance, the fact that the user's choice and the computer's move both don't reset after the match is a bit unappealing.

==Visuals== 

https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/BaseProgramDemo.png
 - *When the game is first loaded (no interactions)*

https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/StartButtonErrorMessageDemo.png
 - *when the start button is pressed without picking a move*

https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/ProperUseDemo.png
 - *after a few matches*

==Class structure==
  The main class of the program (Evaluation) is designed to take the user's value and the value of the randomly generated move of the computer, compare the moves 
and return the results. I decided to separate the generation of the computer move for simplicity's sake and connected the two via an aggregation relationship. 
Separate from those two classes is the button interface. Because we’re dealing with multiple buttons with the same function, making the interface (ButtonInterface) 
just helps clean up the code and make it more efficient. These buttons are meant to return a value corresponding with the move they represent, which we will 
later use in the playGame method (found in the evaluation class). 

==UML diagram==
https://raw.githubusercontent.com/KarinaSofia/RockPaperScissors/master/RockPaperScissorsUMLDiagram.png



