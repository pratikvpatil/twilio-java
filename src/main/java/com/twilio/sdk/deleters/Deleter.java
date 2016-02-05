package com.twilio.sdk.deleters;

import com.google.common.util.concurrent.ListenableFuture;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.resources.Resource;

import java.util.concurrent.Callable;

public abstract class Deleter<T extends Resource> {

    public void execute() {
        execute(Twilio.getRestClient());
    }

    public abstract void execute(final TwilioRestClient client);

    public ListenableFuture async() {
        return async(Twilio.getRestClient());
    }

    public ListenableFuture async(final TwilioRestClient client) {
        return Twilio.getExecutorService().submit(new Callable() {
            public Object call() {
                execute(client);
                return null;
            }
        });
    }

}