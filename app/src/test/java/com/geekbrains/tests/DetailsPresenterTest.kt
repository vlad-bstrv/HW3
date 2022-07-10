package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter
    private val view: ViewDetailsContract = mock()

    @Before
    fun setup() {
        presenter = DetailsPresenter()
        presenter.onAttach(view)
    }

    @Test
    fun detailsPresenter_Increment_ReturnsTrue() {
        presenter.onIncrement()
        verify(view).setCount(1)
    }

    @Test
    fun detailsPresenter_Decrement_ReturnTrue() {
        presenter.onDecrement()
        verify(view).setCount(-1)
    }

    @Test
    fun detailsPresenter_onDetachDontWorkingSetCount_ReturnTrue() {
        presenter.onDetach()
        presenter.onIncrement()
        verify(view, never()).setCount(anyInt())
    }

}