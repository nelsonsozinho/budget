package com.invest.wallet.controller.charge

import com.invest.wallet.TestEnvironmentConfigTest
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.get

class ChargeTest: TestEnvironmentConfigTest() {


    @Test
    fun `test get charge by id`() {
        mockMvc
            .get("/charge/{id}", "9a65975c-8490-4856-b757-db0564a5215d") {
                headers {
                    header("Authorization", getUserToken()!!)
                    header("Content-Type", "application/json")
                }
            }.andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                }
            }.andDo {
                print()
            }
    }

    @Test
    fun `list all charges`() {
        mockMvc
            .get("/charge") {
                headers {
                    header("Authorization", getUserToken()!!)
                    header("Content-Type", "application/json")
                }
            }.andExpect {
                status { isOk() }
                content {contentType(MediaType.APPLICATION_JSON)}
                jsonPath("$") {
                    isNotEmpty()
                }
            }.andDo {
                print()
            }
    }

}