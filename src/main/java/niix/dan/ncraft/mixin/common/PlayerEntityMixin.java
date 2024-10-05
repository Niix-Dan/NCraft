package niix.dan.ncraft.mixin.common;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import niix.dan.ncraft.world.dimension.ModDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo info) {
        PlayerEntity plr = (PlayerEntity) (Object) this;
        World world = plr.getEntityWorld();

        if (ModDimensions.isOblivionDimension(world)) {
            applyGravityModification(plr);
        }
    }

    private void applyGravityModification(PlayerEntity plr) {
        double moonGravity = 0.0625;
        Vec3d velocity = plr.getVelocity();

        if (plr.getAbilities().flying) {
            return;
        }

        if (!plr.isSneaking() && !plr.isOnGround()) {
            plr.fallDistance = 0;
            plr.setVelocity(velocity.x, velocity.y + moonGravity, velocity.z);
        } else if (!plr.isOnGround()) {
            plr.fallDistance = 0;
            plr.setVelocity(velocity.x, velocity.y + (moonGravity / 1.5), velocity.z);
        }
    }

}
