package net.sntyhzrd.degenadditions.damagesource;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class LactoseIntoleranceDamageSource extends DamageSource {
    private final Player dumbass;

    public LactoseIntoleranceDamageSource(Holder<DamageType> damageTypeHolder, Player dumbass) {
        super(damageTypeHolder);
        this.dumbass = dumbass;
    }

    @Override
    public Component getLocalizedDeathMessage(LivingEntity entity) {
        String messageKey = "death.degenadditions.attack.drank_milk";
        return Component.translatable(messageKey, dumbass.getDisplayName());
    }
}
