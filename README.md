

## General overview
This is a Gwent: The Witcher card game clone. <br>
Backend is built with Spring boot with Java and frontend is made using React with Typescript. <br>
To store important data on frontend such as username, i used react redux. <br>
For multiplayer messaging i used Spring web sockets and SockJS. <br>
To store users decks i used PostgreSQL and JPA/Hibernate. <br>
Frontend is hosted via Vercel <br>
Backend is hosted via AWS. Server is running on EC2 instance and database is running on AWS RDS <br>
Also frontend is secured by vercel automatically, but for backend i had to get SSL cerfificate to get HTTPS <br>

## Rules
Game consists of 3 rounds, player who wins 2 rounds wins game. When both players end round, one with more points on board wins round. <br>
For every won round a crown appears in the middle of board. <br>
In each move, a player can either play card or end round.<br>
(card that base power is 0 or below is destroyed from game) <br>
## Cards
Currently, there are about 30 cards. Most of them dont have any effects.<br>

Here are cards with effect. 
(Some of these cards might not be available in production yet)

Spells: <br>
Fireball - Deals damage to an enemy card.<br>
Conflagration - Burns all cards with maximum points. <br>
Epidemic - Destroy all min points cards on board <br>
Rip - deals damage to whole row <br>
Rain - deals damage to max points card every turn <br>
Mushrooms - Decrease base power of enemy card<br>
Tasty mushrooms - Increase base power of enemy card<br>
Handcuffs - Lock enemy card and deal damage <br>
Key - Unlock and boost your card <br>

Units: <br>
Archer - A unit that can be placed and deals damage to an enemy card. <br>
Healer - Boosts every card on the player's board that has no more than 2 points. <br>
Booster - Boosts a single player card. <br>
Leader - Boosts every card in one row. <br>
Doubler - Doubles chosen card points. <br>
Sharpshooter - deals damage to one enemy card and if this card dies, sharpshooter boost itself <br>
Cow - If cow dies, spawn chort in the same row <br>
Trebuchet - Deal i damage to random enemy every 2 turns<br>
Good person - Boost card on your board every 2 turns<br>
Gravedigger - Boost by number of cards on your graveyard on deploy<br>
Witch - Ressurect card from your graveyard<br>
Wild roam - Play all copies of this card from you deck on the same row<br>
Supplier - Play from deck copy of chosen card from board <br>
Breaker - After 2 turns, play copy of this cards from deck on the same row <br>
Ginger - Deal 1 damage to every card on specified enemy row <br>
Spy - After playing this card it moves to enemy row, and player draws 1 card <br>
Blue fire - If opposite row has at least 10 points, burn all max points cards on this row <br>
Axer - Deal damage to enemy card by number of weakened cards on enemy board <br>
Copier - Choose card on your board and insert 2 base copier of this card into your deck <br>
Trex - Eat card on your board and boost this card by eaten cards power <br>

## New features
Points of weakened cards have red color and and boosted cards have green points. <br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/3f0d6ccf-ec18-4e0c-8370-495f4dfe2441)

There are bronze, silver and gold cards. Gold cards can only be targetter by other gold cards, for example <br>
archer cant shoot Priest <br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/3e948464-8128-4e59-a98c-e32fe139894a)

I added two fractions: Monsters, Humans. You can build deck with only one fraction and only neutral cards
are available with every fraction (not in production yet)<br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/82891e53-d20c-48e6-95a0-aa027e553bde)
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/094b976c-6ba7-4129-a99f-e3c04618fe8c)
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/0cc04074-9f49-4e9d-ac9c-66c4517ce172)




## Deck builder demo
![ezgif com-video-to-gif (1)](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/3e7e2a43-75cf-45ae-998e-ce93c6bd9a9c)


There is deck builder where you can add and remove cards from deck, add and remove decks. 
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/2b47af2e-84f5-41cb-82a5-351d2bb7c9e2)

You can also search for specific cards and sort by different criteria. Here i search for cards that have oo in name and sort them by points.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/a5d2eda3-b992-46bd-9550-afad9b383ed2)



## Duel demo
This is duel page where battle is taking place. <br>
There will be quick demo of how whole game runs. <br>
<br>
At the start, players can change 3 cards from hand with card from deck.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/0a65085f-22c5-4782-98d1-9054024c2a23)
Then the battle begins. You can see cards in your deck as well as cards on your graveyard. There is also icon 
That tells you whether its your turn or not.
You can hover on a card to show its info.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/c08a3710-eaba-44dc-b98c-eee0b533a68a)

![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/1d90f158-24c6-4d6b-8b1e-a1e61426f4f5)
As we can see its my turn, so i choose to play knight, that doesnt have any effect. I can play card by dragging card from hand and dropping
on any row.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/01d436e8-7a1b-4d49-897b-3db94d7d88ed)
Here after playing knight, enemy played Trebuchet on his turn. This card deals damage to enemy card every 2 turns. The hourglass icon
shows how many turn are there to activate this effect. This icon appear on every card with timing effects.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/60e62583-4686-420c-8cd6-9ac6a0be3939)
Now i will play supplier, that allows me to play from deck copy of chosen card from board.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/cd486fd2-e8db-462f-970f-6a08b724be58)
I will choose knight.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/b647a59e-6360-4cff-9ddc-0ab90761c0ff)
I had 1 copy of knight in my deck, so now i can play this card. 
After i placed knight enemy played rain, this is row status that deals damage to one max player card on row every turn. 
Status is applied on enemy and player rows. As you can see trebuchet dealt damage and in 2 turns it will deal damage again.

![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/7e2c4813-6789-47d1-8d8a-f0994622c365)
Now i will play priest, that allows me to play one card from my deck.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/59b94e04-ef71-4f4f-ade1-081afb40ab16)
I will choose conflagranation. This is special card that burns all cards with max points, here it will burn knight and trebuchet.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/ec2fce2f-c331-4202-a2ef-d16fd8923e07)
Now enemy ended round. I have more points on board so i will end round too.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/e2b0bc61-41f1-48dc-911d-9f9012a2c00e)
<br>When new round start, in the middle of screen this appears:<br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/d8634f5b-7e2f-4af6-80b9-b864f7702be3)
<br>I won round so crown appeared in the middle. Also row status is cleared on new round
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/17448b7e-de27-4090-adeb-18e26657d421)
I choose to end round. After i ended round enemy can play as many card as enemy wants. Enemy choosen to play cow to have more points than me.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/41957724-ef02-43a0-86a9-9df73ff403e9)
Enemy ended round, so new round started and every played drawn a card. <br>
When new round starts board is cleared, so cow died and spawned chort.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/ed907b04-4ffe-4302-a0be-bdf1fd597bfb)
Enemy choosed to play priest, that allowed to play Doubler. Doubler can double points of one card on board, so enemy choosed to double Chort.
I choose to play wild roam, that plays all copies of this card from deck.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/108aec71-c8c6-48de-a0ab-0471f07ed498)
Enemy played Sharpshooter and deal 2 damage to my one card.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/9f5e1722-916c-4d9f-9b7b-57e8eeb6d640)
I choose to play fireball and deal damage to chort.
As you can see i can choose card to target and also show card info. When i hover on a card that i want to target,
its copy on board lights with green, so i can see that this is this card(This is useful when two cards are the same, for example two wild roams).
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/7bbc652a-cf38-46d9-a790-f280ee5c05c0)
I choosed to target Chort and damage was dealt
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/f59ca257-1907-48c4-8416-a96ce2cecab1)
Enemy has one card but ended round, and now i can only play warrior.
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/678a951e-1bbd-4e88-ad25-260a67963f29)
Now i can only end round. I have less points so i will lose round and enemy will score a crown and win game. 























<br>


Player lost 2 rounds and lost game <br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/e8740511-dc1e-40e6-8174-b07ec354009d)



Player won 2 rounds and won game <br>
![image](https://github.com/PiotrJagla/GwentClone-MainProj/assets/76881722/16fdb528-e908-457e-8943-2fbe81a2e3e9)



<br>If both players had same amount of points, they both score a crown. Here two players had same amount of points and game ended with draw<br>
![image](https://github.com/PiotrJagla/MyCardGame-MainProj/assets/76881722/3ceeddc5-9664-4f9c-a8ca-89237f3a8e98)













