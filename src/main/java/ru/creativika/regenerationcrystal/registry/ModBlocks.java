package ru.creativika.regenerationcrystal.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.creativika.regenerationcrystal.RegenerationCrystalMod;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RegenerationCrystalMod.MOD_ID);

    public static final DeferredBlock<Block> REGENERATION_CRYSTAL =
            BLOCKS.registerSimpleBlock(
                    "regeneration_crystal",
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_MAGENTA)
                            .strength(1.5F, 6.0F)
                            .sound(SoundType.AMETHYST)
                            .lightLevel(state -> 10)
                            .noOcclusion()
            );

    private ModBlocks() {
    }
}
