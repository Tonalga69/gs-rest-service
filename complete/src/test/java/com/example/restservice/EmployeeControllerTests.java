package com.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    /*
    * This function should return a list which cannot be empty called employees with a 200 status code
    */
    @Test
    public void employeeShouldReturnAnNonEmptyList() throws Exception {
        this.mockMvc.perform(get("/employees/")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.employees").exists())
                .andExpect(jsonPath("$.employees").isNotEmpty())
                .andExpect(jsonPath("$.employees").isArray());
    }


    /*
    * This function should return and empty body with 201 status code*/
    @Test
    void employeeAddShouldReturnCreated() throws Exception {
        Employee employee = new Employee(
                "1",
                "John",
                "Doe",
                "sales@mycompany.com",
                "Sales Manager"
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employee);


        this.mockMvc.perform(post("/employees/")
                        .contentType("application/json")
                        .content(json)
                )
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(jsonPath("$").doesNotExist());
    }
}
