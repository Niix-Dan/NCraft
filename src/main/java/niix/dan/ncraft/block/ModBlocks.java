package niix.dan.ncraft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.block.custom.Void_Grass;
import niix.dan.ncraft.block.custom.Void_Soil;
import niix.dan.ncraft.item.ModItemGroup;

public class ModBlocks {

    public static final Block OBLIVION_VOID = registerBlock("void",
            new Void_Soil(FabricBlockSettings.of(Material.SOIL)), ModItemGroup.NCRAFT);

    public static final Block OBLIVION_GRASS = registerBlock("void_grass",
            new Void_Grass(FabricBlockSettings.of(Material.PLANT)), ModItemGroup.NCRAFT);

    public static final Block OTHALT_BLOCK = registerBlock("othalt_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()),
            ModItemGroup.NCRAFT);

    public static final Block DEEPSLATE_OTHALT_ORE = registerBlock("deepslate_othalt_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.NCRAFT);

    public static final Block OTHALT_ORE = registerBlock("othalt_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.NCRAFT);


    public static final Block WHITE_CEDAR_DOOR = registerBlock("white_cedar_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_LEAVES = registerBlock("white_cedar_leaves",
            new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_LOG = registerBlock("white_cedar_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_WOOD = registerBlock("white_cedar_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_STRIPPED_LOG = registerBlock("white_cedar_stripped_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_STRIPPED_WOOD = registerBlock("white_cedar_stripped_wood",
            new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_PLANKS = registerBlock("white_cedar_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_SLAB = registerBlock("white_cedar_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_STAIRS = registerBlock("white_cedar_stairs",
            new StairsBlock(Blocks.OAK_STAIRS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_STAIRS)), ModItemGroup.NCRAFT);

    public static final Block WHITE_CEDAR_TRAPDOOR = registerBlock("white_cedar_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_TRAPDOOR)), ModItemGroup.NCRAFT);


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(NCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(NCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        NCraft.LOGGER.debug("Registering ModBlocks for "+NCraft.MOD_ID);
    }

}
