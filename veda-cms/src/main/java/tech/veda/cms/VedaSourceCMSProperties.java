package tech.veda.cms;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bruno
 */

@ConfigurationProperties("admin3")
public class VedaSourceCMSProperties {

  private Map<String, Event> events = new HashMap<>();

  public Map<String, Event> getEvents() {
    return events;
  }

  public void setEvents(Map<String, Event> events) {
    this.events = events;
  }

  public static class Event {
    private String text;
    private String logTemplate;

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getLogTemplate() {
      return logTemplate;
    }

    public void setLogTemplate(String logTemplate) {
      this.logTemplate = logTemplate;
    }
  }

}
