package niix.dan.ncraft.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import niix.dan.ncraft.block.ModBlocks;

public class ModFlammableBlocks {
    public static void register() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.WHITE_CEDAR_LOG, 5, 5);
        registry.add(ModBlocks.WHITE_CEDAR_WOOD, 5, 5);

        registry.add(ModBlocks.WHITE_CEDAR_STRIPPED_LOG, 5, 5);
        registry.add(ModBlocks.WHITE_CEDAR_STRIPPED_WOOD, 5, 5);

        registry.add(ModBlocks.WHITE_CEDAR_PLANKS, 5, 20);
        registry.add(ModBlocks.WHITE_CEDAR_LEAVES, 30, 60);
    }
}
