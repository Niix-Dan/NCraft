package niix.dan.ncraft.item.custom;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import niix.dan.ncraft.item.ModItems;

public class OthaltToolMaterial implements ToolMaterial {
    public static final OthaltToolMaterial INSTANCE = new OthaltToolMaterial();


    @Override
    public int getDurability() {
        return 1841;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.5f;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.OTHALT_INGOT);
    }
}
