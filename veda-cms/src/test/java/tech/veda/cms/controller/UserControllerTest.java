package tech.veda.cms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tech.veda.cms.Constants;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Bruno
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void testFindUsers() throws Exception {
    mvc.perform(get("/users")
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("total", greaterThanOrEqualTo(10)));
  }

  @Test
  void testCreateUser() throws Exception {
    mvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
        .content("""
          {
            "username": "admin3_so_good",
            "gender": "MALE",
            "avatar": "https://picsum.photos/id/237/100",
            "organizationId": 1
          }
          """))
      .andExpect(status().isCreated())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("username", is("admin3_so_good")));
  }

  @Test
  void testUpdateUser() throws Exception {
    mvc.perform(put("/users/{userId}", 1)
        .contentType(MediaType.APPLICATION_JSON)
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
        .content("""
          {
            "gender": "FEMALE",
            "avatar": "https://picsum.photos/id/237/100",
            "organizationId": 1
          }
          """))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("username", is("admin")));
  }

  @Test
  void testDeleteUser() throws Exception {
    mvc.perform(delete("/users/{userId}", 301)
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isNoContent());
  }

  @Test
  void testDisableUser() throws Exception {
    mvc.perform(post("/users/{userId}:disable", 302)
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isOk());
  }

  @Test
  void testEnableUser() throws Exception {
    mvc.perform(post("/users/{userId}:enable", 302)
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isOk());
  }

}
