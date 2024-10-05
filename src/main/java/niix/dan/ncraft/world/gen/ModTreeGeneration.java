package niix.dan.ncraft.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import niix.dan.ncraft.world.dimension.ModBiomes;
import niix.dan.ncraft.world.feature.ModPlacedFeatures;

public class ModTreeGeneration {

    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.OBLIVION_DEPTHS_KEY),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.WHITE_CEDAR_PLACED.getKey().get());

    }

}
