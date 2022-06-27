package randomMindustry;

import arc.struct.*;
import arc.math.*;
import arc.assets.loaders.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;

import static mindustry.Vars.*;

public class BulletMapper{
    public static void init(){
        Seq<Effect> effects = Effect.all;
        
        // Currently only visual, will be fixed later on.
        content.bullets().each(b -> {
            b.hitSound = Sounds.getSound(ResourceMapper.getRandomInt(0, 71));
            b.despawnSound = Sounds.getSound(ResourceMapper.getRandomInt(0, 71));
            
            b.shootEffect = effects.random(Main.rand);
            b.smokeEffect = effects.random(Main.rand);
            b.chargeEffect = effects.random(Main.rand);
            b.hitEffect = effects.random(Main.rand);
            b.despawnEffect = effects.random(Main.rand);
            b.trailEffect = effects.random(Main.rand);
            b.healEffect = effects.random(Main.rand);
        });
    }
}
