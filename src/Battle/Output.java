package Battle;

import GetReady.Pokemons;
import java.util.Map;

public class Output{

    public Output(){

    }
    public void Success(){
        StringBuilder out = new StringBuilder();
        Map<Pokemons, Pokemons> fight = SelectPokemons.getFight();
        for (Map.Entry<Pokemons, Pokemons> m : fight.entrySet()) {
            out.append(m.getValue().getName()).append("#").append(m.getValue().getLevel()).append(";");
        }
        System.out.println(out);
    }

    public void Fail() {
        System.out.println("No chance Of Winning");
    }
}
