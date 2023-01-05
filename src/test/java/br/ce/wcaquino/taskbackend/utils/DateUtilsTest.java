package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void shouldReturnTrueForFutureDate() {
        LocalDate date = LocalDate.of(2030, 01, 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnFalseForPastDate() {
        LocalDate date = LocalDate.of(2000, 01, 01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }

    @Test(expected = DateTimeException.class)
    public void shouldReturnExceptionWorstDate() {
        LocalDate date = LocalDate.of(0, 50, 01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }
}
