package com.VkDalyToolsBoot.DalyToolsBoot.core.notification;

import java.util.Map;

public class MediaHendler {

    private static Map<EnumMediaType,String> map ;

    static {
        map= Map.of(
                EnumMediaType.INFORMATION_PAGE,"photo-205388946_457239017",
                EnumMediaType.PRICE_PAGE, "photo-205388946_457239018"
                );
    }

    /**
     *
     * @param enumMediaType type of image
     * @return query like '<owner_id>_<media_id>_<access_key>'
     */
    public static String  getMediaContent(EnumMediaType enumMediaType){
        return map.get(enumMediaType);
    }

}
