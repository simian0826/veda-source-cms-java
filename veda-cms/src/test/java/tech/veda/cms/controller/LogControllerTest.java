package tech.veda.cms.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tech.veda.cms.Constants;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Bruno
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
public class LogControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  @Order(0)
  void testFindLogs() throws Exception {
    mvc.perform(get("/logs")
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("total", greaterThanOrEqualTo(2)));
  }

  @Test
  @Order(1)
  void testCleanLogs() throws Exception {
    mvc.perform(delete("/logs")
        .header(Constants.TOKEN_HEADER_NAME, Constants.TOKEN)
      )
      .andExpect(status().isNoContent());
  }

}
