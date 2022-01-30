package com.personal.designpatterns.domain.service.adapter

import com.personal.designpatterns.domain.service.withoutadapter.SquareItem
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SquarePegAdapterTest {

    @InjectMockKs
    private lateinit var squarePegAdapter: SquarePegAdapter

    @MockK
    private lateinit var squarePeg: SquareItem

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `should return square peg result`() {

        every {
            squarePeg.getSquare()
        } returns 10.0

        squarePegAdapter.getRadius()
    }
}