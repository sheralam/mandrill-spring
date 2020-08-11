package com.sheralam.mandrill.api.messages;

import com.sheralam.mandrill.api.commons.AbstractService;
import com.sheralam.mandrill.api.messages.handlers.*;
import com.sheralam.mandrill.api.messages.model.request.Message;
import com.sheralam.mandrill.api.messages.model.request.MessagePayload;
import com.sheralam.mandrill.api.messages.model.request.TemplateContent;
import com.sheralam.mandrill.api.messages.model.request.TemplatePayload;
import com.sheralam.mandrill.api.messages.model.response.IndividualSuccessResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public class MessagesCallsService extends AbstractService {
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

    final public Optional<String> content(Message message) {
        return contentHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> cancelScheduled(Message message) {
        return cancelScheduledHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> info(Message message) {
        return infoHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> listScheduled(Message message) {
        return listScheduledHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> parse(Message message) {
        return parseHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> reschedule(Message message) {
        return rescheduleHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> search(Message message) {
        return searchHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> searchTimeSeries(Message message) {
        return searchTimeSeriesHandler.apply(new MessagePayload(getApiKey(), message));
    }

    final public Optional<String> sendRaw(Message message) {
        return sendRawHandler.apply(new MessagePayload(getApiKey(), message));
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
