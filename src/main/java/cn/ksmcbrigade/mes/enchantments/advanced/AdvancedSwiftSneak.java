package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.SwiftSneakEnchantment;

public class AdvancedSwiftSneak extends SwiftSneakEnchantment {
    public AdvancedSwiftSneak() {
        super(Rarity.VERY_RARE, EquipmentSlot.LEGS);
    }

    public int getMinCost(int p_220310_) {
        return p_220310_ * 30;
    }

    public int getMaxCost(int p_220313_) {
        return this.getMinCost(p_220313_) + 80;
    }
}
