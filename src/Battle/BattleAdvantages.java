package Battle;

import GetReady.Pokemons;

public interface BattleAdvantages {
    void LevelAdvantage(Pokemons pokemon);
    void TypeAdvantage(Pokemons pokemon);
    void WeakAdvantage(Pokemons pokemon);
    void DrawBattle(Pokemons pokemon);
    Pokemons Match(Pokemons pokemon);
}
