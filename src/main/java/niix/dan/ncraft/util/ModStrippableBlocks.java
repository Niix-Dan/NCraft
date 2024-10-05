package niix.dan.ncraft.util;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import niix.dan.ncraft.block.ModBlocks;

public class ModStrippableBlocks {

    public static void register() {
        StrippableBlockRegistry.register(ModBlocks.WHITE_CEDAR_LOG, ModBlocks.WHITE_CEDAR_STRIPPED_LOG);
        StrippableBlockRegistry.register(ModBlocks.WHITE_CEDAR_WOOD, ModBlocks.WHITE_CEDAR_STRIPPED_WOOD);
    }

}
