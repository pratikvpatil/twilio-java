/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.conference;

import com.google.common.collect.Range;
import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.LocalDate;

public class RecordingReader extends Reader<Recording> {
    private String pathAccountSid;
    private final String pathConferenceSid;
    private LocalDate absoluteDateCreated;
    private Range<LocalDate> rangeDateCreated;

    /**
     * Construct a new RecordingReader.
     * 
     * @param pathConferenceSid Read by unique Conference SID for the recording
     */
    public RecordingReader(final String pathConferenceSid) {
        this.pathConferenceSid = pathConferenceSid;
    }

    /**
     * Construct a new RecordingReader.
     * 
     * @param pathAccountSid The SID of the Account that created the resources to
     *                       read
     * @param pathConferenceSid Read by unique Conference SID for the recording
     */
    public RecordingReader(final String pathAccountSid, 
                           final String pathConferenceSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathConferenceSid = pathConferenceSid;
    }

    /**
     * The `date_created` value, specified as `YYYY-MM-DD`, of the resources to
     * read. You can also specify inequality: `DateCreated&lt;=YYYY-MM-DD` will
     * return recordings generated at or before midnight on a given date, and
     * `DateCreated&gt;=YYYY-MM-DD` returns recordings generated at or after
     * midnight on a date..
     * 
     * @param absoluteDateCreated The `YYYY-MM-DD` value of the resources to read
     * @return this
     */
    public RecordingReader setDateCreated(final LocalDate absoluteDateCreated) {
        this.rangeDateCreated = null;
        this.absoluteDateCreated = absoluteDateCreated;
        return this;
    }

    /**
     * The `date_created` value, specified as `YYYY-MM-DD`, of the resources to
     * read. You can also specify inequality: `DateCreated&lt;=YYYY-MM-DD` will
     * return recordings generated at or before midnight on a given date, and
     * `DateCreated&gt;=YYYY-MM-DD` returns recordings generated at or after
     * midnight on a date..
     * 
     * @param rangeDateCreated The `YYYY-MM-DD` value of the resources to read
     * @return this
     */
    public RecordingReader setDateCreated(final Range<LocalDate> rangeDateCreated) {
        this.absoluteDateCreated = null;
        this.rangeDateCreated = rangeDateCreated;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Recording ResourceSet
     */
    @Override
    public ResourceSet<Recording> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Recording ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Recording> firstPage(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Conferences/" + this.pathConferenceSid + "/Recordings.json",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     * 
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Recording ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Recording> getPage(final String targetUrl, final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Recording> nextPage(final Page<Recording> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Recording> previousPage(final Page<Recording> page, 
                                        final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Recording Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Recording> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Recording read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Page.fromJson(
            "recordings",
            response.getContent(),
            Recording.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (absoluteDateCreated != null) {
            request.addQueryParam("DateCreated", absoluteDateCreated.toString(Request.QUERY_STRING_DATE_FORMAT));
        } else if (rangeDateCreated != null) {
            request.addQueryDateRange("DateCreated", rangeDateCreated);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}