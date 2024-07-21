package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.TridentLoyaltyEnchantment;

public class AdvancedLoyalty extends TridentLoyaltyEnchantment {
    public AdvancedLoyalty() {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMaxCost(int p) {
        return 80;
    }

    public int getMinCost(int p_45244_) {
        return 7 + p_45244_ * 9;
    }
}
