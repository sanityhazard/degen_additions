package net.sntyhzrd.degenadditions.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.sntyhzrd.degenadditions.DA;
import net.sntyhzrd.degenadditions.damagesource.KillPetDamageSource;
import org.zeith.hammerlib.annotations.RegistryName;
import org.zeith.hammerlib.annotations.SimplyRegister;

@SimplyRegister
public interface DamageTypesMI {
    @RegistryName("killed_pet")
    DamageType KILLED_PET = new DamageType("killed_pet", 1f);

    @RegistryName("drank_milk")
    DamageType DRANK_MILK = new DamageType("drank_milk", 1f);
}
