package tech.veda.cms.common;


/**
 * @author Bruno
 * @date 2022/7/22
 */
public interface EventStore {

  void append(DomainEvent aDomainEvent);

}
