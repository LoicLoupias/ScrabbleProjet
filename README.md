Projet JAVA - Scrabble :

Vue :

Plateau (15x15) Différents joueurs + leur jeu (jeu personnel visible, jeu des autres cachés)--------> NB DE JOUEURS ? Fenêtre de points ? Historique des mots joués + points obtenus

Structures données :

Plateau -> tableau ? jeu des joueurs -> tableau ? vecteur ? Mots possibles -> Dictionnaire (Hashtable) Calcul des points + case spéciales à répertorier directement dans le tableau du plateau -> plateau est un tableau de couple (Char,Multiplicateur) Alphabet des lettres jouables -> Couple (Char, int)

Méthodes :

proposer_mot verifier_mot voir_mots_possibles (à la fin, bonus) distribuer piocher calcul_des_points changer_une_lettre

Classes : Modele Vue Controleur

Couples Alphabet (Lettre,Points,Quantité) :

(A,1,9) (B,3,2) (C,3,2) (D,2,3) (E,1,15) (F,4,2) (G,2,2) (H,4,2) (I,1,8) (J,8,1) (K,10,1) (L,1,5) (M,2,3) (N,1,6) (O,1,6) (P,3,2) (Q,8,1) (R,1,6) (S,1,6) (T,1,6) (U,1,6) (V,4,2) (W,10,1) (X,10,1) (Y,10,1) (Z,10,1) (*,0,2)
