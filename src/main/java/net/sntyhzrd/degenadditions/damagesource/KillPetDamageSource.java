package net.sntyhzrd.degenadditions.damagesource;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class KillPetDamageSource extends DamageSource {
    private final Player killer;
    private final String petName;

    public KillPetDamageSource(Holder<DamageType> damageTypeHolder, Player killer, String petName) {
        super(damageTypeHolder);
        this.killer = killer;
        this.petName = petName;
    }

    @Override
    public Component getLocalizedDeathMessage(LivingEntity entity) {
        String messageKey = "death.degenadditions.attack.killed_pet";
        return Component.translatable(messageKey, killer.getDisplayName(), petName);
    }
}
