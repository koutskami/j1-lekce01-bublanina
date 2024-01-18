package cz.czechitas.recept;

import cz.czechitas.recept.naradi.ElektrickaTrouba;
import cz.czechitas.recept.naradi.Miska;
import cz.czechitas.recept.naradi.Mixer;
import cz.czechitas.recept.naradi.PlechNaPeceni;
import cz.czechitas.recept.naradi.Vaha;
import cz.czechitas.recept.suroviny.Cukr;
import cz.czechitas.recept.suroviny.Maslo;
import cz.czechitas.recept.suroviny.Mouka;
import cz.czechitas.recept.suroviny.Ovoce;
import cz.czechitas.recept.suroviny.PrasekDoPeciva;
import cz.czechitas.recept.suroviny.Vajicka;

public class SpousteciTrida {

  public static void main(String[] args) {
    Miska cervenaMiska;
    Miska zlutaMiska;
    Mixer mixer;
    Vaha kuchynskaVaha;
    PlechNaPeceni plech;
    ElektrickaTrouba trouba;
    Vajicka vajicka;

    Ovoce ovoce;
    Maslo maslo125g;
    Mouka pytlikMouky;
    Cukr pytlikCukru;
    PrasekDoPeciva prasekDoPeciva;

    cervenaMiska = new Miska("cervenaMiska");
    zlutaMiska = new Miska("zlutaMiska");
    mixer = new Mixer("mixer");
    kuchynskaVaha = new Vaha("vaha");
    plech = new PlechNaPeceni("plech");
    trouba = new ElektrickaTrouba("trouba");

    vajicka = new Vajicka("vajicka");
    ovoce = new Ovoce("ovoce");
    maslo125g = new Maslo("maslo125g");
    pytlikMouky = new Mouka("pytlikMouky");
    pytlikCukru = new Cukr("pytlikCukru");
    prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

    //---------------------------------------------------------------------

    // TODO: Sem napiste recept na bublaninu
    // Pouzivejte napovidani v editoru.
    // Vyskakuje samo nebo pomoci Ctrl+Mezernik

    //miska nalozi 4 vejce
    for (int i = 0; i < 4; i++) {
    cervenaMiska.nalozSiJedenKus(vajicka);
    //cyklus pro vkladani vejci do misky, i < pocet vejci v receptu
    }

    //miska si nalozi cukr
    cervenaMiska.nalozSiCelyObsah(pytlikCukru);

    //mixer smicha obsah cervene misky, tj. vejce s cukrem
    mixer.zamichej(cervenaMiska);

    //miska si prida maslo
    cervenaMiska.nalozSiCelyObsah(maslo125g);

    //mixer zamicha obsah cervene misky
    mixer.zamichej(cervenaMiska);

    //do zlute misky dame 250 g mouky z 1kg pytliku, potrebujeme vyuzit vahu
    //nejdrive vahu vynulujeme s miskou
    kuchynskaVaha.vynulujSeS(zlutaMiska);
    //ted potrebujeme cyklus, ktery bude nakladat mouku, dokud nebude odpovidat vaze co chceme
    while (zlutaMiska.getHmotnost() != 250) {
      //chci aby se cyklus opakoval dokud nebude mit miska 250 g
      if (kuchynskaVaha.zjistiHmotnost(zlutaMiska) < 250) {
        zlutaMiska.nalozSiTrochu(pytlikMouky);
        //pokud nema miska pozadovanou hmotnost, pridej trochu mouky
      } else {zlutaMiska.vylozSiTrochu(pytlikMouky);
        //pokud ma miska vic nez pozadovanou hmotnost, uber trochu mouky
      }
    }

    //cervena miska si prevezme obsah zlute misky
    cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);

    //pridani prasku do peciva do cervene misky
    cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);

    //zamichani cervene misky
    mixer.zamichej(cervenaMiska);

    //na plech dame obsah z cervene misky
    plech.preberSiObsah(cervenaMiska);

    //Plech se 50x opakovaně posype kousky ovoce
    for (int i = 0; i < 50; i++) {
     plech.posypSeKusem(ovoce);
      //cyklus pro sypani ovoce na plech, i < pocet ks ovoce
    }

    //predehrati trouby, 5 min
    trouba.zapniSe(180);
    trouba.nechejPect(5);
    //vlozeni plechu, peceni 25 min
    trouba.vlozSiDovnitr(plech);
    trouba.nechejPect(25);
    //dopec a vyndej ven z trouby
    trouba.vypniSe();
    trouba.vyndejObsahVen();
  }
}
