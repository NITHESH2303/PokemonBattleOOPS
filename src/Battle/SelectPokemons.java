package Battle;

import GetReady.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class SelectPokemons{
    private static Map<Pokemons, Pokemons> fight;
    private MatchPokes opponent;
    private BattleAdvantages adv;

    public static Map<Pokemons, Pokemons> getFight() {
        return fight;
    }

//    public void setFight(Map<Pokemons, Pokemons> fight) {
//        this.fight = fight;
//    }

    public MatchPokes getOpponent() {
        return opponent;
    }

    public void setOpponent(MatchPokes opponent) {
        this.opponent = opponent;
    }

    public BattleAdvantages getAdv() {
        return adv;
    }

    public void setAdv(BattleAdvantages adv) {
        this.adv = adv;
    }

    public SelectPokemons(MatchPokes poke, MatchPokes opponent){
        this.adv = new PokemonBattle(poke.getPokemons());
        this.opponent = opponent;
        fight = new LinkedHashMap<Pokemons,Pokemons>();
    }

    public void PrepareBattle(){
        Map<String,Pokemons> opponents = opponent.getPokemons();
        for(Map.Entry<String,Pokemons> poke : opponents.entrySet()){
            Pokemons pokemon = adv.Match(poke.getValue());
            fight.put(poke.getValue(), pokemon);
        }
        Output out = new Output();
        if(MatchDecider(PokemonBattle.deciderCount)){
            out.Success();
        }
        else{
            out.Fail();
        }
    }

    private boolean MatchDecider(int deciderCount){
        return deciderCount>=3;
    }
}
