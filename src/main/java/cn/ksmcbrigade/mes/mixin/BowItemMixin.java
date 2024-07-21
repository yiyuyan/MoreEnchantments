package cn.ksmcbrigade.mes.mixin;

import cn.ksmcbrigade.mes.registry.MoreEnchantmentsRegistry;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BowItem.class)
public class BowItemMixin {
    @Redirect(method = "releaseUsing",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getItemEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I"))
    public int using(Enchantment p_44844_, ItemStack p_44845_){
        if(p_44844_.equals(Enchantments.PUNCH_ARROWS)){
            int advanced_fire = EnchantmentHelper.getItemEnchantmentLevel(MoreEnchantmentsRegistry.advancedPunch,p_44845_)*4;
            if(advanced_fire==0){
                if(EnchantmentHelper.getItemEnchantmentLevel(p_44844_,p_44845_)==0){
                    return EnchantmentHelper.getItemEnchantmentLevel(MoreEnchantmentsRegistry.basicPunch,p_44845_);
                }
                else{
                    return EnchantmentHelper.getItemEnchantmentLevel(p_44844_,p_44845_);
                }
            }
            else{
                return advanced_fire;
            }
        }
        else{
            return EnchantmentHelper.getItemEnchantmentLevel(p_44844_,p_44845_);
        }
    }
}
