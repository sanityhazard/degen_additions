package net.sntyhzrd.degenadditions.event;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sntyhzrd.degenadditions.DA;
import net.sntyhzrd.degenadditions.damagesource.LactoseIntoleranceDamageSource;
import net.sntyhzrd.degenadditions.init.DamageTypesMI;

@Mod.EventBusSubscriber(modid = DA.MOD_ID)
public class OnEatPorkEventHandler {
    @SubscribeEvent
    public static void eatPork(LivingEntityUseItemEvent.Finish e) {
        if (e.getItem().is(Items.PORKCHOP) || e.getItem().is(Items.COOKED_PORKCHOP)) {

        }
    }
}
