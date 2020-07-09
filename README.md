Cerinte functionale
Magazinele pun la dispozitia clientilor o gama variata de produse care pot fi achizitionate la pret intreg sau pot face parte din diverse promotii. O promotie are o perioada de aplicabilitatate si contine unul sau mai multe produse. Acelasi produs se gaseste in cel putin un magazin. Fiecare client doreste sa achizitioneze produsele la un pret cat mai mic. In acest scop, este necesara implementarea unei solutii care va furniza, pentru toti clientii, pretul si magazinul de achizitie al fiecarui produs, suma totala a cumparaturilor si, daca este cazul, produsele ce nu au putut fi achizitionate.

Observatii:

unele magazine sunt inchise in zilele de duminica
acelasi produs poate face parte din mai multe promotii
un client va specifica magazinele din care doreste sa faca cumparaturile, atribuindu-i fiecarui magazin o prioritate, indicand astfel ordinea alegerii magazinelor pentru achizitionarea produselor
in alegerea fiecarui produs se va tine cont de preferinta pentru magazine, de disponibilitatea acestora si de aplicabilitatea promotiilor
pentru acelasi magazin, se considera ca un produs va avea pretul cu atat mai mic, cu cat face parte dintr-o promotie cu o perioada mai mica de aplicabilitate
cautarea in urmatorul magazin se va face in cazul in care produsul nu este continut in nicio promotie a magazinului curent
daca produsul nu face parte din nicio promotie a niciunui magazin, el se va achizitiona la pret intreg din magazinul cu prioritatea cea mai mare
daca un produs nu se gaseste in niciun magazin specificat, acesta nu va fi achizitionat
Cerinte tehnice
Sa se dezvolte o aplicatie

(**Java) care sa extraga informatiile necesare si sa le afiseze procesate conform cerintelor functionale
SAU
(**Angular) care sa permita introducerea si procesarea informatiilor conform cerintelor functionale.
Date de intrare:
Informatiile oferite de fiecare magazin se gasesc sub forma unor fisiere text. Numele fiecarui fisier contine denumirea magazinului prefixata cu magazin_. Fiecare astfel de fisier contine informatia daca magazinul este deschis duminica, promotiile din luna curenta si preturile intregi ale produselor. Aceste informatii sunt separate printr-o linie care contine secventa **********.

Informatia referitoare la disponibilitatea magazinelor in zilele de duminica se va gasi pe prima linie din fisier sub forma unui sir de caractere: Inchis sau Deschis.

Promotiile sunt separate intre ele printr-o linie noua si se caracterizeaza prin:

perioada de aplicabilitate, data sub forma yyyy-MM-dd yyyy-MM-dd sau, in cazul in care promotia este valabila o zi, yyyy-MM-dd
lista cu produse.
La final, fisierul contine lista produselor cu pret intreg.

Fiecare produs din lista celor cu pret intreg, precum si din lista fiecarei promotii, se gaseste pe cate o linie din fisier sub forma: denumire:pret.

Exemplu pentru un magazin magazin_Lidl.txt

Inchis
**********
2020-04-01 2020-04-15
banane:3.56
cirese:13.99

2020-04-13
kiwi:5.65
**********
banane:5.55
kiwi:6.45
portocale:10.00
cirese:16.59
Citirea comenzii fiecarui client se va face dintr-un fisier text comanda_numeClient_dataComenzii.txt in care:

prima linie contine denumirile produselor pe care doreste sa le cumpere, separate prin ;
urmatoarele linii contin magazinele de unde se doreste achizitionarea produselor, date sub forma: nume_magazin:prioritate
Numele fiecarui fisier contine numele clientului si data comenzii (separate prin _ ), prefixate cu comanda_.

Exemplu pentru comanda clientului Popescu Dan din data de 6 Aprilie 2020 comanda_PopescuDan_2020-04-06.txt

banane;kiwi;portocale
Lidl:3
Mega Image:1
Auchan:2
(**Java) Fisierele de intrare pot fi descarcate de aici.

(**Angular) Toate informatiile for fi introduse cu ajutorul interfetei utilizator.

Se vor introduce, pe rand, pentru fiecare magazin:

numele
promotiile
produsele cu pret intreg (pentru fiecare produs se vor specifica denumirea si pretul)
Pentru o promotie se vor introduce perioada de aplicabilitate (caracterizata de datele ce reprezinta limitele perioadei) si produsele (pentru fiecare produs se vor specifica denumirea si pretul redus).

Vor fi introduse si informatiile pentru fiecare client:

nume si prenume
data comenzii
produsele pe care doreste sa le cumpere
magazinele de unde se doreste achizitionarea produselor (nume si prioritate).
Date de iesire:
Rezultatele obtinute in urma procesarii vor fi scrise in fisierul comenzi.txt, respectand constrangerile date. Comenzile trebuie sa fie ordonate descrescator dupa suma totala a cumparaturilor, iar in cazul sumelor egale, se ordoneaza crescator dupa numele clientilor.

(**Angular) Rezultatele procesarii vor fi afisate prin intermediul unei noi pagini dezvoltata in Angular.

Observatii
Pretul unui produs este reprezentat printr-un numar cu doua zecimale, separate prin punct.
Limitele perioadelor de aplicabilitate a promotiilor, precum si data comenzii, vor respecta formatul yyyy-MM-dd.
Prioritatea magazinelor este reprezentata prin numere intregi (cu cat numarul este mai mic, cu atat prioritatea este mai mare).
(**Java) In cazul in care apare o eroare la citirea unei linii se va arunca o exceptie specifica. Asta nu trebuie sa impiedice citirea liniilor urmatoare!!!
Livrare si evaluare
Livrare
Livrarea se va face sub forma unei arhive zip cu numele [nume]-[prenume].zip

continand un director src cu package-urile de surse
daca folositi biblioteci externe treceti numele lor intr-un fisier cu numele dependencies inclus in arhiva
daca aveti precizari cu privire la codul vostru, sau ati avut nelamuriri cu privire la cerinte, treceti-le intr-un fisier readme inclus in arhiva
Incarcati arhiva prin intermediul acestei aplicatii accesand sectiunea Trimite.

Daca aveti nelamuriri cu privire la cerinta sau livrarea rezolvarii, scrieti un email la adresa internship@axonsoft.ro.

Evaluare
Se vor evalua:

algoritmul implementat
structurarea proiectului
Puncte bonus vor fi acordate pentru:

cod usor de citit, repectand paradigmele OOP si bunele practici de programare
folosirea cu rost a cat mai multor API-uri din JDK
folosirea sintaxei Java 8
comentarea codului, in special in format javadoc
scrierea de teste unitare
dezvoltarea proiectului utilizand Spring Boot
(**Angular) design-ul interfetei utilizator
