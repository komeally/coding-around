enum class PokemonType {
    NORMAL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    DARK,
    STEEL,
    FAIRY
}

class Pokemon {
    private var name: String
    private val type: PokemonType
    private var level: Int

    constructor(name: String, type: PokemonType, level: Int) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    constructor(name: String, type: PokemonType) {
        this.name = name;
        this.type = type;
        this.level = 1
    }
    
    fun getName(): String {
        return name;
    }

    fun setName(name: String) {
        this.name = name;
    }

    fun getType(): PokemonType {
        return type;
    }

    fun getLevel(): Int {
        return level;
    }

    override fun toString(): String {
        return "Pokemon{name=$name, type=$type, level=$level}";
    }

    override fun equals(other : Any?): Boolean {
        if(other is Pokemon) {
            return this.type == other.type && this.level == other.level;
        }
        else{
            return false;
        }
    }

    fun levelUp() {
        if(this.level < 100){
            this.level +=1;
        }
        else{
            this.level = 100;
        }
    }   
}

fun main() {
    val pokemon = Pokemon("Pikachu", PokemonType.ELECTRIC);
    println("I choose ${pokemon.getName()}!")
    println(pokemon)
    pokemon.levelUp()
    println("Leveled up ${pokemon.getName()}!")
    println("$pokemon\n")

    val test1 = Pokemon("Arceus", PokemonType.NORMAL);
    val test2 = Pokemon("Meowth", PokemonType.NORMAL);
    println(test1.equals(test2))

    val testPokemon1 = Pokemon("Greninja", PokemonType.WATER);
    val testPokemon2 = Pokemon("Lucario", PokemonType.FIGHTING);
    println(testPokemon1 == testPokemon2)

    val testPokemonA = Pokemon("Bewear", PokemonType.FIGHTING, 25);
    val testPokemonB = Pokemon("Hitmonchan", PokemonType.FIGHTING);
    println(testPokemonA == testPokemonB)
}