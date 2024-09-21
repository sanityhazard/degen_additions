package net.sntyhzrd.degenadditions.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.*;


public class DioriteCurse extends Enchantment {
    public static EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("diorite_curse", item -> item instanceof PickaxeItem);
    public DioriteCurse() {
        super(Rarity.VERY_RARE, ENCHANTMENT_CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public int getMinCost(int p_45274_) {
        return 25;
    }

    public int getMaxCost(int p_45277_) {
        return 50;
    }

    public boolean isTreasureOnly() {
        return true;
    }
}
