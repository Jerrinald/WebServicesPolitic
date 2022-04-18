# WebServicesPolitic

Welcome to our web services project

Members and e-mails:   
Jerrinald Kanikainathan - k.jerrinald@gmail.com  
Yanis Zerguit - enjoy95.yz@gmail.com

We have 3 branch : the first for the readme, the second for the server(master), and another one for the client

In our project we provides the management of politic people. The client manages his own list of politicians and we retrieve for informations about them to the client.
So the client can add multiple politicians in his list and asks for informations about them.  
You can also view the lasts tweets about their political party.

We have a server package with 3 class : PoliticUser, PoliticInfo, TwitterManage  
We run the client program in the client package with PoliticUser_PoliticUserPort_Client.java class


You can find the wsdl in the master branch in : 'WebContent/wsdl/politicuser.wsdl'  
You can find the javadoc in the master branch in the 'doc' folder


Service description : 

The principal class that will communicate with the client is PoliticUser.  
Thanks to this class, the client can benefit from several fonctionnalities :

- With the method 'addPolitican' the client can add a politician in his list. The list is managed by a hashmap and this is initialized as a variable at the beginning
in the class. In this hashMap with have for an ID integer the key(like a primary key), and for the values we have the name of the politians that the client have added.
It returns to the client a string value that indicates that the client is added.

- With the method 'getPoliticDescription' we return to the informations about a politician that is asked by a client.  
All the informations about the politicians are stored in a hashMap that is managed in the PoliticInfo class. So in the 'getPoliticDescription' method we create 
an instance of this class(PoliticInfo) and call the method that display a description about a politician entered in parameter(displayPolitic method). In this hashMap managed in the PoliticInfo class, we have in the key the name of the politicians, and as value a instance of this class that represent the age, the political party and the political party's twitter name of the politicians(We have two constructor in the PoliticInfo, one to represent all the informations about the politicians, so the 
age,  the political party and the political party's twitter name, and another constructor to be called in PoliticUser Class, like in this 'getPoliticDescription' method.  
This 'getPoliticDescription' return null to the client if the politician entered in parameter not exist. Obviously, if a client wants to add a politican that is
not in the the hashMap managed in the PoliticInfo class, the method will return null, because all the politicians that the client can add have to be in this hashMap.
The method returns a string of all the informations about this politician.

- The method 'displayPoliticList' return the list of the politicians added by the client with their names with a string value.

- The method 'politicInList' check if the a politician is in the client's list. if the client wants to see again informations about a politician who is in his list,
he can enter the name of that politician. If the politician entered by the client is not in his list, the method will return false to the client.

- With the method 'getTweetPolitic', we return to the client all the recents about a political party. After return all the informations about a politician, we
return to him the recents tweets of his political party. We get these recents tweets thanks to the API V2 of Twitter. We get these API requests with the 
TwitterManage class that retrieves 2 API request in 2 methods.  
We have to get firstly the ID of the political party Twitter account with an API request. And with this ID, we can the recents tweets of the political party with
a second API request. We return back to client the Tweets's date and text in a double String Array.

- When the client have finish with the program, he calls the method 'clearList' that clean his politician List and return 0 to terminate the program.


Client description : 

Firstly the client have to add a politician. If the politician is not in the hashMap managed in the server(in the PoliticInfo class), the client have to enter a 
politician name.

Then the client can have informations about this politician. It concerns his age, his political party. Next we display to him the political party's recensts tweets
with the date and the text tweets.

Then the client can see his list of politician. 

Then the client can see again informations about a politician of his list. He have to enter his name. If the politician entered is not in his list, he have to
enter again the name of a politician of his list.  
This will repeat while the client wants to see informations about politician of his list.

Then the client can add a new politican in his list.

So this programm will run while the client wants to add a new politician in his list.


Scenario complete of the client test(We run the client program in the terminal) :  
(when we have the client's response, we have a dash at the beginning '-')

Add a new politician
- Marine Le Pen  
Marine Le Pen is added !  
Do you want information about this politician ? (y/n) 
- y  
| Age : 53 | Political party : Rassemblement national |

The lasts Tweets for the political party : 

Tweet date : 2022-04-18 17:00:02.000   
Tweet text :   Dimanche 24 avril, si le peuple vote, le peuple gagne ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpj4EK https://t.co/P5D3dn7745

Tweet date : 2022-04-18 16:00:00.000   
Tweet text :   Échec, compromission, incompétence, élitisme... Qui est vraiment extrême ? #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/LnuNgsCMHV

Tweet date : 2022-04-18 15:15:00.000   
Tweet text :   Dimanche 24 avril, votez pour augmenter votre pouvoir d'achat ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoq5hn https://t.co/gRWZyTYeZM

Tweet date : 2022-04-18 15:00:02.000   
Tweet text :   Au premier tour, 73% des Français ont voté pour un changement. Dimanche, si vous ne voulez pas de la retraite à 65 ans, de la casse sociale et du mépris pendant cinq années supplémentaires, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/nfYqxc2DsL

Tweet date : 2022-04-18 14:30:00.000   
Tweet text :   Dimanche 24 avril, pour rendre aux Français leur pays et leur argent, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoHGFX https://t.co/RbUdzXdCGr

Tweet date : 2022-04-18 14:15:00.000   
Tweet text :   Vendredi 16 avril, Marine Le Pen s'est rendue sur le marché de Pertuis dans le Vaucluse pour continuer à convaincre une majorité de Français. #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpj4EK https://t.co/UXHen07rwc

Tweet date : 2022-04-18 13:47:29.000   
Tweet text :   Marine était ce matin en #Normandie auprès de cette France rurale que nous aimons tant ! Notre projet de redressement et d'espoir s'adresse à ces Français des terroirs, trop longtemps oubliés.
?? Le 24 avril, pas d'abstention ?? #MarinePrésidente ! https://t.co/tETAHVVbGz

Tweet date : 2022-04-18 13:30:00.000   
Tweet text :   Dimanche 24 avril, pour dire NON à la retraite à 65 ans, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoHGFX https://t.co/oBPQtkFmEp

Tweet date : 2022-04-18 13:00:02.000 
Tweet text :   Samedi 16 avril, Mourad Boudjellal a insulté les électeurs de Marine Le Pen lors d'un meeting d'Emmanuel Macron à Marseille. Sortons ces personnes qui méprisent et détestent les Français par les urnes ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/A3VIrQVfLZ


Your List of politicians :  
Marine Le Pen | 

Do you want informations again about one politician of your list ? (y/n)  
- n

Do you want to add a new Politician ? (y/n)
- y  
Add a new politician
- y  
This politician is not identified ! Enter again a new politician   
- Emmanuel Macron    
Emmanuel Macron is added !  
Do you want information about this politician ? (y/n) 
- y  
| Age : 42 | Political party : La Republique En Marche |

The lasts Tweets for the political party : 

Tweet date : 2022-04-18 18:16:02.000   
Tweet text : Ce que je veux dire aux personnes qui hésitent à aller voter : 
#CàVous https://t.co/d86wkDFPiS

Tweet date : 2022-04-18 18:01:40.000   
Tweet text : C'est #avecvous que je veux construire la France de demain. #CàVous https://t.co/RStQcrSqbp

Tweet date : 2022-04-18 16:56:11.000   
Tweet text : Pour que les vies de Lova, Sarah, Lona et de tous les Français puissent continuer à s'améliorer dans les 5 ans à venir, dimanche 24 avril, tous ensemble, votons Emmanuel Macron ! https://t.co/pzzqcEfHSO

Tweet date : 2022-04-18 13:37:17.000   
Tweet text : « Cela est bien plus rapide et pertinent que de baisser de manière permanente la TVA sur les carburants, ce qui est tout à la fois moins efficace et complètement contraire à nos intérêts économiques et climatiques. » @EmmanuelMacron @LePoint https://t.co/hIBmIQHxlK

Tweet date : 2022-04-17 12:05:36.000   
Tweet text : « Nous avons fait beaucoup pour l’environnement depuis 5 ans et nous voulons faire plus. » @GabrielAttal #QuestionPol https://t.co/VyIYE9sdj4

Tweet date : 2022-04-16 16:41:13.000   
Tweet text : En changeant de paradigme pour l'écologie, nous pourrons ensemble être celles et ceux qui savaient et qui ont fait ! C'est le rôle de notre génération. #MacronMarseille https://t.co/tEjyQxEOYx

Tweet date : 2022-04-16 16:02:03.000   
Tweet text : Pour susciter cette mobilisation générale de la Nation pour l'environnement, nous organiserons chaque année une grande fête de la nature. #MacronMarseille https://t.co/qzIv1sLVRE


Your List of politicians :   
Marine Le Pen | Emmanuel Macron | 

Do you want informations again about one politician of your list ? (y/n)
- y  
Which one ?
- jdhdh

 This politician is not in your List ! Enter a politician of your list
- Marine Le Pen  
| Age : 53 | Political party : Rassemblement national |

Tweet date : 2022-04-18 17:00:02.000   
Tweet text :   Dimanche 24 avril, si le peuple vote, le peuple gagne ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpj4EK https://t.co/P5D3dn7745

Tweet date : 2022-04-18 16:00:00.000   
Tweet text :   Échec, compromission, incompétence, élitisme... Qui est vraiment extrême ? #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/LnuNgsCMHV

Tweet date : 2022-04-18 15:15:00.000   
Tweet text :   Dimanche 24 avril, votez pour augmenter votre pouvoir d'achat ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoq5hn https://t.co/gRWZyTYeZM

Tweet date : 2022-04-18 15:00:02.000   
Tweet text :   Au premier tour, 73% des Français ont voté pour un changement. Dimanche, si vous ne voulez pas de la retraite à 65 ans, de la casse sociale et du mépris pendant cinq années supplémentaires, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/nfYqxc2DsL

Tweet date : 2022-04-18 14:30:00.000   
Tweet text :   Dimanche 24 avril, pour rendre aux Français leur pays et leur argent, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoHGFX https://t.co/RbUdzXdCGr

Tweet date : 2022-04-18 14:15:00.000   
Tweet text :   Vendredi 16 avril, Marine Le Pen s'est rendue sur le marché de Pertuis dans le Vaucluse pour continuer à convaincre une majorité de Français. #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpj4EK https://t.co/UXHen07rwc

Tweet date : 2022-04-18 13:47:29.000   
Tweet text :   Marine était ce matin en #Normandie auprès de cette France rurale que nous aimons tant ! Notre projet de redressement et d'espoir s'adresse à ces Français des terroirs, trop longtemps oubliés.
?? Le 24 avril, pas d'abstention ?? #MarinePrésidente ! https://t.co/tETAHVVbGz

Tweet date : 2022-04-18 13:30:00.000   
Tweet text :   Dimanche 24 avril, pour dire NON à la retraite à 65 ans, allez voter ! #MarinePrésidente #DimancheJeVoteMarine
Indisponible le 24 avril ? Donnez une procuration ! 
?? https://t.co/ALQ6yoHGFX https://t.co/oBPQtkFmEp

Tweet date : 2022-04-18 13:00:02.000   
Tweet text :   Samedi 16 avril, Mourad Boudjellal a insulté les électeurs de Marine Le Pen lors d'un meeting d'Emmanuel Macron à Marseille. Sortons ces personnes qui méprisent et détestent les Français par les urnes ! #MarinePrésidente #DimancheJeVoteMarine
?? https://t.co/CJKKUpAFwi https://t.co/A3VIrQVfLZ


Do you want informations again about one politician of your list ? (y/n)
- n

Do you want to add a new Politician ? (y/n)
- n  
End of the program



