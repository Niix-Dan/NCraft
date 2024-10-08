package niix.dan.ncraft.mixin.common;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import niix.dan.ncraft.world.dimension.ModDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow public abstract PlayerAbilities getAbilities();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo info) {
        if (ModDimensions.isOblivionDimension(this.world)) {
            applyGravityModification();
        }
    }

    private void applyGravityModification() {
        double moonGravity = 0.0625;
        Vec3d velocity = this.getVelocity();

        if (this.getAbilities().flying || this.isOnGround()) {
            return;
        }

        this.fallDistance = 0;

        double gravityModifier = this.isSneaking() ? (moonGravity / 1.5) : moonGravity;
        this.setVelocity(velocity.x, velocity.y + gravityModifier, velocity.z);
    }
}
