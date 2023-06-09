package com.example.lutemonbattle23;

import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class BattleFieldScreen {

    private static final String LINE = "_____________________________";

    private static final String greenCharacter =
                    "         _,-----._\n" +
                    "      ,;_         _`, \n" +
                    "     ((  `-._.-'`  ))\n" +
                    "      \\\\   ` '`   //  \n" +
                    "       )--|o` `o|--(\n" +
                    "      ;   _\\\\ ` /_   ;\n" +
                    "       ((('`   `')))    \n" +
                    "      / \\\\`--' `--'/ \\\\\n" +
                    "    ,'_._\\\\       /_._', \n" +
                    "    `\"\"` `\"`       `\"` `\"\"`\n" +
                    "    \n";
    private static final String pinkCharacter =
            "     _____ \n" +
            "    /|_||_. \\ __ \n "+
            "  (   _    _ _\n" +
            "=`-(_)--(_)-'======.\n" +
            "  /   `Y''   \\|   \\\n" +
            " l \\__..--''-.\\   <_\n" +
            "`--'          7`----J \n";


    private static final String whiteCharacter =
            "       /\\     /\\\n" +
            "      /  \\___/  \\\n" +
            "      \\ | o o | /\n" +
            "       (|  ^  |)\n" +
            "        | [_] |\n" +
            "    ___.\\___/.\\___. \n" +
            "  /`             `\\ \n" +
            "/  _ `------' _    \\\n" +
            "   (_)   |    (_) \n" +
            "         |         \n";
    private static final String orangeCharacter =
            "       /'\\\n" +
            "      / o \\\n" +
            "     / o o \\\n" +
            "    / o o o \\\n" +
            "   /_o_o_o_\\\n" +
            "   |  | |  |\n" +
            "   |__|_|__|\n" +
            "   /-'Y'-' \\\n" +
            "  (__/ \\__)";
    private static final String blackCharacter =
            "     /\\__/\\\n" +
            "    /`     '\\\n" +
            "  === 0  0 ===\n" +
            "    \\  --  /\n" +
            "   /        \\\n" +
            "  /          \\\n" +
            " (            )\n" +
            "  \\          /\n" +
            "   \\  ||  || /\n" +
            "    \\_oo__oo_/========#\n";



    // Print the battle screen
    public String printLutemonBattleScreen(Lutemon fighter) {

        // Print the top border
        String battleString = LINE + "\n";

        // Print the Lutemon information
        battleString += String.format("| %-15s | (%-15s) |\n", fighter.getName(),fighter.getColor());
        battleString += String.format("| Lv. %-15d", fighter.getExperience());
        battleString += String.format("| Atc. %-14d\n", fighter.getAttack());
        battleString += String.format("| Def. %-14d", fighter.getDefense());
        battleString += String.format("| Hp. %-15d|\n", fighter.getHealth());



        // Print the middle border
        battleString += "|____________|______________|\n";
        //print character
        switch (fighter.getColor()){
            case "Valkoinen":
                battleString += "\n" + whiteCharacter;
            case "Vihreä":
                battleString += "\n" + greenCharacter;
            case "Pinkki":
                battleString += "\n" + pinkCharacter;
            case "Oranssi":
                battleString += "\n" + orangeCharacter;
            case "Musta":
                battleString += "\n" + blackCharacter;
            default:
                battleString += "TAPAHTUI VIRHE";
        }

        return battleString;
    }

    public String battleLogScreen(int damage, Lutemon attacker, Lutemon defender){
        // Print battlelog
        String battleText = "";
        if (damage < defender.health) {
            battleText = attacker.getName()+" hyökkäsi ja teki "+ damage+" pistettä vahinkoa\n";
            if (damage <= 0) {
                battleText += "Hyökkäys torjuttiin\n";
            } else if (0 < damage && damage <= 3) {
                battleText += " Hyökkäys oli melko tehoton\n";
            } else if (3 < damage && damage <= 6) {
                battleText += " Nyt osu pahasti\n";
            } else if (6 < damage) {
                battleText += " kriittinen osuma\n";
            }
            return battleText += defender.name + " hyökkää seuraavaksi";
        } else {
            battleText += attacker.name + " teki kuolettavan iskun ("+ damage +" dmg) ja voitti!";
            return battleText;
        }

    }
}
