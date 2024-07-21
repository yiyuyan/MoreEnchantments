package cn.ksmcbrigade.mes.mixin;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {
    @Shadow
    public static int getEnchantmentLevel(Enchantment p_44837_, LivingEntity p_44838_) {
        return 0;
    }

    @Shadow
    @Deprecated
    public static int getItemEnchantmentLevel(Enchantment p_44844_, ItemStack p_44845_) {
        return 0;
    }

    @Inject(method = "getKnockbackBonus",at = @At("RETURN"),cancellable = true)
    private static void getKnockbackBonus(LivingEntity p_44895_, CallbackInfoReturnable<Integer> cir){
        int advanced_knockback = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedKnockback,p_44895_)*2;
        if(advanced_knockback==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicKnockback,p_44895_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_knockback);
        }
    }

    @Inject(method = "getSneakingSpeedBonus",at = @At("RETURN"),cancellable = true)
    private static void getWalk(LivingEntity p_44895_, CallbackInfoReturnable<Float> cir){
        float advanced_knockback = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedSwiftSneak,p_44895_)*2f*0.30f;
        if(advanced_knockback==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicSwiftSneak,p_44895_)/2f*0.20f);
            }
        }
        else{
            cir.setReturnValue(advanced_knockback);
        }
    }

    @Inject(method = "getFireAspect",at = @At("RETURN"),cancellable = true)
    private static void getFire(LivingEntity p_44895_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedFireAspect,p_44895_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicFireAspect,p_44895_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }

    @Inject(method = "getDepthStrider",at = @At("RETURN"),cancellable = true)
    private static void getDepth(LivingEntity p_44895_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedDepthStrider,p_44895_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicDepthStrider,p_44895_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }

    @Inject(method = "getBlockEfficiency",at = @At("RETURN"),cancellable = true)
    private static void getEfficiency(LivingEntity p_44895_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedEfficiency,p_44895_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicEfficiency,p_44895_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }

    @Inject(method = "getFishingLuckBonus",at = @At("RETURN"),cancellable = true)
    private static void getFishLuck(ItemStack p_44905_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getItemEnchantmentLevel(MoreEnchantmentsRegistry.advancedLootBonus,p_44905_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(-getItemEnchantmentLevel(MoreEnchantmentsRegistry.unLootBonus,p_44905_)*2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }

    @Inject(method = "getMobLooting",at = @At("RETURN"),cancellable = true)
    private static void getFishLuck(LivingEntity p_44931_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getEnchantmentLevel(MoreEnchantmentsRegistry.advancedLooting,p_44931_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getEnchantmentLevel(MoreEnchantmentsRegistry.basicLooting,p_44931_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }

    @Inject(method = "getLoyalty",at = @At("RETURN"),cancellable = true)
    private static void getloy(ItemStack p_44905_, CallbackInfoReturnable<Integer> cir){
        int advanced_fire = getItemEnchantmentLevel(MoreEnchantmentsRegistry.advancedLoyalty,p_44905_)*2;
        if(advanced_fire==0){
            if(cir.getReturnValue()==0){
                cir.setReturnValue(getItemEnchantmentLevel(MoreEnchantmentsRegistry.basicLoyalty,p_44905_)/2);
            }
        }
        else{
            cir.setReturnValue(advanced_fire);
        }
    }
}
