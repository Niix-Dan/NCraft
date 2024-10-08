package niix.dan.ncraft.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.item.ModItems;

public class OthaltArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY;
    private static final int[] PROTECTION_AMOUNT;

    public static final OthaltArmorMaterial INSTANCE = new OthaltArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 35;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_AMOUNT[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.OTHALT_INGOT);
    }

    @Override
    public String getName() {
        return NCraft.MOD_ID + ":othalt";
    }

    @Override
    public float getToughness() {
        return 1.60f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.075f;
    }


    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
        PROTECTION_AMOUNT = new int[]{4, 5, 8, 4};
    }
}
