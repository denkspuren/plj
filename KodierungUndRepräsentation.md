# Kodierung und Repräsentation

## Definition

Man muss beim Begriff der Kodierung acht geben, da insbesondere die Nachrichtentechnik den Begriff geprägt hat, der u.a. durch die Kodierungstheorie fundiert ist. Bei der Programmierung geht es aber nicht um Kanal-, Quellen- oder Leitungskodierung, sondern neben der [Zeichenkodierung](https://de.wikipedia.org/wiki/Zeichenkodierung) und neben [Daten-](https://de.wikipedia.org/wiki/Datenformat) und [Dateiformaten](https://de.wikipedia.org/wiki/Dateiformat) im Wesentlichen um die Abbildung von Sachverhalten in Daten, Datenstrukturen und Datenverarbeitungsverfahren. Darauf zielen die folgenden Definitionen ab: 

Repräsentation
: Eine Repräsentation stellt eine Konfiguration (Zusammenstellung) von  [Entitäten](https://de.wikipedia.org/wiki/Entit%C3%A4t) samt ihrer Beziehungen textuell, graphisch, bildlich oder in einer anderen medialen Form dar. Diese Darstellungen bilden ideelle (abstrakte), realweltliche (konkrete) oder rechnerisch-computationale (virtuelle) Konstruktionen ab. Die Darstellung kann die Absicht verfolgen, etwas Grundlegendes, Entscheidendes oder Bedeutsames durch die Art und Weise der Darstellung hervorzuheben oder ins Blickfeld zu stellen.

Kodierung
: Eine Kodierung beschreibt die Abbildung einer Repräsentation in eine andere Repräsentation. In der Programmierung geht es wesentlich darum, Kodierungen für Datenrepräsentationen und Berechnungen zu finden bzw. zu verwenden, die computational vorteilhaft und/oder programmiersprachlich oder paradigmatisch geeignet und angemessen sind. Eine wichtige Rolle spielt zudem, diese Kodierungen kommunikabel (mitteilbar) und verständlich zu machen. 

<!--
[Zeichenkodierungen](https://de.wikipedia.org/wiki/Zeichenkodierung) wie [ASCII](https://de.wikipedia.org/wiki/American_Standard_Code_for_Information_Interchange) oder [UTF-8](https://de.wikipedia.org/wiki/UTF-8) und [Daten-](https://de.wikipedia.org/wiki/Datenformat) und [Dateiformate](https://de.wikipedia.org/wiki/Dateiformat) wie [JPEG](https://de.wikipedia.org/wiki/JPEG) für Bilddaten, [MP3](https://de.wikipedia.org/wiki/MP3) für Hördaten oder [JSON](https://de.wikipedia.org/wiki/JavaScript_Object_Notation) für den Datenaustausch sind Beispiele für technische Standards, die Kodierungen von Zeichen, Medien und Daten definieren. Dass z.B. bei JPEG und MP3 verlustbehaftete Datenkompressionen eine Rolle spielen, interessiert Programmiererinnen und Programmierer nur begrenzt.
-->

##### Beispiel: Primitive Typen

Sie kennen diese verschiedenen Repräsentationen bereits für primitive Typen. Zahlen vom Typ `byte`, `short`, `int` und `long` werden _intern_ im Zweierkomplement _kodiert_. Das Zweierkomplement bildet eine vorzeichenbehaftete Zahl in eine Binärzahl fester Stellenanzahl (8 Bits bei `byte`, 16 bei `short`, 32 bei `int` und 64 bei `long`) ab. Die Kodierung ist so beschaffen, dass man im Zweierkomplement mit einer gewöhnlichen Binäraddition negative und positive Zahlen addieren kann und es keiner expliziten Operation der Subtraktion bedarf. _Repräsentiert_ werden Ganzzahlen jedoch im Zehnerformat mit einem Vorzeichen bei negativen Zahlen.

Bei Gleitkommazahlen wie `float` und `double` ist die Kodierung und der Bezug zwischen der binären und dezimalen Zahlenrepräsentation komplizierter. Der technische Standard [IEEE 754](https://de.wikipedia.org/wiki/IEEE_754) definiert die Darstellung von Binär- und Dezimalzahlen für Gleitkommazahlen und für die Durchführungen von Berechnungen.

<!--
```java
jshell> 345 // Außendarstellung
$59 ==> 345

jshell> String.format("%32s", Integer.toBinaryString(345)).replace(' ', '0') // Kodierung
$60 ==> "00000000000000000000000101011001"

jshell> -345
$61 ==> -345

jshell> String.format("%32s", Integer.toBinaryString(-345)).replace(' ', '0')
$62 ==> "11111111111111111111111010100111"
```

Es wäre nicht besonders geschickt, sich von der Darstellung leiten zu lassen und Zahlen intern als Ziffernfolgen von 0 bis 9, also als `char`s zu kodieren. Darunter würde die Recheneffizienz erheblich leiden.
-->

#### Alles ist Kodierung, alles Repräsentation

Bei den Begriffen der Kodierung und der Repräsentation muss man sorgfältig trennen, was man da genau bezeichnet: Schaut man sich die eine Seite einer Medaille nur mit verschieden "Brillen" an, oder betrachtet man die zwei Seiten einer Medaille?

*Verschiedene Brillen einer Seite*: Ein Rechner kodiert letztlich alles als Einsen und Nullen. Diese Kodierung kann man somit im Binärformat betrachten. Das Hexadezimalsystem und das Oktalsystem sind zwei weitere verbreitete Notationen bzw. Repräsentationen für Binärkodierungen. Das liegt daran, dass das Oktalsystem mit einer Oktalziffer exakt drei Binärstellen erfassst, das Hexadezimalsystem hingegen exakt vier Binärstellen. Mit diesen Zahlensystemen kann man sehr kompakt Binärziffern darstellen bzw. notieren.

Das, was man unter eine Kodierung versteht, ist die Zuordnung einer Interpretation 


<!-- 
https://en.wikipedia.org/wiki/Multiple_representations_(mathematics_education)



-->



das Hexadezimalsystem in einer Ziffer 4 Binärziffern repräsentiert und das Oktalsystem  

Wenn man sich eine Kodierung anschaulich macht, muss man eine Darstellungsform wählen. Es gibt keine Kodierung, die ohne Zeichen auskommt.

<!--
Speicherkodierung, repräsentiert im Binarformat


-->


Bei Objekten entspricht die Repräsentation in einfachen Fällen der `toString`-Methode. Und die Kodierung entspricht der getroffenen Wahl und Zusammenstellung von Instanzvariablen mit ihren Typen. Dazu kommen Methoden, die zwischen Kodierung und Darstellung vermitteln. 


#### Die Begriffe sind relativ

Was dem einen eine Repräsentation ist, ist dem anderen eine Kodierung -- und umgekehrt. Es hängt von der Perspektive ab, ob man eine Kodierung als Repräsentation oder ob man eine Repräsentation als Kodierung deutet.

Daraus ergibt sich möglicherweise eine Kette von Kodierungen, die in einer Repräsentation münden. Oder es ergibt sich eine Folge von Repräsentation, die auf einer Kodierung basieren. Letztlich wird im Rechner alles über Einsen und Nullen kodiert. Man muss nur wissen, was die Einsen und Nullen bedeuten. Aber auch das ließe sich hinterfragen, wenn man versuchte zu verstehen, wie Einsen und Nullen in der Hardware, in einem Schaltkreis, abgebildet sind: Kodieren da nicht letztlich Spannungswerte eine Null bzw. Eins? Und was genau ist eine Spannung?

<!--
Ein Beispiel: Ein Spielfeld im Schach (8x8 Felder) wird kodiert durch die Angabe der Koordinaten aus einem Kleinbuchstaben (Spalte) und Zahl (Reihe) dargestellt (repräsentiert), etwa "e2". Der Buchstabe werde intern durch ein `char`, die Ziffern durch einen `int` repräsentiert bzw. kodiert. Intern wird ein Einzelzeichen als Zahl gemäß der UTF8-Kodierung (ein Kodierungsformat für internationale Zeichensätze) und eine Zahl binär im Zweierkomplement kodiert.
-->

Bevor wir uns in einer Welt außerhalb der Software verlieren:
Eine Repräsentation dient in der Informatik oft als Ersatz für z.B. ein Arrangement in der realen Welt. Die Darstellung einer Schachposition auf dem Bildschirm ist nicht gleichzusetzen mit einer Spielsituation auf einem realen Spielfeld. Die Darstellung soll an das reale Spielfeld erinnern und es gleichzeitig als realen Gegenstand überflüssig machen. 

## Fallbeispiel: Tic-Tac-Toe

Sie kennen sicher das Spiel Tic-Tac-Toe. Das Spiel besteht aus einem 3×3 Spielfeld und wird von zwei Parteien gespielt. Die eine Partei hat die mit `X`, die andere die mit `O` bezeichneten Spielsteine. Die beiden Spielparteien setzen abwechselnd ihre Spielsteine auf ein freies Feld, `X` beginnt. Das Spiel endet mit dem Sieg für die Spielpartei, die zuerst drei ihrer Spielsteine "in Reihe" (waagerecht, senkrecht, diagonal) bringt. Kann keine Spielpartei gewinnen und ist das Spielbrett vollständig besetzt, so endet die Partie unentschieden.

Wir betrachten die folgende Situation im Spiel:

```
 X | O |    
---+---+--- 
   | X |
---+---+--- 
 X |   | O
```

Wenn man danach fragt, mit welcher Datenstruktur das Spielfeld abgebildet (kodiert) werden könnte, geben die meisten Programmierer*innen folgende Antwort:

* Das Spielfeld ist zweidimensional. Also kodiere ich das Spielfeld durch ein zweidimensionales Array.
* Die Spielsteine `X` und `O` (und ein Leerzeichen für ein leeres Feld) können durch ein `char` erfasst werden.
* Folglich wähle ich für das Spielfeld ein zweidimensionales `char`-Array: `char[][] board = new char[3][3];`

Vielleicht erahnen Sie es: Mit dieser Entscheidung wird die Darstellung als maßgeblich für die interne Kodierung des Spiels gewählt.

* Damit ist die interne Kodierung abhängig davon, wie die Spielsteine symbolisch als Zeichen dargestellt werden. Was, wenn jemand lieber mit `#` und `*` spielt? Katastrophal wäre, wenn man deshalb den Programmiercode anpassen müsste.
* Mit Einzelzeichen kann man nicht wirklich gut rechnen, auch wenn sie in Java zu den Zahlentypen gehören.
* Die Zweidimensionalität erfordert, die Felder auf dem Spiel über zwei Indizes zu adressieren. Rechnerisch ist das überflüssig. Wenn ein Programm Spielzüge durchrechnet, wie z.B. beim Schach- oder Damespiel, dann macht sich die Ineffizienz einer zweidimensionalen Adressierung deutlich bemerkbar.

### Eine Kodierung für Tic-Tac-Toe

char[][] board = new char[3][3]

                       
    ABC, what's this   
+---------------------+
|                     |
|                     |
|                     |
|                     |
|                     |
+---------------------+


XXXXXXXX



Schreiben Sie eine Methode `threeInARow`, die ein eindimensionales Array aus neun Felder übergeben bekommt (siehe nachstehendes Bild) und ermittelt, ob in der Stellung drei Spielsteine in Reihe sind und wer gewonnen hat. Die Felder sind mit den Zahlenwerten -1 (für "`O`"), 0 (leeres Feld) und +1 (für "`X`") kodiert.

***************
*  0 | 1 | 2
* ---+---+---
*  3 | 4 | 5
* ---+---+---
*  6 | 7 | 8
***************


