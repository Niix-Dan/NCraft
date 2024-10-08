package niix.dan.ncraft.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import niix.dan.ncraft.block.ModBlocks;

public class ModFuels {
    public static void register() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.WHITE_CEDAR_LOG, 300);
        registry.add(ModBlocks.WHITE_CEDAR_STRIPPED_LOG, 300);

        registry.add(ModBlocks.WHITE_CEDAR_WOOD, 300);
        registry.add(ModBlocks.WHITE_CEDAR_STRIPPED_WOOD, 300);

        registry.add(ModBlocks.WHITE_CEDAR_PLANKS, 300);

        registry.add(ModBlocks.WHITE_CEDAR_SLAB, 150);
        registry.add(ModBlocks.WHITE_CEDAR_STAIRS, 300);
        registry.add(ModBlocks.WHITE_CEDAR_TRAPDOOR, 300);
    }

}
