package niix.dan.ncraft.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.structure.StructureType;
import niix.dan.ncraft.NCraft;
import niix.dan.ncraft.world.structures.SpikeStructures;

public class ModStructures {
    public static StructureType<SpikeStructures> SPIKE_STRUCTURES;

    public static void register() {

        NCraft.LOGGER.debug("Registerind ModStructures for "+NCraft.MOD_ID);

        SPIKE_STRUCTURES = Registry.register(Registry.STRUCTURE_TYPE,
                new Identifier(NCraft.MOD_ID, "spike_structures"), () -> SpikeStructures.CODEC);
    }
}
