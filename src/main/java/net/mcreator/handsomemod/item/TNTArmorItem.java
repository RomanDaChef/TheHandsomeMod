
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.handsomemod.procedures.TNTArmorBootsFireContactProcedure;
import net.mcreator.handsomemod.itemgroup.HandsomeMiscItemGroup;
import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;
import java.util.HashMap;

@TheHandsomeModModElements.ModElement.Tag
public class TNTArmorItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:tnt_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("the_handsome_mod:tnt_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("the_handsome_mod:tnt_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("the_handsome_mod:tnt_armor_boots")
	public static final Item boots = null;
	public TNTArmorItem(TheHandsomeModModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 20;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.OBSIDIAN, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "tnt_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(HandsomeMiscItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "the_handsome_mod:textures/models/armor/tnt__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					TNTArmorBootsFireContactProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("tnt_armor_boots"));
	}
}
