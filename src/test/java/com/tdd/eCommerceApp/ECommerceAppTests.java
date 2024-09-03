package com.tdd.eCommerceApp;

import com.tdd.eCommerceApp.controllers.CustomerController;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
class ECommerceAppTests {


}
