package com.wani.workreport.report.report.domain;

import com.wani.workreport.report.domain.Money;
import com.wani.workreport.report.domain.Ratio;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RatioTest {

    @DisplayName("퍼센트")
    @Test
    void percent() {
        Ratio tenPercent = Ratio.valueOf(0.1);
        Money thousandWon = Money.wons(1000);

        assertThat(tenPercent.of(thousandWon)).isEqualTo(Money.wons(100.0));
    }
}
