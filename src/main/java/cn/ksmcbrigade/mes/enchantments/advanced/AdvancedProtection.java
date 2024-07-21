package cn.ksmcbrigade.mes.enchantments.advanced;

import cn.ksmcbrigade.mes.MoreEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class AdvancedProtection extends ProtectionEnchantment {
    public AdvancedProtection(Type type) {
        super(Rarity.UNCOMMON, type, MoreEnchantments.ARMOR_SLOTS);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getDamageProtection(int p_45133_, DamageSource p_45134_) {
        return super.getDamageProtection(p_45133_, p_45134_)+3*p_45133_;
    }
}
