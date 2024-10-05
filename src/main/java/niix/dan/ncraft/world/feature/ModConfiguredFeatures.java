package niix.dan.ncraft.world.feature;

import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_OTHALT_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.OTHALT_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_OTHALT_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> OTHALT_ORE =
            ConfiguredFeatures.register("othalt_ore", Feature.ORE, new OreFeatureConfig(
                    OVERWORLD_OTHALT_ORES, 8
            ));


    // Preciso arrumar o bloco de terra no pé da arvore, preciso mudar para o bloco de void
    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> WHITE_CEDAR_TREE =
            ConfiguredFeatures.register("white_cedar_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.WHITE_CEDAR_LOG),
                    new StraightTrunkPlacer(7, 12, 6),
                    BlockStateProvider.of(ModBlocks.WHITE_CEDAR_LEAVES),
                    new SpruceFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), ConstantIntProvider.create(6)),
                    new TwoLayersFeatureSize(1, 0, 2)
            ).build());

    public static final RegistryEntry<PlacedFeature> WHITE_CEDAR_CHECKED = PlacedFeatures.register("white_cedar_checked",
            ModConfiguredFeatures.WHITE_CEDAR_TREE, List.of(
                    PlacedFeatures.wouldSurvive(ModBlocks.WHITE_CEDAR_SAPLING)
            ));

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WHITE_CEDAR_SPAWN =
            ConfiguredFeatures.register("white_cedar_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(WHITE_CEDAR_CHECKED, 0.5f)
                    ), WHITE_CEDAR_CHECKED));


    public static void register() {
        NCraft.LOGGER.debug("Registering ModConfiguredFeatures for "+NCraft.MOD_ID);
    }
}
