package ru.creativika.regenerationcrystal;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import ru.creativika.regenerationcrystal.registry.ModBlocks;
import ru.creativika.regenerationcrystal.registry.ModItems;

@Mod(RegenerationCrystalMod.MOD_ID)
public final class RegenerationCrystalMod {
    public static final String MOD_ID = "regeneration_crystal";

    public RegenerationCrystalMod(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreativeTabContents);
    }

    private void addCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModItems.REGENERATION_CRYSTAL_ITEM);
        }
    }
}
