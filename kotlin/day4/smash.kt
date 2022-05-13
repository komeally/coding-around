import java.util.Random

var RNG = Random();

class Smash(name: String, damageAmount: Int) {
    private val name: String
    private val damageAmount: Int

    init {
        this.name = name;
        this.damageAmount = damageAmount;
    }

    fun getName(): String {
        return name;
    }

    fun getDamageAmount(): Int {
        return damageAmount;
    }

    override fun toString(): String {
        if(this.getDamageAmount() == 0){
            return "${this.name} misses and deals ${this.damageAmount} damage!";
        }
        return "${this.name} hits for ${this.damageAmount} damage!";
    }
}

abstract class Challenger(name: String, maxHP: Int) {
    private val name: String
    private val maxHP: Int
    private var currentHP: Int

    init {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    fun getName(): String {
        return name;
    }

    fun getMaxHP(): Int {
        return maxHP;
    }

    fun getCurrentHP(): Int {
        return currentHP;
    }

    override fun toString(): String {
        return "$name {$currentHP / $maxHP}"
    }

    fun isConscious(): Boolean {
        return (this.currentHP > 0);
    }

    fun reduceHP(amount: Int) {
        this.currentHP -= amount;
        if(this.currentHP < 0){
            this.currentHP = 0;
        }
    }
    
    abstract fun smash(): Smash
    abstract fun takeDamage(smash: Smash)
}

private val MANIO_BRO_HEALTH = 100;
class ManioBros(name: String) : Challenger(name, MANIO_BRO_HEALTH) {

    override fun smash(): Smash {
        var damage = RNG.nextInt(25, 51);
        return Smash("jump attack", damage)
    }

    override fun takeDamage(smash: Smash) {
        var dodge = RNG.nextDouble();
        if(dodge < 0.25) { 
            reduceHP(0); 
        }
        else{
            reduceHP(smash.getDamageAmount());
        }
    }
}

private val LONK_HP = 150;
class Lonk(name: String) : Challenger(name, LONK_HP) {
    
    override fun smash(): Smash {
        return Smash("sword", 45);
    }

    override fun takeDamage(smash: Smash) {
        var block = RNG.nextDouble();
        if(block > 0.5){
            reduceHP(smash.getDamageAmount()/ 2);
        }
        else{
            reduceHP(smash.getDamageAmount());   
        }
    }
}

private val MULE_MONKEY_HP = 200;
class MuleMonkey(name: String) : Challenger(name, MULE_MONKEY_HP) {
    
    override fun smash(): Smash {
        var attack = RNG.nextDouble();
        if(attack > 0.75){
            return Smash("Bash", 0); 
        }
        return Smash("Bash", 75);
    }

    override fun takeDamage(smash: Smash) {
        if(getCurrentHP() < 50){
            reduceHP(10);
        }
        else{
            reduceHP(smash.getDamageAmount());   
        }
    }
}

private val SAMOSA_HP = 200;
class SamosA(name: String) : Challenger(name, SAMOSA_HP) {
    
    override fun smash(): Smash {
        var attack = RNG.nextDouble();
        if(attack > 0.75){
            return Smash("missiles", 75);
        } 
        return Smash("arm cannon", 40);
    }

    override fun takeDamage(smash: Smash) {
        reduceHP(smash.getDamageAmount());
    }
}

fun battle(fighter1 : Challenger, fighter2: Challenger) {
    
    println("${fighter1.getName()} VS ${fighter2.getName()}")

    while(fighter1.isConscious() && fighter2.isConscious()) {
        if(!fighter1.isConscious()){
            println("${fighter2.getName()} wins!");
            break
        }
        else{
            var fighter1Attack = fighter1.smash();
            println("${fighter1.getName()} attacks ${fighter2.getName()}!");
            fighter2.takeDamage(fighter1Attack);
            println("${fighter1.getName()}'s $fighter1Attack");
            println(fighter2);
        }

        if(!fighter2.isConscious()){
            println("${fighter1.getName()} wins!");
            break
        }
        else{
            var fighter2Attack = fighter2.smash();
            println("${fighter2.getName()} attacks ${fighter1.getName()}!");
            fighter1.takeDamage(fighter2Attack);
            println("${fighter2.getName()}'s $fighter2Attack");
            println(fighter1);
        }

        if(!fighter1.isConscious() && !fighter2.isConscious()){
            println("The battle is a draw!!");
            break
        }
    }
}

fun main() {
    val fighter1 = ManioBros("Manio")
    // val fighter1 = SamosA("SamosA.")
    // val fighter2 = MuleMonkey("MuleMonkey")
    val fighter2 = Lonk("Lonk")

    battle(fighter1, fighter2)
}