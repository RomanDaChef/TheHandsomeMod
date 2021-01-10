
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.handsomemod.procedures.RichtungfliegenProcedure;
import net.mcreator.handsomemod.itemgroup.HandsomeMiscItemGroup;
import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;
import java.util.HashMap;

@TheHandsomeModModElements.ModElement.Tag
public class PocketRocketItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:pocket_rocket")
	public static final Item block = null;
	public PocketRocketItem(TheHandsomeModModElements instance) {
		super(instance, 67);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(HandsomeMiscItemGroup.tab).maxDamage(4000).rarity(Rarity.COMMON));
			setRegistryName("pocket_rocket");
		}

		@Override
		public int getItemEnchantability() {
			return 15;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 5;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				RichtungfliegenProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
