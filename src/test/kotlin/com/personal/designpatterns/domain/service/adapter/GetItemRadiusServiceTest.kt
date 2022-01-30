package com.personal.designpatterns.domain.service.adapter

import com.personal.designpatterns.domain.service.withoutadapter.RoundItem1
import com.personal.designpatterns.domain.service.withoutadapter.RoundItem2
import com.personal.designpatterns.domain.service.withoutadapter.SquareItem
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GetItemRadiusServiceTest {

    @InjectMockKs
    private lateinit var holeFitService: HoleFitService

    @MockK
    private lateinit var squarePegAdapter: SquarePegAdapter

    @MockK
    private lateinit var roundItem1: RoundItem1

    @MockK
    private lateinit var roundItem2: RoundItem2

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `return fitted items`() {
        every {
            squarePegAdapter.getRadius()
        } returns 10.0

        every {
            roundItem1.getRadius()
        } returns 20.0

        every {
            roundItem2.getRadius()
        } returns 5.0

        val response = holeFitService.itemFitWithRadius()
    }


}