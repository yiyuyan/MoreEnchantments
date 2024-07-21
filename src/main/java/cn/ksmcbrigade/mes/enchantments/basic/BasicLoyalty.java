package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.TridentLoyaltyEnchantment;

public class BasicLoyalty extends TridentLoyaltyEnchantment {
    public BasicLoyalty() {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMaxCost(int p) {
        return 40;
    }
}
