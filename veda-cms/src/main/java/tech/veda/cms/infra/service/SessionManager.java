package tech.veda.cms.infra.service;

import tech.veda.cms.sys.model.UserCredential;

import java.io.Serializable;

/**
 * @author Bruno
 */
public interface SessionManager {

  void store(String key, UserCredential credential, Serializable value);

  void invalidate(String key);

  Object get(String key);

  void refresh();
}
