package com.invest.wallet.controller.wallet

import com.invest.wallet.TestEnvironmentConfigTest
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.get

class WalletTest: TestEnvironmentConfigTest() {


    @Test
    fun `test get wallet by id`() {
        mockMvc
            .get("/budget/{id}", "9a65975c-8490-4856-b757-db0564a5215d") {
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
    fun `list all wallets`() {
        mockMvc
            .get("/wallet") {
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