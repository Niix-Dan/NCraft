package niix.dan.ncraft.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> WHITE_CEDAR_PLACED = PlacedFeatures.register("white_cedar_placed",
            ModConfiguredFeatures.WHITE_CEDAR_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));

    public static final RegistryEntry<PlacedFeature> OTHALT_ORE_PLACE = PlacedFeatures.register("othalt_ore_placed",
            ModConfiguredFeatures.OTHALT_ORE, modifiersWithCount(2,
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(-40))));


    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

}
