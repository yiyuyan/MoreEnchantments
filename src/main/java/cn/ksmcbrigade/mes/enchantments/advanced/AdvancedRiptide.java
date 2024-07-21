package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.TridentLoyaltyEnchantment;
import net.minecraft.world.item.enchantment.TridentRiptideEnchantment;

public class AdvancedRiptide extends TridentRiptideEnchantment {
    public AdvancedRiptide() {
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
        return 12 + p_45244_ * 9;
    }
}
