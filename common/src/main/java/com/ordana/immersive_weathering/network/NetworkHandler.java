package com.ordana.immersive_weathering.network;

import net.mehvahdjukaar.moonlight.api.platform.network.NetworkHelper;

public class NetworkHandler {

//    public static final ChannelHandler CHANNEL = ChannelHandler.builder(ImmersiveWeathering.MOD_ID)
//            .register(NetworkDir.CLIENT_BOUND, SendCustomParticlesPacket.class, SendCustomParticlesPacket::new)
//            .build();


    public static void init() {
        NetworkHelper.addNetworkRegistration(
                NetworkHandler::registerMessages, 5);
    }
    private static void registerMessages(NetworkHelper.RegisterMessagesEvent event) {
        event.registerClientBound(SendCustomParticlesPacket.CODEC);
    }

}