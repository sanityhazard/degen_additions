package net.sntyhzrd.degenadditions.mixins;

import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pig.class)
public class PigMixin {

    @Shadow
    @Mutable
    private static Ingredient FOOD_ITEMS;

    // Modify the static FOOD_ITEMS field during class initialization
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyFoodItems(CallbackInfo ci) {
        // Replace the original FOOD_ITEMS with new ones, e.g., adding APPLE and BREAD
        FOOD_ITEMS = Ingredient.of(Items.CARROT, Items.POTATO, Items.BEETROOT, Items.PORKCHOP, Items.COOKED_PORKCHOP);
    }
}