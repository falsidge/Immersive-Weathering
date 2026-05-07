package com.ordana.immersive_weathering.reg;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class ModArmorMaterials
{
    public static final Holder<ArmorMaterial> FLOWER_CROWN = RegHelper.registerArmorMaterial(
            ImmersiveWeathering.res("flower"),
            0,
            ()->Ingredient.of(ModItems.AZALEA_FLOWERS.get()),
            64,
            ()->SoundEvents.ARMOR_EQUIP_LEATHER,
            0f,
            0f
    );
    public static void init() {

    }
}
