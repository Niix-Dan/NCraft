package niix.dan.ncraft.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.StructureType;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.world.structures.CedarTreeStructures;
import niix.dan.ncraft.world.structures.SpikeStructures;

public class ModStructures {
    public static StructureType<SpikeStructures> SPIKE_STRUCTURES;
    public static StructureType<CedarTreeStructures> CEDAR_TREE_STRUCTURES;

    public static void register() {

        NCraft.LOGGER.debug("Registering ModStructures for "+NCraft.MOD_ID);

        SPIKE_STRUCTURES = Registry.register(Registry.STRUCTURE_TYPE,
                new Identifier(NCraft.MOD_ID, "spike_structures"), () -> SpikeStructures.CODEC);

        CEDAR_TREE_STRUCTURES = Registry.register(Registry.STRUCTURE_TYPE,
                new Identifier(NCraft.MOD_ID, "cedar_tree_structures"), () -> CedarTreeStructures.CODEC);
    }
}
