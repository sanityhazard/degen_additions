package net.sntyhzrd.degenadditions.event;

import net.minecraft.advancements.critereon.TameAnimalTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sntyhzrd.degenadditions.DA;
import net.sntyhzrd.degenadditions.damagesource.KillPetDamageSource;
import net.sntyhzrd.degenadditions.init.DamageTypesMI;

import java.util.Set;

@Mod.EventBusSubscriber(modid = DA.MOD_ID)
public class OnKillPetEventHandler {
    @SubscribeEvent
    public static void killPet(LivingDeathEvent e) {
        Entity killer = e.getSource().getEntity();
        Entity killed = e.getEntity();
        if (killer instanceof Player && killed instanceof TamableAnimal pet) {
            if (pet.getOwner() != null && pet.getOwner() instanceof Player) {
                String petName;
                if (pet.hasCustomName()) {
                    petName = pet.getCustomName().getString();
                } else {
                    petName = pet.getOwner().getDisplayName().getString() + "'s " + pet.getType().getDescription().getString();
                }
                killer.level().explode(null, killer.getX() + 0.5D, killer.getY() + 0.5D, killer.getZ() + 0.5D, 2.0F, Level.ExplosionInteraction.NONE);
                killer.hurt(new KillPetDamageSource(Holder.direct(DamageTypesMI.KILLED_PET), (Player) killer, petName), ((Player) killer).getMaxHealth());
//                ((Player) killer).die();
//                killer.hurt(new DamageSource(Holder.direct(new DamageType(/"killed_pet", 1f))), ((Player) killer).getMaxHealth());
            }
        }
    }
}
