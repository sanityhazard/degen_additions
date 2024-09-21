package net.sntyhzrd.degenadditions.event;

import net.minecraft.advancements.critereon.TameAnimalTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sntyhzrd.degenadditions.DA;
import net.sntyhzrd.degenadditions.damagesource.KillPetDamageSource;
import net.sntyhzrd.degenadditions.enchantment.DioriteCurse;
import net.sntyhzrd.degenadditions.init.DamageTypesMI;
import net.sntyhzrd.degenadditions.init.EnchantmentsMI;

import java.util.Set;

@Mod.EventBusSubscriber(modid = DA.MOD_ID)
public class OnMineStoneEventHandler {
    @SubscribeEvent
    public static void mineStone(BlockEvent.BreakEvent e) {
        // Check if the entity breaking the block is a player
        BlockState state = e.getState();
        Player p = e.getPlayer();

        // Check if the block is a "base stone" and the player is holding a pickaxe with Diorite Curse
        if (state.is(BlockTags.BASE_STONE_OVERWORLD) &&
                p.getMainHandItem().is(ItemTags.PICKAXES) &&
                p.getMainHandItem().getAllEnchantments().containsKey(EnchantmentsMI.DIORITE_CURSE)) {

            Level level = p.level();
            BlockPos pos = e.getPos();

            // Ensure we are on the server side
            if (!level.isClientSide) {
                // Cancel the original block break event (no block will drop its default items)
                e.setCanceled(true);

                // Break block
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

                // Optionally, you can spawn Diorite item as a drop if you want the player to collect it
                ItemStack dioriteItem = new ItemStack(Blocks.DIORITE);
                Block.popResource(level, pos, dioriteItem);
            }
        }
    }
}
