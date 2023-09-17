package com.company.shop.user.web;

import com.company.shop.common.UrlMapping;
import com.company.shop.security.JwtTokenAuthProvider;
import com.company.shop.security.SecurityConfigProperties;
import com.company.shop.security.token.JwtUtil;
import com.company.shop.user.service.UserService;
import com.company.shop.user.service.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;
    @MockBean
    JwtTokenAuthProvider jwtTokenAuthProvider;
    @MockBean
    SecurityConfigProperties securityConfigProperties;
    @MockBean
    private JwtUtil jwtUtil;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    void login_WhenUserNameAndPassIsCorrect_ReturnOkStatus() throws Exception {
        Mockito.when(userService.findByUsername(ArgumentMatchers.anyString())).thenReturn(new User());
        Mockito.when(jwtUtil.generateToken(ArgumentMatchers.any())).thenReturn("token");
        var request = "{\"username\": \"zohre\",\"password\": \"test\"}";
        mvc.perform(MockMvcRequestBuilders.post(UrlMapping.USER_LOGIN)
                        .contentType(APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk());
    }

}