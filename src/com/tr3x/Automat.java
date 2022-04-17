package com.tr3x;

public class Automat{

    int zustand=0;

    public Automat(){

    }
    public void zustandWechseln(char eingabe){


        switch(zustand){
            case 0 :

            case 1 :
                if(eingabe == 'a'){
                zustand = 0 ;
            }
            else if(eingabe == 'b'){
                zustand = 1 ;
            }
            else{
                zustand=3;
            }
                break;

        }

    }

    public int wortPruefen(char[] alph){

        for (char c : alph) {

            zustandWechseln(c);
            if (zustand == 3) {

                return 3;

            }
        }
        if(zustand == 1){
            return 1;
        }

        return 0;
    }



}
