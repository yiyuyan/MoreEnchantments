package cn.ksmcbrigade.mes.enchantments.basic;

import cn.ksmcbrigade.mes.MoreEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class BasicProtection extends ProtectionEnchantment {
    public BasicProtection(Type type) {
        super(Rarity.UNCOMMON, type, MoreEnchantments.ARMOR_SLOTS);
    }

    @Override
    public int getDamageProtection(int p_45133_, DamageSource p_45134_) {
        return super.getDamageProtection(p_45133_, p_45134_)+p_45133_;
    }
}
