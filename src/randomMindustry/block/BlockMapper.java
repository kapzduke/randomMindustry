package randomMindustry.block;

import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import randomMindustry.*;
import randomMindustry.block.creators.*;
import randomMindustry.texture.*;

public class BlockMapper {
    public static final Seq<Block> generatedBlocks = new Seq<>();
    public static final int blockCount = 32;
    public static final Rand rand = new Rand();
    public static final Seq<BlockCreator> creators = new Seq<>(new BlockCreator[]{
            new WallBlockCreator()
    });

    public static void editContent() {
        rand.setSeed(SeedManager.getSeed());
        generatedBlocks.each((b) -> {
            for (BlockCreator creator : creators) {
                if (!creator.has(b)) continue;
                creator.edit(b);
                b.init();
                break;
            }
        });
    }

    public static void generateContent() {
        for (int i = 0; i < blockCount; i++) {
            generatedBlocks.add(creators.random(rand).create("random-block-" + i));
        }
    }

    public static boolean generated(Block block) {
        return generatedBlocks.contains(block);
    }
}
