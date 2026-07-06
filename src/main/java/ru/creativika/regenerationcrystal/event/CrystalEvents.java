package ru.creativika.regenerationcrystal.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import ru.creativika.regenerationcrystal.RegenerationCrystalMod;
import ru.creativika.regenerationcrystal.registry.ModBlocks;

import java.util.List;

@EventBusSubscriber(modid = RegenerationCrystalMod.MOD_ID)
public final class CrystalEvents {
    private static final double EFFECT_RADIUS = 5.0;
    private static final int EFFECT_DURATION_TICKS = 200;

    private CrystalEvents() {
    }

    @SubscribeEvent
    public static void onCrystalActivated(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) {
            return;
        }

        Level level = event.getLevel();
        if (level.isClientSide) {
            return;
        }

        BlockPos crystalPosition = event.getPos();
        if (!level.getBlockState(crystalPosition).is(ModBlocks.REGENERATION_CRYSTAL.get())) {
            return;
        }

        AABB effectArea = new AABB(crystalPosition).inflate(EFFECT_RADIUS);
        List<Player> nearbyPlayers = level.getEntitiesOfClass(
                Player.class,
                effectArea,
                Player::isAlive
        );

        for (Player player : nearbyPlayers) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.REGENERATION,
                    EFFECT_DURATION_TICKS,
                    0
            ));
        }

        event.getEntity().displayClientMessage(
                Component.literal(
                        "Кристалл активирован. Игроков в радиусе: " + nearbyPlayers.size()
                ),
                true
        );
    }
}
