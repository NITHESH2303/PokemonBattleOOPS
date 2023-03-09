package GetReady;

import Battle.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PokemonStrength {
    private static PokemonStrength pokemonStrength = null;
    private Map<String, List<String>> pokeStrength = new LinkedHashMap<>();

    private PokemonStrength(){

    }

    public static PokemonStrength getInstance() {
        pokemonStrength = new PokemonStrength();
        return pokemonStrength;
    }

    public Map<String, List<String>> getPokeStrength() {
        pokeStrength.put("Fire", Arrays.asList("Grass","Ghost"));
        pokeStrength.put("Water",List.of("Fire"));
        pokeStrength.put("Grass", Arrays.asList("Electric", "Fighting"));
        pokeStrength.put("Electric", List.of("Water"));
        pokeStrength.put("Psychic", List.of("Ghost"));
        pokeStrength.put("Ghost", Arrays.asList("Fighting", "Fire", "Electric"));
        pokeStrength.put("Fighting", List.of("Electric"));
        return pokeStrength;
    }
}
