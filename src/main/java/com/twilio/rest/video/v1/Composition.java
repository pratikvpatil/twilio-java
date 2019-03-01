/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Composition extends Resource {
    private static final long serialVersionUID = 61658716109908L;

    public enum Status {
        ENQUEUED("enqueued"),
        PROCESSING("processing"),
        COMPLETED("completed"),
        DELETED("deleted"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    public enum Format {
        MP4("mp4"),
        WEBM("webm");

        private final String value;

        private Format(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Format from a string.
         * @param value string value
         * @return generated Format
         */
        @JsonCreator
        public static Format forValue(final String value) {
            return Promoter.enumFromString(value, Format.values());
        }
    }

    /**
     * Create a CompositionFetcher to execute fetch.
     * 
     * @param pathSid The Composition Sid that uniquely identifies the Composition
     *                to fetch.
     * @return CompositionFetcher capable of executing the fetch
     */
    public static CompositionFetcher fetcher(final String pathSid) {
        return new CompositionFetcher(pathSid);
    }

    /**
     * Create a CompositionReader to execute read.
     * 
     * @return CompositionReader capable of executing the read
     */
    public static CompositionReader reader() {
        return new CompositionReader();
    }

    /**
     * Create a CompositionDeleter to execute delete.
     * 
     * @param pathSid The Recording Composition Sid that uniquely identifies the
     *                Recording Composition to delete.
     * @return CompositionDeleter capable of executing the delete
     */
    public static CompositionDeleter deleter(final String pathSid) {
        return new CompositionDeleter(pathSid);
    }

    /**
     * Create a CompositionCreator to execute create.
     * 
     * @param roomSid Twilio Room SID.
     * @return CompositionCreator capable of executing the create
     */
    public static CompositionCreator creator(final String roomSid) {
        return new CompositionCreator(roomSid);
    }

    /**
     * Converts a JSON String into a Composition object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Composition object represented by the provided JSON
     */
    public static Composition fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Composition.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Composition object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Composition object represented by the provided JSON
     */
    public static Composition fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Composition.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Composition.Status status;
    private final DateTime dateCreated;
    private final String dateCompleted;
    private final String dateDeleted;
    private final String sid;
    private final String roomSid;
    private final List<String> audioSources;
    private final List<String> audioSourcesExcluded;
    private final Map<String, Object> videoLayout;
    private final String resolution;
    private final Boolean trim;
    private final Composition.Format format;
    private final Integer bitrate;
    private final Long size;
    private final Integer duration;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Composition(@JsonProperty("account_sid")
                        final String accountSid, 
                        @JsonProperty("status")
                        final Composition.Status status, 
                        @JsonProperty("date_created")
                        final String dateCreated, 
                        @JsonProperty("date_completed")
                        final String dateCompleted, 
                        @JsonProperty("date_deleted")
                        final String dateDeleted, 
                        @JsonProperty("sid")
                        final String sid, 
                        @JsonProperty("room_sid")
                        final String roomSid, 
                        @JsonProperty("audio_sources")
                        final List<String> audioSources, 
                        @JsonProperty("audio_sources_excluded")
                        final List<String> audioSourcesExcluded, 
                        @JsonProperty("video_layout")
                        final Map<String, Object> videoLayout, 
                        @JsonProperty("resolution")
                        final String resolution, 
                        @JsonProperty("trim")
                        final Boolean trim, 
                        @JsonProperty("format")
                        final Composition.Format format, 
                        @JsonProperty("bitrate")
                        final Integer bitrate, 
                        @JsonProperty("size")
                        final Long size, 
                        @JsonProperty("duration")
                        final Integer duration, 
                        @JsonProperty("url")
                        final URI url, 
                        @JsonProperty("links")
                        final Map<String, String> links) {
        this.accountSid = accountSid;
        this.status = status;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateCompleted = dateCompleted;
        this.dateDeleted = dateDeleted;
        this.sid = sid;
        this.roomSid = roomSid;
        this.audioSources = audioSources;
        this.audioSourcesExcluded = audioSourcesExcluded;
        this.videoLayout = videoLayout;
        this.resolution = resolution;
        this.trim = trim;
        this.format = format;
        this.bitrate = bitrate;
        this.size = size;
        this.duration = duration;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The Twilio Account SID..
     * 
     * @return Twilio Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The status of the Composition..
     * 
     * @return The status of the Composition.
     */
    public final Composition.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The Date when the Composition Resource was created..
     * 
     * @return Date when the Composition Resource was created.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The Date when the media processing task finished..
     * 
     * @return Date when the media processing task finished.
     */
    public final String getDateCompleted() {
        return this.dateCompleted;
    }

    /**
     * Returns The Date when the Composition Resource generated media was deleted..
     * 
     * @return Date when the Composition Resource generated media was deleted.
     */
    public final String getDateDeleted() {
        return this.dateDeleted;
    }

    /**
     * Returns The A 34-character string that uniquely identifies this Composition..
     * 
     * @return A 34-character string that uniquely identifies this Composition.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The A 34-character string that uniquely identifies the source of this
     * Composition..
     * 
     * @return A 34-character string that uniquely identifies the source of this
     *         Composition.
     */
    public final String getRoomSid() {
        return this.roomSid;
    }

    /**
     * Returns The A list of audio sources related to this Composition..
     * 
     * @return A list of audio sources related to this Composition.
     */
    public final List<String> getAudioSources() {
        return this.audioSources;
    }

    /**
     * Returns The A list of audio sources excluded related to this Composition..
     * 
     * @return A list of audio sources excluded related to this Composition.
     */
    public final List<String> getAudioSourcesExcluded() {
        return this.audioSourcesExcluded;
    }

    /**
     * Returns The The JSON video layout description..
     * 
     * @return The JSON video layout description.
     */
    public final Map<String, Object> getVideoLayout() {
        return this.videoLayout;
    }

    /**
     * Returns The Pixel resolution of the composed video..
     * 
     * @return Pixel resolution of the composed video.
     */
    public final String getResolution() {
        return this.resolution;
    }

    /**
     * Returns The Boolean flag for clipping intervals that have no media..
     * 
     * @return Boolean flag for clipping intervals that have no media.
     */
    public final Boolean getTrim() {
        return this.trim;
    }

    /**
     * Returns The The file format for this Composition..
     * 
     * @return The file format for this Composition.
     */
    public final Composition.Format getFormat() {
        return this.format;
    }

    /**
     * Returns The The bitrate.
     * 
     * @return The bitrate
     */
    public final Integer getBitrate() {
        return this.bitrate;
    }

    /**
     * Returns The Size of the Composed media file expressed in bytes..
     * 
     * @return Size of the Composed media file expressed in bytes.
     */
    public final Long getSize() {
        return this.size;
    }

    /**
     * Returns The Duration of the Composed media in seconds..
     * 
     * @return Duration of the Composed media in seconds.
     */
    public final Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns The The absolute URL for this resource..
     * 
     * @return The absolute URL for this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The JSON object with the URL where the media file can be fetched..
     * 
     * @return JSON object with the URL where the media file can be fetched.
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Composition other = (Composition) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(status, other.status) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateCompleted, other.dateCompleted) && 
               Objects.equals(dateDeleted, other.dateDeleted) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(roomSid, other.roomSid) && 
               Objects.equals(audioSources, other.audioSources) && 
               Objects.equals(audioSourcesExcluded, other.audioSourcesExcluded) && 
               Objects.equals(videoLayout, other.videoLayout) && 
               Objects.equals(resolution, other.resolution) && 
               Objects.equals(trim, other.trim) && 
               Objects.equals(format, other.format) && 
               Objects.equals(bitrate, other.bitrate) && 
               Objects.equals(size, other.size) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            status,
                            dateCreated,
                            dateCompleted,
                            dateDeleted,
                            sid,
                            roomSid,
                            audioSources,
                            audioSourcesExcluded,
                            videoLayout,
                            resolution,
                            trim,
                            format,
                            bitrate,
                            size,
                            duration,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("status", status)
                          .add("dateCreated", dateCreated)
                          .add("dateCompleted", dateCompleted)
                          .add("dateDeleted", dateDeleted)
                          .add("sid", sid)
                          .add("roomSid", roomSid)
                          .add("audioSources", audioSources)
                          .add("audioSourcesExcluded", audioSourcesExcluded)
                          .add("videoLayout", videoLayout)
                          .add("resolution", resolution)
                          .add("trim", trim)
                          .add("format", format)
                          .add("bitrate", bitrate)
                          .add("size", size)
                          .add("duration", duration)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}