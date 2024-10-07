package niix.dan.ncraft.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import niix.dan.ncraft.util.IEntityDataSaver;
import niix.dan.ncraft.util.SanityData;

public class SanityFragment extends Item {
    public SanityFragment(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack item) {
        return true;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        if(!world.isClient()) {
            if(user.isPlayer()) {
                PlayerEntity player = (PlayerEntity) user;

                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
                SanityData.addSanity(dataPlayer, 0.5f);

                // Temporário, ate descobrir prq a comida n recupera \/
                player.getHungerManager().add(1, 0.2f);
            }
        }

        return stack;
    }
}
