package io.github.sheralam.api.messages.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@Slf4j
public class Message implements Serializable {
    private final static long serialVersionUID = 4792253670268526729L;
    private boolean urlStripQs = false;
    private boolean preserveRecipients = false;
    private String html;
    private String text = null;
    private String subject;
    private String fromEmail;
    private String fromName;
    private List<To> to = null;
    private Headers headers;
    private boolean important;
    private boolean trackOpens = true;
    private boolean trackClicks = true;
    private boolean autoText = false;
    private boolean autoHtml = false;
    private boolean inlineCss = true;
    private boolean viewContentLink = true;
    private String bccAddress;
    private String trackingDomain;
    private String signingDomain;
    private String returnPathDomain;
    private boolean merge;
    private String mergeLanguage;
    private List<GlobalMergeVar> globalMergeVars = null;
    private List<MergeVar> mergeVars = null;
    private List<String> tags = null;
    private String subaccount = null;
    private List<String> googleAnalyticsDomains = null;
    private String googleAnalyticsCampaign;
    private Metadata metadata;
    private List<RecipientMetadata> recipientMetadata = null;
    private List<Attachment> attachments = null;
    private List<Image> images = null;

    /**
     * @param preserveRecipients
     * Always throws {@link NotImplementedException}<br/>
     * <i>To enable this, use exposeAllRecipientsIntoToHeader() instead</i>
     */
    @Deprecated
    public void setPreserveRecipients(boolean preserveRecipients) throws NotImplementedException {
        throw new NotImplementedException("Setting `true` will expose all recipients in to 'To' header for each email. To enable this, use exposeAllRecipientsIntoToHeader() instead");
    }

    public void setSenderInformation(String fromEmail, String fromName) {
        this.fromEmail = fromEmail;
        this.fromName = fromName;
    }

    public void setDomainInformation(String trackingDomain, String signingDomain, String returnPathDomain) {
        this.trackingDomain = trackingDomain;
        this.signingDomain = signingDomain;
        this.returnPathDomain = returnPathDomain;
    }

    public void setTrackingInformation(boolean trackOpens, boolean trackClicks) {
        this.trackOpens = trackOpens;
        this.trackClicks = trackClicks;
    }

    /**
     * Enable preserveRecipients. <br/><b>This will expose all recipients in to 'To' header for each email</b>
     */
    public void exposeAllRecipientsIntoToHeader(){
        log.trace("Enabling preserveRecipients. This will expose all recipients in to 'To' header for each email");
        this.preserveRecipients = true;
    }
}
