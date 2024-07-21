package cn.ksmcbrigade.mes.mixin;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.item.enchantment.EnchantmentHelper.getEnchantmentLevel;

@Mixin(ProtectionEnchantment.class)
public class ProtectionEnchantmentMixin {
    @Inject(method = "getFireAfterDampener",at = @At("RETURN"),cancellable = true)
    private static void fire(LivingEntity p_45139_, int p_45140_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedFireProtection,p_45139_)*2;
        if(advanced_fire==0){
            if(EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_PROTECTION, p_45139_)==0){
                cir.setReturnValue(moreEnchantments$getFire(getEnchantmentLevel(MoreEnchantmentsRegistry.basicFireProtection,p_45139_)/2, p_45140_));
            }
        }
        else{
            cir.setReturnValue(moreEnchantments$getFire(advanced_fire,p_45140_));
        }
    }

    @Inject(method = "getExplosionKnockbackAfterDampener",at = @At("RETURN"),cancellable = true)
    private static void exp(LivingEntity p_45136_, double p_45137_, CallbackInfoReturnable<Double> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedBlastProtection,p_45136_)*2;
        if(advanced_fire==0){
            if(EnchantmentHelper.getEnchantmentLevel(Enchantments.BLAST_PROTECTION, p_45136_)==0){
                cir.setReturnValue(moreEnchantments$getExp(getEnchantmentLevel(MoreEnchantmentsRegistry.basicBlastProtection,p_45136_)/2, p_45137_));
            }
        }
        else{
            cir.setReturnValue(moreEnchantments$getExp(advanced_fire,p_45137_));
        }
    }

    @Unique
    private static int moreEnchantments$getFire(int i, int p_45140_){
        if(i<0){
            p_45140_ -= Mth.floor((float)p_45140_ * (float)i * 0.15F);
        }
        return p_45140_;
    }

    @Unique
    private static double moreEnchantments$getExp(int i, double p_45137_){
        if(i<0){
            p_45137_ *= Mth.clamp(1.0D - (double)i * 0.15D, 0.0D, 1.0D);
        }
        return p_45137_;
    }
}
