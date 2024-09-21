package net.sntyhzrd.degenadditions.init;

import net.minecraft.world.item.enchantment.Enchantment;
import net.sntyhzrd.degenadditions.enchantment.DioriteCurse;
import org.zeith.hammerlib.annotations.RegistryName;
import org.zeith.hammerlib.annotations.SimplyRegister;

@SimplyRegister
public interface EnchantmentsMI {
    @RegistryName("diorite_curse")
    Enchantment DIORITE_CURSE = new DioriteCurse();
}
