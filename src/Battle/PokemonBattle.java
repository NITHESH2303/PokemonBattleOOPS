package Battle;

import GetReady.PokemonStrength;
import GetReady.Pokemons;
import java.util.List;
import java.util.Map;

public class PokemonBattle implements BattleAdvantages{
    private PokemonStrength pokemonStrength;
    private Map<String, Pokemons> squad;
    private boolean isWin=false;
    private Pokemons survive=null;
    static int deciderCount=0;

    public PokemonStrength getPokemonStrength() {
        return pokemonStrength;
    }

    public void setPokemonStrength() {
        this.pokemonStrength = PokemonStrength.getInstance();
    }

    public Map<String, Pokemons> getSquad() {
        return squad;
    }

    public void setSquad(Map<String, Pokemons> squad) {
        this.squad = squad;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public Pokemons getSurvive() {
        return survive;
    }

    public void setSurvive(Pokemons survive) {
        this.survive = survive;
    }

    public PokemonBattle(Map<String,Pokemons> pokes){
        this.squad = pokes;
        this.setPokemonStrength();
    }

    public Pokemons Match(Pokemons pokemon){
        survive = null;
        LevelAdvantage(pokemon);
        TypeAdvantage(pokemon);
        WeakAdvantage(pokemon);
        if(!isWin){
            DrawBattle(pokemon);
            if(survive == null){
                Map <String,Pokemons> squad =this.squad;
                for (Map.Entry<String,Pokemons> entry : squad.entrySet()){
                    survive = entry.getValue();
                    break;
                }
            }
        }
        assert survive != null;
        this.squad.remove(survive.getName());
        if(isWin) deciderCount++;
        isWin = false;
        return survive;
    }

    @Override
    public void LevelAdvantage(Pokemons opponent){
        Map<String,Pokemons> squad = this.squad;
        for(Map.Entry<String,Pokemons> entry : squad.entrySet()){
            if(entry.getValue().getLevel() > opponent.getLevel()){
                if(survive != null){
                    CloseLevel(opponent,entry.getValue());
                }else{
                    isWin = true;
                    survive = entry.getValue();
                }
                break;
            }
        }
    }

    @Override
    public void TypeAdvantage(Pokemons opponent){
        Map <String,Pokemons> squad = this.squad;
        for(Map.Entry<String,Pokemons> entry : squad.entrySet()){
            List<String> oppAdv = this.pokemonStrength.getPokeStrength().get(entry.getKey());
            for(String type : oppAdv){
                if(opponent.getName().equals(type)){
                    if(opponent.getLevel() < 2*entry.getValue().getLevel()
                        || opponent.getLevel() < entry.getValue().getLevel()){
                        if(survive !=null){
                            CloseLevel(opponent, entry.getValue());
                        } else {
                            isWin = true;
                            survive = entry.getValue();
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void WeakAdvantage(Pokemons opponent){
        Map<String,Pokemons> squad = this.squad;
        List<String> oppAdv =this.pokemonStrength.getPokeStrength().get(opponent.getName());
        for(String adv : oppAdv){
            if(squad.containsKey(adv)){
                if(squad.get(adv).getLevel() >= 2*opponent.getLevel()){
                    if(survive!=null){
                        CloseLevel(opponent, squad.get(adv));
                    } else{
                        isWin = true;
                        survive =squad.get(adv);
                        break;
                    }
                }
            }
        }
    }

    private void CloseLevel(Pokemons opponent , Pokemons trainer){
        if(opponent.getLevel() <= trainer.getLevel()){
            if (trainer.getLevel() >= survive.getLevel()){
                survive = trainer;
                isWin = true;
            }
        }else if(opponent.getLevel() > trainer.getLevel()){
            if (trainer.getLevel() < survive.getLevel()){
                survive = opponent;
                isWin = false;
            }
        }
    }

    @Override
    public void DrawBattle(Pokemons opponent){
        Map<String, Pokemons> squad = this.squad;
        for(Map.Entry<String, Pokemons> entry : squad.entrySet()){
            if(entry.getValue().getLevel() == opponent.getLevel()){
                survive = entry.getValue();
                break;
            }
        }
    }
}
