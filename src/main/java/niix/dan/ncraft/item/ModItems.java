package niix.dan.ncraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.item.custom.OthaltToolMaterial;
import niix.dan.ncraft.item.custom.SanityFragment;

public class ModItems {

    // Por algum motivo, n ta recuperando fome, apenas a sanidade \/
    public static final Item SANITY_FRAGMENT = registerItem("fragment",
            new SanityFragment(new FabricItemSettings().food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(2)
                    .saturationModifier(0.2f)
                    .build()
            ).group(ModItemGroup.NCRAFT)));

    public static final Item RAW_OTHALT = registerItem("raw_othalt",
            new Item(new FabricItemSettings().group(ModItemGroup.NCRAFT)));

    public static final Item OTHALT_INGOT = registerItem("othalt_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.NCRAFT)));

    public static final Item OTHALT_PICKAXE = registerItem("othalt_pickaxe",
            new PickaxeItem(OthaltToolMaterial.INSTANCE, 2, -2.8f, new FabricItemSettings().group(ModItemGroup.NCRAFT)));

    public static final Item OTHALT_AXE = registerItem("othalt_axe",
            new AxeItem(OthaltToolMaterial.INSTANCE, 8.5f, -3.2f, new FabricItemSettings().group(ModItemGroup.NCRAFT)));

    public static final Item OTHALT_SHOVEL = registerItem("othalt_shovel",
            new ShovelItem(OthaltToolMaterial.INSTANCE, 1, -2.8f, new FabricItemSettings().group(ModItemGroup.NCRAFT)));

    public static final Item OTHALT_SWORD = registerItem("othalt_sword",
            new SwordItem(OthaltToolMaterial.INSTANCE, 7, -1.6f, new FabricItemSettings().group(ModItemGroup.NCRAFT)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(NCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NCraft.LOGGER.debug("Registering Mod Items for "+ NCraft.MOD_ID);
    }

}
