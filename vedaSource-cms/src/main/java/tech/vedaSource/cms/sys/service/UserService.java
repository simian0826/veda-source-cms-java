package tech.vedaSource.cms.sys.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.vedaSource.cms.common.*;
import tech.vedaSource.cms.sys.event.UserCreated;
import tech.vedaSource.cms.sys.event.UserDeleted;
import tech.vedaSource.cms.sys.event.UserUpdated;
import tech.vedaSource.cms.sys.exception.UserException;
import tech.vedaSource.cms.sys.model.Organization;
import tech.vedaSource.cms.sys.model.User;
import tech.vedaSource.cms.sys.repository.UserRepository;
import tech.vedaSource.cms.sys.service.dto.OrgUserDTO;
import tech.vedaSource.cms.sys.service.dto.PageDTO;
import tech.vedaSource.cms.sys.service.dto.UserinfoDTO;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static tech.vedaSource.cms.common.CommonResultStatus.RECORD_NOT_EXIST;

/**
 * @author Bruno
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User createUser(String username, String avatar, User.Gender gender, User.State state, Organization organization) {
    User user = new User();
    user.setUsername(username);
    user.setAvatar(avatar);
    user.setGender(gender);
    user.setState(state);
    user.setCreatedTime(LocalDateTime.now());
    user.setOrganization(organization);
    user = userRepository.save(user);
    DomainEventPublisher.instance().publish(new UserCreated(user));
    return user;
  }

  public Set<User> findUserByIds(Set<Long> userIds) {
    return userRepository.findByIds(userIds);
  }

  public User findUserById(Long userId) {
    return userRepository.findById(userId)
      .orElseThrow(() -> new BusinessException(RECORD_NOT_EXIST));
  }

  public PageDTO<OrgUserDTO> findOrgUsers(Pageable pageable, String username, User.State state, Organization organization) {
    Page<User> page = userRepository.findOrgUsers(pageable, username, state, organization, organization.makeSelfAsParentIds());
    return new PageDTO<>(page.getContent().stream().map(u ->
        new OrgUserDTO(u.getId(), u.getUsername(), u.getAvatar(), u.getGender(), u.getState(), u.getOrgFullName(), u.getCreatedTime()))
      .collect(Collectors.toList()), page.getTotalElements());
  }

  public boolean existsUsers(Organization organization) {
    String orgParentIds = organization.makeSelfAsParentIds();
    return userRepository.countOrgUsers(organization, orgParentIds) > 0;
  }


  @Transactional
  public User updateUser(Long userId, String avatar, User.Gender gender, User.State state, Organization organization) {
    User user = findUserById(userId);
    user.setAvatar(avatar);
    user.setGender(gender);
    user.setState(state);
    user.setOrganization(organization);
    user = userRepository.save(user);
    DomainEventPublisher.instance().publish(new UserUpdated(user));
    return user;
  }

  @Transactional
  public User disableUser(Long userId) {
    UserinfoDTO userInfo = (UserinfoDTO) SessionItemHolder.getItem(Constants.SESSION_CURRENT_USER);
    if (Objects.equals(userInfo.userId(), userId)) {
      throw new UserException(CommonResultStatus.PARAM_ERROR, "不能禁用自己");
    }
    User user = findUserById(userId);
    user.setState(User.State.LOCKED);
    return userRepository.save(user);
  }

  @Transactional
  public User enableUser(Long userId) {
    User user = findUserById(userId);
    user.setState(User.State.NORMAL);
    return userRepository.save(user);
  }

  public PageDTO<User> findUsers(Pageable pageable, User user) {
    Page<User> page = userRepository.findAll(Example.of(user), pageable);
    return new PageDTO<>(page.getContent(), page.getTotalElements());
  }

  @Transactional
  public void delete(Long userId) {
    User user = findUserById(userId);
    userRepository.delete(user);
    DomainEventPublisher.instance().publish(new UserDeleted(user));
  }
}
