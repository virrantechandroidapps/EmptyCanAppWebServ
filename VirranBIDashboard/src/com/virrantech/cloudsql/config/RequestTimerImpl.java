package com.virrantech.cloudsql.config;

import com.google.apphosting.api.ApiProxy;

class RequestTimerImpl extends RequestTimer {
    @Override
    public long getRemainingMillis() {
        return ApiProxy.getCurrentEnvironment().getRemainingMillis();
    }
}
