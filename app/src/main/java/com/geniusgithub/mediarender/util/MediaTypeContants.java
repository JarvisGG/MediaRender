package com.geniusgithub.mediarender.util;

import com.geniusgithub.mediarender.center.DMRCenter;

/**
 * Created by Jarvis on 2016/6/29.
 */
public class MediaTypeContants {

    public static final String CONTENT_TYPE = "Content-Type";
    // Content-Type
    public static final String OCTET_STREAM = "application/octet-stream";
    public static final String VIDEO_TYPE = "video/*";
    public static final String MUSIC_TYPE = "audio/*";
    public static final String IMAGE_TYPE = "image/*";

    public static int AnalysisMediaType(String MediaType) {
        int curType = DMRCenter.CUR_MEDIA_TYPE_VIDEO;
        if (MediaType.matches(VIDEO_TYPE)) {
            curType = DMRCenter.CUR_MEDIA_TYPE_VIDEO;
        } else if (MediaType.matches(MUSIC_TYPE)) {
            curType = DMRCenter.CUR_MEDIA_TYPE_MUSCI;
        } else if (MediaType.matches(IMAGE_TYPE)) {
            curType = DMRCenter.CUR_MEDIA_TYPE_PICTURE;
        } else {
            curType = DMRCenter.CUR_MEDIA_TYPE_VIDEO;
        }
        return curType;
    }
}
