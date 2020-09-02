package io.github.sheralam.api.messages;

import io.github.sheralam.api.commons.AbstractService;
import io.github.sheralam.api.messages.handlers.*;
import io.github.sheralam.api.messages.model.request.*;
import io.github.sheralam.api.messages.model.response.*;
import io.github.sheralam.api.messages.handlers.*;
import io.github.sheralam.api.messages.model.request.*;
import io.github.sheralam.api.messages.model.response.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * MessagesCallsService handles all api call related to mandrill-messages-api
 * @see <a href="https://mandrillapp.com/api/docs/messages.JSON.html">mandrill-messages-api</a>
 */
@Slf4j
public final class MessagesCallsService extends AbstractService {
    private static final long serialVersionUID = -8517582022877271344L;
    private SendMessageHandler sendMessageHandler;
    private CancelScheduledHandler cancelScheduledHandler;
    private ContentHandler contentHandler;
    private InfoHandler infoHandler;
    private ListScheduledHandler listScheduledHandler;
    private ParseHandler parseHandler;
    private RescheduleHandler rescheduleHandler;
    private SearchHandler searchHandler;
    private SearchTimeSeriesHandler searchTimeSeriesHandler;
    private SendRawHandler sendRawHandler;
    private SendTemplateHandler sendTemplateHandler;


    /**
     * @param apiKey Mandrill Api Key
     * @param restTemplateSupplier Supplier of spring boot {@link RestTemplate}
     * Creates {@link MessagesCallsService}
     */
    public MessagesCallsService(String apiKey, @NonNull Supplier<RestTemplate> restTemplateSupplier) {
        super(apiKey);
        init(restTemplateSupplier);
    }


    final public Optional<IndividualSuccessResponse[]> send(Message message) {
        return sendMessageHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<IndividualSuccessResponse[]> sendTemplate(String templateName, TemplateContent templateContent, Message message) {
        return sendTemplateHandler.apply(new TemplatePayload(getApiKey(), templateName, templateContent, message));
    }

    final public Optional<ContentResponse> content(String id) {
        return contentHandler.apply(new ContentPayload(getApiKey(),id));
    }

    final public Optional<CancelScheduledResponse> cancelScheduled(String id) {
        return cancelScheduledHandler.apply(new CancelScheduledPayload(getApiKey(), id));
    }

    final public Optional<InfoResponse> info(String id) {
        return infoHandler.apply(new InfoPayload(getApiKey(), id));
    }

    final public Optional<ListScheduledResponse[]> listScheduled(String to) {
        return listScheduledHandler.apply(new ListScheduledPayload(getApiKey(), to));
    }

    final public Optional<ParseResponse> parse(String rawMessage) {
        return parseHandler.apply(new ParsePayload(getApiKey(), rawMessage));
    }

    final public Optional<ReScheduledResponse> reschedule(String id, String sendAt) {
        return rescheduleHandler.apply(new ReScheduledPayload(getApiKey(), id, sendAt));
    }

    final public Optional<SearchResponse[]> search(Search searchQuery) {
        return searchHandler.apply(new SearchPayload(getApiKey(), searchQuery));
    }

    final public Optional<SearchTimeSeriesResponse[]> searchTimeSeries(SearchTimeSeries searchTimeSeries) {
        return searchTimeSeriesHandler.apply(new SearchTimeSeriesPayload(getApiKey(), searchTimeSeries));
    }

    final public Optional<SendRawResponse[]> sendRaw(SendRaw sendRaw) {
        return sendRawHandler.apply(new SendRawPayload(getApiKey(), sendRaw));
    }


    protected void init(@NonNull Supplier<RestTemplate> restTemplateSupplier) {
        sendMessageHandler = new SendMessageHandler(restTemplateSupplier);
        cancelScheduledHandler = new CancelScheduledHandler(restTemplateSupplier);
        contentHandler = new ContentHandler(restTemplateSupplier);
        infoHandler = new InfoHandler(restTemplateSupplier);
        listScheduledHandler = new ListScheduledHandler(restTemplateSupplier);
        parseHandler = new ParseHandler(restTemplateSupplier);
        rescheduleHandler = new RescheduleHandler(restTemplateSupplier);
        searchHandler = new SearchHandler(restTemplateSupplier);
        searchTimeSeriesHandler = new SearchTimeSeriesHandler(restTemplateSupplier);
        sendRawHandler = new SendRawHandler(restTemplateSupplier);
        sendTemplateHandler = new SendTemplateHandler(restTemplateSupplier);
    }
}
