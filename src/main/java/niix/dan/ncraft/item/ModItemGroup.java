package niix.dan.ncraft.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import niix.dan.ncraft.NCraft;

public class ModItemGroup {
    public static final ItemGroup NCRAFT = FabricItemGroupBuilder
            .build(new Identifier(NCraft.MOD_ID, "nicraft"), () -> new ItemStack(ModItems.RAW_OTHALT));
}
