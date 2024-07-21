package cn.ksmcbrigade.mes.mixin;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{
    protected PlayerMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Shadow public abstract boolean addItem(ItemStack p_36357_);

    @Shadow public abstract boolean hurt(@NotNull DamageSource p_36154_, float p_36155_);

    @Inject(method = "attack",at = @At("HEAD"))
    public void onAttack(Entity p_36347_, CallbackInfo ci){
        if((p_36347_ instanceof LivingEntity) && EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.disarm, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            this.addItem(((LivingEntity) p_36347_).getUseItem());
            ((LivingEntity) p_36347_).setItemInHand(((LivingEntity) p_36347_).getUsedItemHand(),ItemStack.EMPTY);
        }
    }

    @Redirect(method = "attack",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"))
    public boolean hurt(LivingEntity instance, DamageSource entity, float ev){
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.hurtMyself, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            return this.hurt(entity,ev);
        }
        else{
            return instance.hurt(entity,ev);
        }
    }

    @Inject(method = "attack",at = @At("TAIL"))
    public void attackAfter(Entity p_36347_, CallbackInfo ci){
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.fireMyself, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            this.setSecondsOnFire(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.fireMyself, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID()))));
        }
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.fire, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            p_36347_.setSecondsOnFire(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.fireMyself, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID()))));
        }
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.lightingMyself, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,this.level());
            lightningBolt.setPos(this.position());
            this.level().addFreshEntity(lightningBolt);
        }
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.lighting, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,this.level());
            lightningBolt.setPos(p_36347_.position());
            this.level().addFreshEntity(lightningBolt);
        }
        if(EnchantmentHelper.getEnchantmentLevel(MoreEnchantmentsRegistry.kill, Objects.requireNonNull(this.level().getPlayerByUUID(this.getUUID())))>0){
            p_36347_.kill();
        }
    }
}
