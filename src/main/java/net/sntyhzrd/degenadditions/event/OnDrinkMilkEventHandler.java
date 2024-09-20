package net.sntyhzrd.degenadditions.event;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sntyhzrd.degenadditions.DA;
import net.sntyhzrd.degenadditions.damagesource.KillPetDamageSource;
import net.sntyhzrd.degenadditions.damagesource.LactoseIntoleranceDamageSource;
import net.sntyhzrd.degenadditions.init.DamageTypesMI;

@Mod.EventBusSubscriber(modid = DA.MOD_ID)
public class OnDrinkMilkEventHandler {
    @SubscribeEvent
    public static void drinkMilk(LivingEntityUseItemEvent.Finish e) {
        if (e.getItem().is(Items.MILK_BUCKET)) {
            Entity entity = e.getEntity();
            entity.hurt(new LactoseIntoleranceDamageSource(Holder.direct(DamageTypesMI.KILLED_PET), (Player) entity), ((Player) entity).getMaxHealth());
        }
    }
}
