package GetReady;

import java.util.*;
import Battle.MatchPokes;

public class Initialize implements MatchPokes{
    public Map<String, Pokemons> pokemons = new LinkedHashMap<>();

    public Initialize(String squad) {
        PokemonList(squad);
    }

    public Map<String, Pokemons> getPokemons() {
        return pokemons;
    }

    public void setPokemonsMap(Map<String, Pokemons> pokemonsMap) {
        this.pokemons = pokemonsMap;
    }

    public void PokemonList(String inputSquad){
        String[] pokes = inputSquad.split(";");
        for (String s: pokes){
            String[] pokemon =s.split("#");
            pokemons.put(pokemon[0],new Pokemons(pokemon[0],Integer.parseInt(pokemon[1])));
        }
    }
}
