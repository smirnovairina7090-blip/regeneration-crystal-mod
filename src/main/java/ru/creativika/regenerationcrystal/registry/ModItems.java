package ru.creativika.regenerationcrystal.registry;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ru.creativika.regenerationcrystal.RegenerationCrystalMod;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(RegenerationCrystalMod.MOD_ID);

    public static final DeferredItem<BlockItem> REGENERATION_CRYSTAL_ITEM =
            ITEMS.registerSimpleBlockItem(
                    "regeneration_crystal",
                    ModBlocks.REGENERATION_CRYSTAL
            );

    private ModItems() {
    }
}
