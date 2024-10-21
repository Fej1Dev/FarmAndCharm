package net.satisfy.farm_and_charm.registry;

import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.satisfy.farm_and_charm.FarmAndCharm;
import net.satisfy.farm_and_charm.effect.*;
import net.satisfy.farm_and_charm.platform.EffectRegister;
import net.satisfy.farm_and_charm.util.FarmAndCharmIdentifier;

import java.util.function.Supplier;

public class MobEffectRegistry {
    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.MOB_EFFECT);
    private static final Registrar<MobEffect> MOB_EFFECTS_REGISTRAR = MOB_EFFECTS.getRegistrar();

    public static final Holder<MobEffect> SWEETS;
    public static final Holder<MobEffect> HORSE_FODDER;
    public static final Holder<MobEffect> DOG_FOOD;
    public static final Holder<MobEffect> CLUCK;
    public static final Holder<MobEffect> GRANDMAS_BLESSING;
    public static final Holder<MobEffect> RESTED;
    public static final Holder<MobEffect> FARMERS_BLESSING;
    public static final Holder<MobEffect> SUSTENANCE;
    public static final Holder<MobEffect> SATIATION;
    public static final Holder<MobEffect> FEAST;

    private static RegistrySupplier<MobEffect> registerEffect(String name, Supplier<MobEffect> effect) {
        if (Platform.isNeoForge()) {
            return MOB_EFFECTS.register(name, effect);
        }
        return MOB_EFFECTS_REGISTRAR.register(FarmAndCharmIdentifier.of(name), effect);
    }

    public static void init() {
        FarmAndCharm.LOGGER.debug("Registering MobEffects for " + FarmAndCharm.MOD_ID);
        MOB_EFFECTS.register();
    }

    static {
        SWEETS = EffectRegister.registerEffect("sweets", SweetsEffect::new);
        HORSE_FODDER = EffectRegister.registerEffect("horse_fodder", HorseFodderEffect::new);
        DOG_FOOD = EffectRegister.registerEffect("dog_food", DogFoodEffect::new);
        CLUCK = EffectRegister.registerEffect("cluck", ChickenEffect::new);
        GRANDMAS_BLESSING = EffectRegister.registerEffect("grandmas_blessing", GrandmasBlessingEffect::new);
        RESTED = EffectRegister.registerEffect("rested", RestedEffect::new);
        FARMERS_BLESSING = EffectRegister.registerEffect("farmers_blessing", FarmersBlessingEffect::new);
        SUSTENANCE = EffectRegister.registerEffect("sustenance", SustenanceEffect::new);
        SATIATION = EffectRegister.registerEffect("satiation", SatiationEffect::new);
        FEAST = EffectRegister.registerEffect("feast", FeastEffect::new);
    }
}
