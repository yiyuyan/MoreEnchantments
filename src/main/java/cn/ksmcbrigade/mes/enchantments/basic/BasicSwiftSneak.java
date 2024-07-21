package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.SwiftSneakEnchantment;

public class BasicSwiftSneak extends SwiftSneakEnchantment {
    public BasicSwiftSneak() {
        super(Rarity.VERY_RARE, EquipmentSlot.LEGS);
    }

    public int getMinCost(int p_220310_) {
        return p_220310_ * 20;
    }

    public int getMaxCost(int p_220313_) {
        return this.getMinCost(p_220313_) + 40;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
