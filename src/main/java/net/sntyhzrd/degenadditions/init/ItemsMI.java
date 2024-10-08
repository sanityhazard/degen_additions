package net.sntyhzrd.degenadditions.init;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.zeith.hammerlib.annotations.RegistryName;
import org.zeith.hammerlib.annotations.SimplyRegister;
import net.sntyhzrd.degenadditions.DA;

@SimplyRegister
public interface ItemsMI
{
	@RegistryName("test")
	Item TEST_ITEM = DA.MOD_TAB.add(new Item(new Item.Properties())
	{
		@Override
		public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
		{
			System.out.println(player.getItemInHand(hand));
			return InteractionResultHolder.success(player.getItemInHand(hand));
		}
	});
}