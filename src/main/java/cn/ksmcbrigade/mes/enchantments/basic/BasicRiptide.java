package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.TridentRiptideEnchantment;

public class BasicRiptide extends TridentRiptideEnchantment {
    public BasicRiptide() {
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
