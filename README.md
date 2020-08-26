# Mandrill Spring Library

## Active library Since August 2020

### Functional Interfaces
`MessagesCallsService messages = MandrillClientFactory.getClientForApiKey("invalid_api").getMessages();`

`messages.send(Message message)`

`messages.sendTemplate(String templateName, TemplateContent templateContent, Message message)`

`messages.content(String id)`

`messages.cancelScheduled(String id)`

`messages.info(String id)`

`messages.listScheduled(String to)`

`messages.parse(String rawMessage)`

`messages.reschedule(String id, String sendAt)`

`messages.search(Search searchQuery)`

`messages.searchTimeSeries(SearchTimeSeries searchTimeSeries)`

`messages.sendRaw(SendRaw sendRaw)`