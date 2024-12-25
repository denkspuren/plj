# Kodierung, Repräsentation und Notation

## Was ist was?

In der Informatik und insbesondere in der Programmierung macht man sprachlich einen Unterschied zwischen

* der _Kodierung_; also wie man einen Sachverhalt *intern* und rechnerisch geeignet abbildet,
* der _Repräsentation_ (auch _Darstellung_); also wie man einen Sachverhalt *extern* und meist zugänglich für Menschen textuell oder visuell aufbereitet.
* der _Notation_ (auch _Schreibweise_); also wie man einen Sachverhalt (in der Regel) textuell beschreibt, um ihn maschinell zu rekonstruieren

Unter dem Begriff des Sachverhalts sei alles gefasst, was als Daten, Datenstruktur oder Datenverlauf in einem Computerprogramm abgebildet sein kann. Der Begriff des Datums ist hier sehr umfassend gemeint, er schließt auch Programme, eine Programmstruktur oder einen Programmauflauf mit ein.

##### Beispiel: Primitive Typen

Sie kennen diese Unterscheidung bereits für primitive Typen. Zahlen vom Typ `int` und `long` werden _intern_ im Zweierkomplement _kodiert_. _Dargestellt_ werden sie jedoch _nach außen_ als Zahlen im Zehnerformat mit einem Vorzeichen bei negativen Zahlen. _Notiert_ werden Ganzzahlen als Zahlen-Literale in einer der folgenden Schreibweisen: im Zehnerformat (dezimal), im Sechzehnerformat (hexadezimal), im Achterformat (oktal) oder im Zweierformat (binär). In Java ist die Schreibweise vorzeichenlos, das Minuszeichen ist ein unärer Operator und nicht Teil des Literals (der Zahlenschreibweise).

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

> Zum Hintergrund: Im Zweierkomplement wird ein Vorzeichenwechsel dadurch realisiert, dass die Bits invertiert werden (eine 1 wird zur 0, eine 0 zur 1) und anschließend ein 1 addiert wird. Das scheint umständlich. Der Vorteil ist jedoch, dass man im Zweierkomplement mit einer gewöhnlichen Binäraddition negative und positive Zahlen addieren kann und es auch keiner expliziten Operation der Subtraktion bedarf.

Es wäre nicht besonders geschickt, sich von der Darstellung leiten zu lassen und Zahlen intern als Ziffernfolgen von 0 bis 9, also als `char`s zu kodieren. Darunter würde die Recheneffizienz erheblich leiden.
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

Sie kennen sicher das Spiel Tic-Tac-Toe. Das Spiel besteht aus einem 3×3 Spielfeld und wird von zwei Parteien gespielt. Die eine Partei hat die mit `X`, die andere die mit `O` bezeichnete Spielsteine. Die beiden Spielparteien setzen abwechselnd ihre Spielsteine auf das Spielfeld, `X` beginnt. Das Spiel endet mit dem Sieg für die Spielpartei, die zuerst drei eigene Spielsteine "in Reihe" (waagerecht, senkrecht, diagonal) bringt. Kann keine Spielpartei gewinnen und ist das Spielbrett vollständig besetzt, so endet die Partie unentschieden.

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


